package org.rp.sandboxmvc.service.feed;

import org.rp.sandboxmvc.dao.feed.FeedDao;
import org.rp.sandboxmvc.model.feed.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service(value = "feedService")
public class FeedService {

    @Autowired
    @Qualifier("feedDao")
    private FeedDao feedDao;

    public void setFeedDao(FeedDao feedDao) {
        this.feedDao = feedDao;
    }

    @Transactional
    public List<Feed> getAll() {
       return feedDao.getAll();
    }

    @Transactional
    public Feed getById(Long id) {
        return feedDao.getById(id);
    }

    @Transactional
    public void insert(Feed model) {
        feedDao.insert(model);
    }

    @Transactional
    public void update(Feed model) {
        feedDao.update(model);
    }

    @Transactional
    public void delete(Feed model) {
        feedDao.delete(model);
    }
}
