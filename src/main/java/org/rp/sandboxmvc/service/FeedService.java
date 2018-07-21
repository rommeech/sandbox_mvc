package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.dao.FeedDao;
import org.rp.sandboxmvc.model.feed.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedService {

    private final FeedDao feedDao;

    @Autowired
    public FeedService(FeedDao feedDao) {
        this.feedDao = feedDao;
    }

    @Transactional
    public List<Feed> getFeeds(SearchCriteria criteria) {
        if (criteria.getOrderBy() == null) {
            criteria.setOrderBy("id");
        }
        return feedDao.search(criteria);
    }

    @Transactional
    public Long countFeeds(SearchCriteria criteria) {
        return feedDao.count(criteria);
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
    public void delete(Long id) {
        feedDao.delete(this.getById(id));
    }

    @Transactional
    public List<Feed> getAllFeeds() {
        return feedDao.getAllFeeds();
    }
}
