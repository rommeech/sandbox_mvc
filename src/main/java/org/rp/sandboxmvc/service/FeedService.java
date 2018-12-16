package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.model.Feed;

import java.util.List;

public interface FeedService {

    List<Feed> getAllFeeds();

    List<Feed> getFeeds();

    Long countFeeds();

    Feed getById(Long id);

    void insert(Feed model);

    void update(Feed model);

    void delete(Long id);

    void readPosts(Feed feed) throws ServiceException;

}
