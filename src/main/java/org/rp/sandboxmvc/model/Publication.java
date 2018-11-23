package org.rp.sandboxmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity(name = "Publication")
@Table(name = "publication")
public class Publication extends AbstractModel<Long> {

    private static final long serialVersionUID = 6886566454370545420L;

    @NotNull
    @Column(name = "is_successful")
    private Boolean isSuccessful;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @OneToMany(mappedBy = "publication", fetch = FetchType.LAZY)
    private List<RequestLog> requestLogs;

    public Publication() {
        super();
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

    public List<RequestLog> getRequestLogs() {
        return requestLogs;
    }

    public void setRequestLogs(List<RequestLog> requestLogs) {
        this.requestLogs = requestLogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        if (!super.equals(o)) return false;
        Publication that = (Publication) o;
        return Objects.equals(isSuccessful, that.isSuccessful) &&
                Objects.equals(post, that.post) &&
                Objects.equals(channel, that.channel) &&
                Objects.equals(requestLogs, that.requestLogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isSuccessful, post, channel, requestLogs);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Publication{");
        sb.append("isSuccessful=").append(isSuccessful);
        sb.append(", post=").append(post);
        sb.append(", channel=").append(channel);
        sb.append(", requestLogs=").append(requestLogs);
        sb.append('}');
        return sb.toString();
    }
}
