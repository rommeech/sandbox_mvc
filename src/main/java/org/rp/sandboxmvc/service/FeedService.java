package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.FeedDao;
import org.rp.sandboxmvc.model.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedService extends AbstractService {

    @Autowired
    private FeedDao feedDao;

    @Autowired
    private FeedReaderService feedReaderService;

    @Transactional(readOnly = true)
    public List<Feed> getAllFeeds() {
        return feedDao.getAllFeeds();
    }

    @Transactional(readOnly = true)
    public List<Feed> getFeeds() {
        return feedDao.getByCriteria();
    }

    @Transactional(readOnly = true)
    public Long countFeeds() {
        return feedDao.countByCriteria();
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

    public void readPosts(Feed feed) throws ServiceException {
        feedReaderService.readFeed(feed);
    }




}
