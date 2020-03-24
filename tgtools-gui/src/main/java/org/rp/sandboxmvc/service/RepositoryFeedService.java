package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.FeedDao;
import org.rp.sandboxmvc.helper.Status;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.ModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service(value = "feedService")
public class RepositoryFeedService implements FeedService {

    private static final Long NEW_FEED_JOB_INTERVAL = 600_000L;

    @Autowired
    private FeedDao feedDao;

    @Autowired
    private FeedReaderService feedReaderService;

    public RepositoryFeedService() {
    }

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

    public Feed newFeed() throws ModelException {
        return new Feed.Builder()
                .status(Status.NEW)
                .jobInterval(NEW_FEED_JOB_INTERVAL)
                .nextJob(new Timestamp(new Date().getTime() + NEW_FEED_JOB_INTERVAL))
                .build();
    }

    public void readFeed(Feed feed) throws ServiceException {
        feedReaderService.readFeed(feed);
    }

}
