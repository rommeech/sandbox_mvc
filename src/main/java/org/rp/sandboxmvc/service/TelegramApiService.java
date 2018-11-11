package org.rp.sandboxmvc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Post;
import org.rp.telegram.botapi.entity.User;
import org.rp.telegram.botapi.request.GetMeRequest;
import org.rp.telegram.botapi.request.RequestException;
import org.rp.telegram.botapi.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "telegramApiService")
public class TelegramApiService {

    public static final Logger logger = LogManager.getLogger(TelegramApiService.class);

    @Autowired
    private ChannelService channelService;

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

        return response.getResult();
    }

    public void sendPostsToChannels() {
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
        return postService.getUnpublishedPostsByChannel(channel);
    }

    private void sendPostToChannel(Channel channel, Post post) {
    }
}
