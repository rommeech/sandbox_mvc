package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.dao.FeedDao;
import org.rp.sandboxmvc.model.Feed;
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


    @Transactional(readOnly = true)
    public List<Feed> getAllFeeds() {
        return feedDao.getAllFeeds();
    }

    @Transactional(readOnly = true)
    public List<Feed> getFeeds(SearchCriteria criteria) {
        if (criteria.getOrderBy() == null) {
            criteria.setOrderBy("id");
        }
        return feedDao.search(criteria);
    }

    @Transactional(readOnly = true)
    public Long countFeeds(SearchCriteria criteria) {
        return feedDao.count(criteria);
    }

    @Transactional(readOnly = true)
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

}
