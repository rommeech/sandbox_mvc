package org.rp.sandboxmvc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Post;
import org.rp.telegram.botapi.TelegramBotApi;
import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.requestmodel.SendMessageRequestModel;
import org.rp.telegram.botapi.type.Message;
import org.rp.telegram.botapi.type.User;
import org.rp.telegram.botapi.util.ParseMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "telegramService")
public class TelegramService {

    private static final Logger LOGGER = LogManager.getLogger(TelegramService.class);

    private static final int MESSAGES_LIMIT = 1;

    private static final TelegramBotApi BOT_API_CLIENT = new TelegramBotApi();


    private final ChannelService channelService;
    private final PostService postService;

    public TelegramService(ChannelService channelService, PostService postService) {
        this.channelService = channelService;
        this.postService = postService;
    }

    /*
    private final PublicationService publicationService;
    private final RequestLogService requestLogService;

    public TelegramService(
            ChannelService channelService,
            PublicationService publicationService,
            RequestLogService requestLogService,
            PostService postService) {
        this.channelService = channelService;
        this.publicationService = publicationService;
        this.requestLogService = requestLogService;
        this.postService = postService;
    }
    */

    public User getMe(String token) throws ServiceException {
        User user;
        try {
            user = BOT_API_CLIENT.getMe(token);
        } catch (BotApiException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public void sendMessagesToChannels() {
        List<Channel> channels = channelService.getActiveChannels();
        for (Channel channel : channels) {
            this.sendMessagesToChannel(channel);
        }
    }

    private void sendMessagesToChannel(Channel channel) {
        List<Post> posts = postService.getUnpublishedPostsByChannel(channel, MESSAGES_LIMIT);
        for (Post post : posts) {
            this.sendMessageToChannel(channel, post);
        }
    }

    private void sendMessageToChannel(Channel channel, Post post) {
        LOGGER.info("sendMessageToChannel: channel=" + channel.getName() + " post=" + post.getTitle());
        LOGGER.info("Post: " + post);

        SendMessageRequestModel requestModel = new SendMessageRequestModel.Builder()
                .chatId(channel.getUsername())
                .text(buildHtmlText(post))
                .parseMode(ParseMode.HTML)
                .build();
        TelegramBotApi tgBotApi = new TelegramBotApi();
        try {
            LOGGER.info(channel.getBot().getToken());
            Message message = tgBotApi.sendMessage(channel.getBot().getToken(), requestModel);
            LOGGER.info(message);
        } catch (BotApiException e) {
            LOGGER.error("Cannot send message", e);
        }

    }

    private String buildHtmlText(Post post) {
        return "<p><b>" + post.getTitle() + "</b></p>" +
                post.getContent() +
                "<p><a href=\"" + post.getPostUrl() + "\">" + post.getPostUrl() + "</a></p>";
    }

    /*
    public void sendPostsToChannels() throws RequestException {
        List<Channel> channels = getActiveChannels();
        for (Channel channel : channels) {
            List<Post> posts = getUnpublishedPostsByChannel(channel);
            for (Post post : posts) {
                sendPostToChannel(channel, post);
            }
        }
    }

    private List<Channel> getActiveChannels() {
        return channelService.getActiveChannels();
    }

    private List<Post> getUnpublishedPostsByChannel(Channel channel) {
        return postService.getUnpublishedPostsByChannel(channel, 1);
    }

    private void sendPostToChannel(Channel channel, Post post) throws RequestException {
        SendMessageRequest request = new SendMessageRequest.Builder()
                .chatId(channel.getUsername())
                .parseMode(FormatOption.HTML)
                .text(post.getContent())
                .build();
        MessageResponse messageResponse = request.doRequest(channel.getBot().getToken());
    }

    private void logRequest(HttpClient client) {
        requestLogService.logRequest(
                client.getApiMethod().getMethodName(),
                client.getHttpRequestDuration(),
                client.getHttpRequest(),
                client.getHttpResponse(),
                client.getRawResponseBody()
        );
    }
    */

}
