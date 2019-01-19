package org.rp.sandboxmvc.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.rp.sandboxmvc.helper.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "channel", fetch = FetchType.LAZY)
    private List<Publication> publications;

    public Channel() {
        super();
    }

    public Channel(Channel.Builder builder) throws ModelException {
        this();
        this.setId(builder.id);
        this.bot = builder.bot;
        this.feed = builder.feed;
        this.name = builder.name;
        this.username = builder.username;
        this.status = builder.status;
        this.publications = builder.publications;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String token) {
        this.username = token;
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
                Objects.equals(username, channel.username) &&
                status == channel.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), bot, feed, name, username, status);
    }

    @Override
    public String toString() {
        return "Channel{id=" + getId() +
                ", bot=" + bot +
                ", feed=" + feed +
                ", name='" + name + '\'' +
                ", token='" + username + '\'' +
                ", status=" + status +
                '}';
    }

    public static class Builder {

        private Long id;
        private Bot bot;
        private Feed feed;
        private String name;
        private String username;
        private Status status;
        private List<Publication> publications;

        public Builder() {

        }

        public Channel.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Channel.Builder bot(Bot bot) {
            this.bot = bot;
            return this;
        }

        public Channel.Builder feed(Feed feed) {
            this.feed = feed;
            return this;
        }

        public Channel.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Channel.Builder username(String username) {
            this.username = username;
            return this;
        }

        public Channel.Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Channel.Builder publications(List<Publication> publications) {
            this.publications = publications;
            return this;
        }

        public Channel build() throws ModelException {
            return new Channel(this);
        }
    }
}
