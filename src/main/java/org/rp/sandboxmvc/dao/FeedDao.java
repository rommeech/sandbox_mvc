package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.model.Feed;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedDao extends AbstractDao<Feed, Long> {

    public List<Feed> getAllFeeds() {
        return this.getEntityManager().createQuery("FROM Feed").getResultList();
    }

}
