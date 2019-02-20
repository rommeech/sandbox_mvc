package org.rp.sandboxmvc.criteria;

import org.rp.sandboxmvc.model.Feed;

import java.util.Objects;

public class PostSearchForm {

    private String title;
    private String content;
    private Feed feed;

    public PostSearchForm() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostSearchForm that = (PostSearchForm) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(feed, that.feed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, feed);
    }

    @Override
    public String toString() {
        return "PostSearchForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", feed=" + feed +
                '}';
    }
}
