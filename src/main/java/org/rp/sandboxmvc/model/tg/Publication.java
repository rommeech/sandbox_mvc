package org.rp.sandboxmvc.model.tg;

import org.rp.sandboxmvc.model.Model;
import org.rp.sandboxmvc.model.feed.Post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "publication")
public class Publication extends Model<Long> {

    private static final long serialVersionUID = 6886566454370545420L;

    @NotNull
    @Column(name = "post_id")
    private Post post;

    @NotNull
    @Column(name = "channel_id")
    private Channel channel;

    @Column(name = "request")
    private String request;

    @Column(name = "response")
    private String response;

    @NotNull
    @Column(name = "is_successful")
    private Boolean isSuccessful;

    public Publication() {
        super();
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(Boolean successful) {
        isSuccessful = successful;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        if (!super.equals(o)) return false;
        Publication that = (Publication) o;
        return Objects.equals(post, that.post) &&
                Objects.equals(channel, that.channel) &&
                Objects.equals(request, that.request) &&
                Objects.equals(response, that.response) &&
                Objects.equals(isSuccessful, that.isSuccessful);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), post, channel, request, response, isSuccessful);
    }

    @Override
    public String toString() {
        return "Publication{id=" + getId() +
                ", post=" + post +
                ", channel=" + channel +
                ", request='" + request + '\'' +
                ", response='" + response + '\'' +
                ", isSuccessful=" + isSuccessful +
                '}';
    }
}
