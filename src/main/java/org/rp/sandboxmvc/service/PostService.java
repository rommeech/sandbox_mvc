package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.PostDao;
import org.rp.sandboxmvc.model.Channel;
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
    public List<Post> getPosts() {
        return postDao.getByCriteria();
    }

    @Transactional(readOnly = true)
    public long countPosts() {
        return postDao.countByCriteria();
    }

    @Transactional(readOnly = true)
    public Post getById(Long id) {
        return postDao.getById(id);
    }

    @Transactional(readOnly = true)
    public List<Post> getUnpublishedPostsByChannel(Channel channel) {
        return getUnpublishedPostsByChannel(channel, 100);
    }

    @Transactional(readOnly = true)
    public List<Post> getUnpublishedPostsByChannel(Channel channel, int limit) {
        return postDao.getUnpublishedPostsByChannel(channel, limit);
    }
}
