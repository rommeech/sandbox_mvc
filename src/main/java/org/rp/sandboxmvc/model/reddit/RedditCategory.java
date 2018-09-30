package org.rp.sandboxmvc.model.reddit;

import java.io.Serializable;
import java.util.Objects;

public class RedditCategory implements Serializable {

    private static final long serialVersionUID = 7169733055480573373L;

    private String term;
    private String label;

    public RedditCategory() {
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RedditCategory)) return false;
        RedditCategory that = (RedditCategory) o;
        return Objects.equals(term, that.term) &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {

        return Objects.hash(term, label);
    }

    @Override
    public String toString() {
        return "RedditCategory{" +
                "term='" + term + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
