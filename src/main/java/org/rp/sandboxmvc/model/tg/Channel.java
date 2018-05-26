package org.rp.sandboxmvc.model.tg;

import org.rp.sandboxmvc.model.Model;
import org.rp.sandboxmvc.model.Status;
import org.rp.sandboxmvc.model.feed.Feed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "channel")
public class Channel extends Model<Long> {

    private static final long serialVersionUID = -5584189033160373117L;

    @NotNull
    @Column(name = "bot_id")
    private Bot bot;

    @NotNull
    @Column(name = "feed_id")
    private Feed feed;

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "token")
    private String token;

    @Column(name = "status")
    private Status status;

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
