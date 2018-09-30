package org.rp.sandboxmvc.model.rss;

import java.io.Serializable;
import java.util.Objects;

public class Link implements Serializable {

    private static final long serialVersionUID = -8639325007015903675L;

    private String rel;
    private String href;
    private String type;

    public Link() {
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;
        Link link = (Link) o;
        return Objects.equals(rel, link.rel) &&
                Objects.equals(href, link.href) &&
                Objects.equals(type, link.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rel, href, type);
    }

    @Override
    public String toString() {
        return "Link{" +
                "rel='" + rel + '\'' +
                ", href='" + href + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
