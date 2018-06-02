package org.rp.sandboxmvc.service.feed;

import org.rp.sandboxmvc.dao.feed.FeedDao;
import org.rp.sandboxmvc.model.feed.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {

    @Autowired
    private FeedDao feedDao;

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
}
