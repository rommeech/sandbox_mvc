package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.ModelException;

import java.util.List;

public interface FeedService {

    List<Feed> getAllFeeds();

    List<Feed> getFeeds();

    Long countFeeds();

    Feed getById(Long id);

    void insert(Feed model);

    void update(Feed model);

    void delete(Long id);

    void readFeed(Feed feed) throws ServiceException;

    Feed newFeed() throws ModelException;

}
