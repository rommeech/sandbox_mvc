package org.rp.sandboxmvc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Post;
import org.rp.tg.botapi.type.FormatOption;
import org.rp.tg.botapi.type.User;
import org.rp.tg.botapi.http.HttpClient;
import org.rp.tg.botapi.request.GetMeRequest;
import org.rp.tg.botapi.request.RequestException;
import org.rp.tg.botapi.request.SendMessageRequest;
import org.rp.tg.botapi.response.MessageResponse;
import org.rp.tg.botapi.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "telegramService")
public class TelegramService {

    private static final Logger logger = LogManager.getLogger(TelegramService.class);

    private final ChannelService channelService;
    private final PublicationService publicationService;
    private final RequestLogService requestLogService;
    private final PostService postService;

    public TelegramService(ChannelService channelService, PublicationService publicationService, RequestLogService requestLogService, PostService postService) {
        this.channelService = channelService;
        this.publicationService = publicationService;
        this.requestLogService = requestLogService;
        this.postService = postService;
    }

    @Transactional
    public User sendGetMeRequest(String token) throws ServiceException {

        GetMeRequest request = new GetMeRequest();
        UserResponse response;
        try {
            response = request.doRequest(token);
        } catch (RequestException e) {
            logger.error("sendGetMeRequest", e);
            throw new ServiceException("GetMeRequest error", e);
        }

        this.logRequest(request.getHttpClient());

        return response.getResult();
    }

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
}
