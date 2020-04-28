package org.rp.sandboxmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "post")
public class Post extends AbstractModel<Long> {

    private static final long serialVersionUID = -2803666248225562332L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Feed feed;

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

    @Column(name = "pub_date")
    private Timestamp pubDate;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Publication> publications;

    public Post() {
        super();
    }

    public Post(Builder builder) throws ModelException {
        this();
        this.setId(builder.id);
        this.feed = builder.feed;
        this.author = builder.author;
        this.authorUrl = builder.authorUrl;
        this.title = builder.title;
        this.content = builder.content;
        this.postUrl = builder.postUrl;
        this.postXid = builder.postXid;
        this.pubDate = builder.pubDate;
        this.publications = builder.publications;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
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

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public Timestamp getPubDate() {
        return pubDate;
    }

    public void setPubDate(Timestamp pubDate) {
        this.pubDate = pubDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Post post = (Post) o;
        return Objects.equals(feed.getId(), post.feed.getId()) &&
                Objects.equals(author, post.author) &&
                Objects.equals(authorUrl, post.authorUrl) &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(postUrl, post.postUrl) &&
                Objects.equals(postXid, post.postXid) &&
                Objects.equals(pubDate, post.pubDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), feed.getId(), author, authorUrl, title, content, postUrl,
                postXid, pubDate);
    }

    @Override
    public String toString() {
        return "Post{" +
                "feed=" + feed.getId() +
                ", author='" + author + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", postXid='" + postXid + '\'' +
                ", pubDate=" + pubDate +
                '}';
    }

    public static class Builder {

        private Long id;
        private Feed feed;
        private String author;
        private String authorUrl;
        private String title;
        private String content;
        private String postUrl;
        private String postXid;
        private Timestamp pubDate;
        private List<Publication> publications;

        public Builder() {
        }

        public Post.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Post.Builder feed(Feed feed) {
            this.feed = feed;
            return this;
        }

        public Post.Builder author(String author) {
            this.author = author;
            return this;
        }

        public Post.Builder authorUrl(String authorUrl) {
            this.authorUrl = authorUrl;
            return this;
        }

        public Post.Builder title(String title) {
            this.title = title;
            return this;
        }

        public Post.Builder content(String content) {
            this.content = content;
            return this;
        }

        public Post.Builder postUrl(String postUrl) {
            this.postUrl = postUrl;
            return this;
        }

        public Post.Builder postXid(String postXid) {
            this.postXid = postXid;
            return this;
        }

        public Post.Builder pubDate(Timestamp pubDate) {
            this.pubDate = pubDate;
            return this;
        }

        public Post.Builder publications(List<Publication> publications) {
            this.publications = publications;
            return this;
        }

        public Post build() throws ModelException {
            return new Post(this);
        }

    }

}
