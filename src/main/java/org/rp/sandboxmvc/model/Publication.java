package org.rp.sandboxmvc.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "publication")
public class Publication extends AbstractModel<Long> {

    private static final long serialVersionUID = 6886566454370545420L;

    @Column(name = "request")
    private String request;

    @Column(name = "response")
    private String response;

    @Column(name = "is_successful")
    private Boolean isSuccessful;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    public Publication() {
        super();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        if (!super.equals(o)) return false;
        Publication that = (Publication) o;
        return
                Objects.equals(request, that.request) &&
                Objects.equals(response, that.response) &&
                Objects.equals(isSuccessful, that.isSuccessful);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), request, response, isSuccessful);
    }

    @Override
    public String toString() {
        return "Publication{id=" + getId() +
                ", request='" + request + '\'' +
                ", response='" + response + '\'' +
                ", isSuccessful=" + isSuccessful +
                '}';
    }
}
