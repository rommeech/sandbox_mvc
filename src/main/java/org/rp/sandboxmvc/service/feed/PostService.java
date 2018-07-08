package org.rp.sandboxmvc.service.feed;

import org.rp.sandboxmvc.dao.feed.PostDao;
import org.rp.sandboxmvc.helper.PostSearchCriteria;
import org.rp.sandboxmvc.model.feed.Post;
import org.rp.sandboxmvc.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "postService")
public class PostService extends AbstractService {

    @Autowired
    PostDao postDao;

    @Transactional
    public List<Post> list(PostSearchCriteria searchCriteria) {
        return postDao.search(searchCriteria);
    }

    @Transactional
    public Post getById(Long id) {
        return postDao.getById(id);
    }


}
