package org.rp.sandboxmvc.helper;

import org.rp.sandboxmvc.model.Post;

import java.util.List;

public class PostReport {

    private List<Post> posts;
    private int total;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
