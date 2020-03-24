package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getPosts();

    Long countPosts();

    Post getById(Long id);

    List<Post> getUnpublishedPostsByChannel(Channel channel);

    List<Post> getUnpublishedPostsByChannel(Channel channel, int limit);
}
