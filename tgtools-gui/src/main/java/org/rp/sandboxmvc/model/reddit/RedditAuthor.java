package org.rp.sandboxmvc.model.reddit;

import java.io.Serializable;
import java.util.Objects;

public class RedditAuthor implements Serializable {

    private static final long serialVersionUID = -2729355074723315495L;

    private String name;
    private String uri;

    public RedditAuthor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RedditAuthor)) return false;
        RedditAuthor that = (RedditAuthor) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(uri, that.uri);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, uri);
    }

    @Override
    public String toString() {
        return "RedditAuthor{" +
                "name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
