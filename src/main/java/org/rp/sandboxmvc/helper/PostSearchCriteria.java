package org.rp.sandboxmvc.helper;

import org.rp.sandboxmvc.dao.SearchCriteria;

public class PostSearchCriteria extends SearchCriteria {

    private Long feedId;

    public Long getFeedId() {
        return feedId;
    }

    public void setFeedId(Long feedId) {
        this.feedId = feedId;
        this.addWhere("feed", feedId);
    }
}
