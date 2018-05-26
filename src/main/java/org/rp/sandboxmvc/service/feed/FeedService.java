package org.rp.sandboxmvc.service.feed;

import org.rp.sandboxmvc.dao.feed.FeedDao;
import org.rp.sandboxmvc.model.feed.Feed;

import java.util.List;

public class FeedService {

    private FeedDao feedDao;

    public FeedService() {
        this.feedDao = new FeedDao();
    }

    public FeedService(FeedDao feedDao) {
        this.feedDao = feedDao;
    }

    public List<Feed> getAll() {
       return feedDao.getAll();
    }

    public Feed getById(Long id) {
        return feedDao.getById(id);
    }

    public void insert(Feed model) {
        feedDao.insert(model);
    }

    public void update(Feed model) {
        feedDao.update(model);
    }

    public void delete(Feed model) {
        feedDao.delete(model);
    }

    public void setFeedDao(FeedDao feedDao) {
        this.feedDao = feedDao;
    }
}
