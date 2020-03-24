package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao extends AbstractDao<Post, Long> {

    public List<Post> getUnpublishedPostsByChannel(Channel channel, int limit) {
        return this.getEntityManager()
                .createQuery("FROM Post AS p1 WHERE feed = :feed AND id NOT IN " +
                                "(SELECT p2.post.id FROM Publication AS p2 WHERE channel = :channel) " +
                                "ORDER BY p1.pubDate ASC, p1.dateCreated ASC"
                )
                .setParameter("channel", channel)
                .setParameter("feed", channel.getFeed())
                .setMaxResults(limit)
                .getResultList();
    }

    public Post getPostByFeedAndXid(Feed feed, String xid) {
         List<Post> posts = this.getEntityManager().createQuery("FROM Post WHERE feed = :feed AND postXid = :postXid")
                .setParameter("feed", feed)
                .setParameter("postXid", xid)
                .setMaxResults(1)
                .getResultList();
         return posts.size() == 1 ? posts.get(0) : null;
    }
}
