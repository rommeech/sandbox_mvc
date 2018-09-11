package org.rp.sandboxmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "channel")
public class Channel extends AbstractModel<Long> {

    private static final long serialVersionUID = -5584189033160373117L;

    @NotNull
    @JoinColumn(name = "bot_id", nullable = false)
    @ManyToOne
    private Bot bot;

    @NotNull
    @JoinColumn(name = "feed_id", nullable = false)
    @ManyToOne
    private Feed feed;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @NotNull
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "channel", fetch = FetchType.LAZY)
    private List<Publication> publications;

    public Channel() {
        super();
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Channel)) return false;
        if (!super.equals(o)) return false;
        Channel channel = (Channel) o;
        return Objects.equals(bot, channel.bot) &&
                Objects.equals(feed, channel.feed) &&
                Objects.equals(name, channel.name) &&
                Objects.equals(token, channel.token) &&
                status == channel.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), bot, feed, name, token, status);
    }

    @Override
    public String toString() {
        return "Channel{id=" + getId() +
                ", bot=" + bot +
                ", feed=" + feed +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", status=" + status +
                '}';
    }
}
