package org.rp.sandboxmvc.service.feed;

import org.rp.sandboxmvc.dao.feed.PostDao;
import org.rp.sandboxmvc.model.feed.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "postService")
public class PostService {

    @Autowired
    PostDao postDao;

    public List<Post> getPosts() {
        return postDao.getPosts();
    }

}
