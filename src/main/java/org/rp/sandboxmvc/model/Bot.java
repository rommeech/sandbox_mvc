package org.rp.sandboxmvc.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bot")
public class Bot extends AbstractModel<Long> {

    private static final long serialVersionUID = 8493343250882283132L;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(name = "about")
    private String about;

    @OneToMany(mappedBy = "bot", fetch = FetchType.LAZY)
    private List<Channel> channels;

    public Bot() {
        super();
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bot)) return false;
        if (!super.equals(o)) return false;
        Bot bot = (Bot) o;
        return Objects.equals(userId, bot.userId) &&
                Objects.equals(username, bot.username) &&
                Objects.equals(token, bot.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, username, token);
    }

    @Override
    public String toString() {
        return "Bot{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", about='" + about + '\'' +
                ", channels=" + channels +
                '}';
    }
}
