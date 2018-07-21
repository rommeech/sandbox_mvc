package org.rp.sandboxmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "feed")
public class Feed extends AbstractModel<Long> {
    private static final long serialVersionUID = -581287016449199340L;

    @NotNull(message = "Input status")
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "logo_url")
    private String logoUrl;

    @NotNull(message = "Input title")
    @Column(name = "title")
    private String title;

    @NotNull()
    @Pattern(regexp = "^https?://.+", message = "Input valid feed URL")
    @Column(name = "feed_url", nullable = false)
    private String feedUrl;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @NotNull(message = "Input valid job interval in milliseconds")
    @Column(name = "job_interval", nullable = false)
    private Long jobInterval;

    @NotNull(message = "Input next job date and time")
    @Column(name = "next_job", nullable = false)
    private Timestamp nextJob;

    @OneToMany(mappedBy = "feed", fetch = FetchType.LAZY) // , orphanRemoval = true
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "feed", fetch = FetchType.LAZY)
    private List<Channel> channels;

    public Feed() {
        super();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getJobInterval() {
        return jobInterval;
    }

    public void setJobInterval(Long jobInterval) {
        this.jobInterval = jobInterval;
    }

    public Timestamp getNextJob() {
        return nextJob;
    }

    public void setNextJob(Timestamp nextJob) {
        this.nextJob = nextJob;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts.clear();
        if (posts != null) {
            this.posts = posts;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feed)) return false;
        if (!super.equals(o)) return false;
        Feed feed = (Feed) o;
        return status == feed.status &&
                Objects.equals(iconUrl, feed.iconUrl) &&
                Objects.equals(logoUrl, feed.logoUrl) &&
                Objects.equals(title, feed.title) &&
                Objects.equals(feedUrl, feed.feedUrl) &&
                Objects.equals(author, feed.author) &&
                Objects.equals(description, feed.description) &&
                Objects.equals(jobInterval, feed.jobInterval) &&
                Objects.equals(nextJob, feed.nextJob) &&
                Objects.equals(posts, feed.posts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), status, iconUrl, logoUrl, title, feedUrl, author, description, jobInterval, nextJob, posts);
    }

    @Override
    public String toString() {
        return "Feed{id=" + getId() +
                ", status=" + status +
                ", iconUrl='" + iconUrl + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", title='" + title + '\'' +
                ", feedUrl='" + feedUrl + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", jobInterval=" + jobInterval +
                ", nextJob=" + nextJob +
                '}';
    }
}