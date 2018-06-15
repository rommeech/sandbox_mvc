package org.rp.sandboxmvc.service.feed;

import org.rp.sandboxmvc.dao.AbstractDao;
import org.rp.sandboxmvc.dao.feed.PostDao;
import org.rp.sandboxmvc.model.AbstractModel;
import org.rp.sandboxmvc.model.feed.Feed;
import org.rp.sandboxmvc.model.feed.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(value = "postService")
public class PostService {

    @Autowired
    PostDao postDao;

    public List<Post> search(Map<String, String> requestParams) {

        return postDao.createDaoSearchCriteriaBuilder()
                .setOrder("id")
                .setLimit(10)
                .getAll();
    }


}
