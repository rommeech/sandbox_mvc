package org.rp.sandboxmvc.model.reddit;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class RedditEntity implements Serializable {

    private static final long serialVersionUID = 1205423643189470936L;

    private String id;
    private RedditAuthor author;
    private RedditCategory category;
    private String content;
    private String link;
    private Date updated;
    private String title;

    public RedditEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RedditAuthor getAuthor() {
        return author;
    }

    public void setAuthor(RedditAuthor author) {
        this.author = author;
    }

    public RedditCategory getCategory() {
        return category;
    }

    public void setCategory(RedditCategory category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RedditEntity)) return false;
        RedditEntity that = (RedditEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RedditEntity{" +
                "id='" + id + '\'' +
                ", author=" + author.getName() +
                ", category=" + category.getLabel() +
                //", content='" + content + '\'' +
                ", link='" + link + '\'' +
                ", updated=" + updated +
                ", title='" + title + '\'' +
                '}';
    }
}
