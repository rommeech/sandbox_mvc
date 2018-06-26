package org.rp.sandboxmvc.dao.feed;

import org.rp.sandboxmvc.dao.AbstractDao;
import org.rp.sandboxmvc.model.feed.Feed;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FeedDao extends AbstractDao<Feed, Long> {

    @PersistenceContext
    EntityManager entityManager;

    public List<Feed> getAll() {
        return entityManager.createQuery("FROM Feed", Feed.class).getResultList();
    }

}
