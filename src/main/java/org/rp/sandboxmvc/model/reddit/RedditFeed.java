package org.rp.sandboxmvc.model.reddit;

import org.rp.sandboxmvc.model.rss.Link;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class RedditFeed implements Serializable {

    private static final long serialVersionUID = 7934592809518308575L;

    private String id;
    private RedditCategory category;
    private Date updated;
    private String icon;
    private Link selfLink;
    private Link alternateLink;
    private String logo;
    private String subtitle;
    private String title;
    private List<RedditEntity> entries;

    public RedditFeed() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RedditCategory getCategory() {
        return category;
    }

    public void setCategory(RedditCategory category) {
        this.category = category;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Link getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(Link selfLink) {
        this.selfLink = selfLink;
    }

    public Link getAlternateLink() {
        return alternateLink;
    }

    public void setAlternateLink(Link alternateLink) {
        this.alternateLink = alternateLink;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RedditEntity> getEntries() {
        return entries;
    }

    public void setEntries(List<RedditEntity> entries) {
        this.entries = entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RedditFeed)) return false;
        RedditFeed that = (RedditFeed) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RedditFeed{" +
                "id='" + id + '\'' +
                ", category=" + category.getLabel() +
                ", updated=" + updated +
                ", icon='" + icon + '\'' +
                ", selfLink=" + selfLink.getHref() +
                ", alternateLink=" + alternateLink.getHref() +
                ", logo='" + logo + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", title='" + title + '\'' +
                //", entries=" + entries +
                '}';
    }
}
