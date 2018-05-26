package org.rp.sandboxmvc.client;

import org.rp.sandboxmvc.dao.feed.FeedDao;
import org.rp.sandboxmvc.model.feed.Feed;

import java.util.List;

public class FeedsList {

    public static void main(String[] args) {

        FeedDao dao = new FeedDao();
        List<Feed> feeds = dao.getAll();
        for(Feed feed : feeds) {
            System.out.println(feed);
        }

    }

}
