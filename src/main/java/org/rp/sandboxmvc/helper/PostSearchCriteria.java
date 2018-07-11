package org.rp.sandboxmvc.helper;

import org.rp.sandboxmvc.dao.SearchCriteria;

public class PostSearchCriteria extends SearchCriteria {

    private Long feed;

    public Long getFeed() {
        return feed;
    }

    public void setFeed(Long feed) {
        this.feed = feed;
        this.addWhere("feed", feed);
    }
}
