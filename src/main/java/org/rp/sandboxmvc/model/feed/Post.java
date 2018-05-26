package org.rp.sandboxmvc.model.feed;

import org.rp.sandboxmvc.model.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@Table(name = "post")
public class Post extends Model<Long> {

    private static final long serialVersionUID = -2803666248225562332L;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id")
    private String feed;

    @Column(name = "author")
    private String author;

    @Column(name = "author_url")
    private String authorUrl;

    @Column(name = "title")
    private String title;

    @Column(name = "content", length = 65535)
    private String content;

    @Column(name = "post_url")
    private String postUrl;

    @NotNull
    @Column(name = "post_xid")
    private String postXid;

    public Post() {
        super();
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
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

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getPostXid() {
        return postXid;
    }

    public void setPostXid(String postXid) {
        this.postXid = postXid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        if (!super.equals(o)) return false;
        Post post = (Post) o;
        return Objects.equals(feed, post.feed) &&
                Objects.equals(author, post.author) &&
                Objects.equals(authorUrl, post.authorUrl) &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(postUrl, post.postUrl) &&
                Objects.equals(postXid, post.postXid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), feed, author, authorUrl, title, content, postUrl, postXid);
    }

    @Override
    public String toString() {
        return "Post{id=" + getId() +
                ", feed=" + feed +
                ", author='" + author + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", postXid='" + postXid + '\'' +
                '}';
    }
}
