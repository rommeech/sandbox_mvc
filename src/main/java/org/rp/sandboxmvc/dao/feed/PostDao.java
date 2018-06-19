package org.rp.sandboxmvc.dao.feed;

import org.rp.sandboxmvc.dao.AbstractDao;
import org.rp.sandboxmvc.dao.DaoEntityManagerFactory;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.model.feed.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PostDao extends AbstractDao<Post, Long> {

    @Override
    public Post getById(Long id) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        Post model = entityManager.find(Post.class, id);
        entityManager.close();
        return model;
    }

    public List<Post> search(SearchCriteria criteria) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = criteriaQuery.from(Post.class);
        criteriaQuery.select(root);
        List<Post> posts = entityManager
                .createQuery(criteriaQuery)
                .setFirstResult(criteria.getLimitOffset())
                .setMaxResults(criteria.getLimitCount())
                .getResultList();
        entityManager.close();
        return posts;
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
}
