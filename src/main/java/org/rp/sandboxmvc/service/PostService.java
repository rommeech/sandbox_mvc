package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.PostDao;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.helper.PostSearchCriteria;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "postService")
public class PostService extends AbstractService {

    private final PostDao postDao;

    @Autowired
    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    @Transactional(readOnly = true)
    public List<Post> getPosts(PostSearchCriteria criteria) {
        if (criteria.getOrderBy() == null) {
            criteria.setOrder("id", OrderDirection.DESC);
        }
        return postDao.search(criteria);
    }

    @Transactional(readOnly = true)
    public long countPosts(PostSearchCriteria criteria) {
        return postDao.count(criteria);
    }

    @Transactional(readOnly = true)
    public Post getById(Long id) {
        return postDao.getById(id);
    }

    @Transactional(readOnly = true)
    public List<Post> getUnpublishedPosts(Feed feed) {
        return postDao.getUnpublishedPostsByFeed(feed);
    }


}
