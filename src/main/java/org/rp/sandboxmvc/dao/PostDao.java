package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.dao.AbstractDao;
import org.rp.sandboxmvc.model.feed.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao extends AbstractDao<Post, Long> {
}
