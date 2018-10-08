package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostDao extends AbstractDao<Post, Long> {

    public List<Post> getUnpublishedPostsByFeed(Feed feed) {

        return this.getEntityManager()
                .createQuery(
                        "SELECT ps FROM Post AS ps LEFT JOIN ps.publications AS pb WHERE pb.id IS NULL AND ps.feed = :feed ORDER BY ps.dateCreated DESC"
                )
                .setParameter("feed", feed)
                .setMaxResults(30)
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
