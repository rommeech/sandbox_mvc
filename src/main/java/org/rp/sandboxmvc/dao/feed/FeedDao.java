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

    @Override
    public void delete (Feed model) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Feed.class, model.getId()));
        entityManager.getTransaction().commit();

        entityManager.close();
    }


}
