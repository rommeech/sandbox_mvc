package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostDao extends AbstractDao<Post, Long> {

    public List<Post> getUnpublishedPostsByChannel(Channel channel, int limit) {

        return this.getEntityManager()
                .createQuery(
                        "FROM Post AS p1 WHERE feed = :feed AND id NOT IN (SELECT p2.post.id FROM Publication AS p2 WHERE channel = :channel) ORDER BY p1.pubDate ASC, p1.dateCreated ASC"
                )
                .setParameter("channel", channel)
                .setParameter("feed", channel.getFeed())
                .setMaxResults(limit)
                .getResultList();
    }

    public Post getPostByFeedAndXid(Feed feed, String xid) {
        /*return (Post) this.getEntityManager().createQuery("FROM Post WHERE feed = :feed AND postXid = :postXid")
                .setParameter("feed", feed)
                .setParameter("postXid", xid)
                .setMaxResults(1)
                .;*/
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.addWhere("feed", feed);
        searchCriteria.addWhere("postXid", xid);
        searchCriteria.setLimit(1);
        List<Post> list = this.search(searchCriteria);
        return list.size() == 1 ? list.get(0) : null;
    }
}
