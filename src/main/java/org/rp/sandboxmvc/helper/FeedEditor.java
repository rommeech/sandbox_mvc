package org.rp.sandboxmvc.helper;

import org.rp.sandboxmvc.model.feed.Feed;
import org.rp.sandboxmvc.service.FeedService;

import java.beans.PropertyEditorSupport;

public class FeedEditor extends PropertyEditorSupport {

    private final FeedService feedService;

    public  FeedEditor(FeedService feedService) {
        this.feedService = feedService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Feed feed = feedService.getById(Long.parseLong(text));
        this.setValue(feed);
    }

    @Override
    public String getAsText() {
        Feed feed = (Feed) this.getValue();
        return feed != null ? feed.getId().toString() : null;
    }





}
