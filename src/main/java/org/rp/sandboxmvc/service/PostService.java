package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.PostDao;
import org.rp.sandboxmvc.helper.PostSearchCriteria;
import org.rp.sandboxmvc.model.feed.Post;
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

    @Transactional
    public List<Post> getPosts(PostSearchCriteria criteria) {
        if (criteria.getOrderBy() == null) {
            criteria.setOrder("id", OrderDirection.DESC);
        }
        return postDao.search(criteria);
    }

    @Transactional
    public long countPosts(PostSearchCriteria criteria) {
        return postDao.count(criteria);
    }

    @Transactional
    public Post getById(Long id) {
        return postDao.getById(id);
    }


}
