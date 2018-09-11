package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao extends AbstractDao<Post, Long> {

    public List<Post> getUnpublishedPostsByFeed(Feed feed) {

        return this.getEntityManager()
                .createQuery("SELECT ps FROM Post AS ps LEFT JOIN ps.publications AS pb WHERE pb.id IS NULL AND ps.feed = :feed ORDER BY ps.dateCreated DESC")
                .setParameter("feed", feed)
                .setMaxResults(30)
                .getResultList();

    }

}
