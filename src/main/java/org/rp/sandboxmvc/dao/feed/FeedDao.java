package org.rp.sandboxmvc.dao.feed;

import org.rp.sandboxmvc.dao.AbstractDao;
import org.rp.sandboxmvc.dao.DaoEntityManagerFactory;
import org.rp.sandboxmvc.model.feed.Feed;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FeedDao extends AbstractDao<Feed, Long> {

    public List<Feed> getAll() {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        List<Feed> feeds = entityManager.createQuery("FROM Feed", Feed.class).getResultList();
        entityManager.close();
        return feeds;
    }



}
