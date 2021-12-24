package org.rp.sandboxmvc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.ModelException;
import org.rp.sandboxmvc.model.Post;
import org.rp.sandboxmvc.model.Publication;
import org.rp.telegram.botapi.TelegramBotApi;
import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.requestmodel.SendMessageRequestModel;
import org.rp.telegram.botapi.type.Message;
import org.rp.telegram.botapi.type.User;
import org.rp.telegram.botapi.util.ParseMode;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.rp.telegram.botapi.util.MarkdownV2Tools.html2markdown;

@Service(value = "telegramService")
public class TelegramService {

    private static final Logger LOGGER = LogManager.getLogger(TelegramService.class);

    private static final int MESSAGES_LIMIT = 1;

    private static final TelegramBotApi BOT_API_CLIENT = new TelegramBotApi();


    private final ChannelService channelService;
    private final PostService postService;
    private final PublicationService publicationService;

    public TelegramService(ChannelService channelService,
                           PostService postService,
                           PublicationService publicationService) {
        this.channelService = channelService;
        this.postService = postService;
        this.publicationService = publicationService;
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

        SendMessageRequestModel requestModel = buildSendMessageRequestModel(channel, post);

        TelegramBotApi tgBotApi = new TelegramBotApi();
        try {
            //LOGGER.info(channel.getBot().getToken());
            Message message = tgBotApi.sendMessage(channel.getBot().getToken(), requestModel);
            LOGGER.info(message);

            if (message != null) {
                savePublication(channel, post);
            }

        } catch (ModelException | BotApiException e) {
            LOGGER.error("Something wrong with sending message", e);
        }
    }

    private void savePublication(Channel channel, Post post) throws ModelException {
        Publication publication = new Publication.Builder()
                .isSuccessful(true)
                .channel(channel)
                .post(post)
                .build();
        publicationService.insert(publication);
    }

    private SendMessageRequestModel buildSendMessageRequestModel(Channel channel, Post post) {
        SendMessageRequestModel.Builder builder = new SendMessageRequestModel.Builder()
                .chatId(channel.getUsername());

        // TODO: WTF?
        LOGGER.info(String.format("PostId=%s\nUlt=%s\nTitle=%s\nContent=%s\nMarkdownV2=%s",
                post.getId(),
                post.getPostUrl(),
                post.getTitle(),
                post.getContent(),
                html2markdown(post.getContent())
                ));

        if (channel.getId() == 1) {
            builder.text(buildMarkdownV2LinkFromPost(post))
                    .parseMode(ParseMode.MARKDOWNV2);
        }
        else {
            builder.text(buildMarkdownV2Post(post))
                    .parseMode(ParseMode.MARKDOWNV2);
            //builder.text(buildHtmlText(post))
            //        .parseMode(ParseMode.HTML);
        }

        return builder.build();
    }

    private String buildMarkdownV2Post(Post post) {

        String markdown = html2markdown(post.getContent());

        if (markdown != null && markdown.replace("", "") != "") {
            return "*" + post.getTitle() + "*\n" +
                    markdown + "\n" +
                    markdownV2InlineURL(post.getPostUrl(), post.getPostUrl());
        }
        else {
            return buildMarkdownV2LinkFromPost(post);
        }


    }

    private String buildMarkdownV2LinkFromPost(Post post) {
        return markdownV2InlineURL(escapeChars(post.getTitle()), post.getPostUrl());
    }

    private String markdownV2InlineURL(String title, String url) {
        return String.format("[%s](%s)", escapeChars(title), url);
    }

    //private String

    private String escapeChars(String text) {
        return text.replaceAll("([^\\w\\s])", "\\\\$1");
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
