package org.rp.sandboxmvc.dao.feed;

import org.rp.sandboxmvc.dao.AbstractDao;
import org.rp.sandboxmvc.dao.DaoEntityManagerFactory;
import org.rp.sandboxmvc.model.feed.Feed;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FeedDao extends AbstractDao<Feed, Long> {

    // TODO: entityManagerFactory should be here, so we can inject mock object

    @Transactional
    public List<Feed> getAll() {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        List<Feed> feeds = entityManager.createQuery("FROM Feed", Feed.class).getResultList();
        entityManager.close();
        return feeds;
    }

    @Override
    public Feed getById(Long id) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        Feed model = entityManager.find(Feed.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return model;
    }

    @Override
    public void insert(Feed model) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Feed model) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(model);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Feed model) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(model);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
