package org.rp.sandboxmvc.dao.feed;

import org.rp.sandboxmvc.dao.AbstractDao;
import org.rp.sandboxmvc.dao.DaoEntityManagerFactory;
import org.rp.sandboxmvc.model.feed.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostDao extends AbstractDao<Post, Long> {

    @Override
    @Transactional
    public Post getById(Long id) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        Post model = entityManager.find(Post.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return model;
    }

    @Transactional
    public List<Post> search(Map<String, Object> parameters, int start, int limit, String order) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        List<Post> posts = entityManager.createQuery("FROM Post", Post.class)
                .setMaxResults(30)
                .getResultList();
        entityManager.close();
        return posts;
    }

    @Transactional
    public List<Post> search(DaoSearchCriteriaBuilder builder) {
        return null;

        while (true)

    }

    @Override
    public void insert(Post model) {
    }

    @Override
    public void update(Post model) {

    }

    @Override
    public void delete(Post model) {

    }

    public DaoSearchCriteriaBuilder createDaoSearchCriteriaBuilder() {
        return new DaoSearchCriteriaBuilder(this);
    }

    public static class DaoSearchCriteriaBuilder {

        PostDao postDao;
        String orderField = "id";
        int limit         = 50;

        public DaoSearchCriteriaBuilder(PostDao dao) {
            this.postDao = dao;
        }

        public DaoSearchCriteriaBuilder setOrder(String orderField) {
            this.orderField = orderField;
            return this;
        }

        public DaoSearchCriteriaBuilder setLimit(int limit) {
            this.limit = limit;
            return this;
        }

        public List<Post> getAll() {
            return this.postDao.search(this);
        }
    }

}
