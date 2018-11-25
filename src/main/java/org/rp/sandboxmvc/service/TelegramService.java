package org.rp.sandboxmvc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Post;
import org.rp.telegram.botapi.entity.FormatOption;
import org.rp.telegram.botapi.entity.User;
import org.rp.telegram.botapi.http.HttpClient;
import org.rp.telegram.botapi.request.AbstractApiRequest;
import org.rp.telegram.botapi.request.GetMeRequest;
import org.rp.telegram.botapi.request.RequestException;
import org.rp.telegram.botapi.request.SendMessageRequest;
import org.rp.telegram.botapi.response.MessageResponse;
import org.rp.telegram.botapi.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "telegramService")
public class TelegramService {

    private static final Logger logger = LogManager.getLogger(TelegramService.class);

    @Autowired
    private ChannelService channelService;

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private RequestLogService requestLogService;

    @Autowired
    private PostService postService;

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
                client.getHttpResponse()
        );
    }
}
