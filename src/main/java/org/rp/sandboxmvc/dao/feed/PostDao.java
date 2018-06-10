package org.rp.sandboxmvc.dao.feed;

import org.rp.sandboxmvc.dao.AbstractDao;
import org.rp.sandboxmvc.dao.DaoEntityManagerFactory;
import org.rp.sandboxmvc.model.feed.Feed;
import org.rp.sandboxmvc.model.feed.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

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
    public List<Post> getPosts() {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        List<Post> posts = entityManager.createQuery("FROM Post", Post.class)
                .setMaxResults(30)
                .getResultList();
        //entityManager.close();
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
