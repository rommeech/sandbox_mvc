package org.rp.sandboxmvc.service.feed;

import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.dao.feed.PostDao;
import org.rp.sandboxmvc.model.feed.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "postService")
public class PostService {

    @Autowired
    PostDao postDao;

    public List<Post> list(Map<String, String> requestParams) {

        SearchCriteria searchCriteria = new SearchCriteria()
                .setWhere("feed", Long.valueOf(requestParams.get("feed")))
                .setLimit(0, 30)
                .setOrder("id", OrderDirection.ASC);

        return postDao.search(searchCriteria);

    }


}
