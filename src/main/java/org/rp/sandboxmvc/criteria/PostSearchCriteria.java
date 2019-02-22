package org.rp.sandboxmvc.criteria;

import java.util.Objects;

public class PostSearchCriteria {

    private String title;
    private String content;
    private Long feedId;

    public PostSearchCriteria() {
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

    public Long getFeedId() {
        return feedId;
    }

    public void setFeedId(Long feedId) {
        this.feedId = feedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostSearchCriteria that = (PostSearchCriteria) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(feedId, that.feedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, feedId);
    }

    @Override
    public String toString() {
        return "PostSearchCriteria{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", feedId=" + feedId +
                '}';
    }
}
