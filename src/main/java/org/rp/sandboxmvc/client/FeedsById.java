package org.rp.sandboxmvc.client;

import org.rp.sandboxmvc.dao.feed.FeedDao;
import org.rp.sandboxmvc.model.feed.Feed;

public class FeedsById {

    public static void main(String[] args) {

        FeedDao dao = new FeedDao();
        Feed feed = dao.getById(1L);
        System.out.println(feed);

    }

}
