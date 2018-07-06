package org.rp.sandboxmvc.model.tg;

import org.rp.sandboxmvc.model.AbstractModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "bot")
public class Bot extends AbstractModel<Long> {

    private static final long serialVersionUID = 8493343250882283132L;

    @Column(name = "about")
    private String about;

    @Column(name = "botpic")
    private String botpic;

    @Column(name = "description", length = 1024)
    private String description;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    public Bot() {
        super();
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getBotpic() {
        return botpic;
    }

    public void setBotpic(String botpic) {
        this.botpic = botpic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bot)) return false;
        if (!super.equals(o)) return false;
        Bot bot = (Bot) o;
        return Objects.equals(about, bot.about) &&
                Objects.equals(botpic, bot.botpic) &&
                Objects.equals(description, bot.description) &&
                Objects.equals(name, bot.name) &&
                Objects.equals(token, bot.token) &&
                Objects.equals(username, bot.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), about, botpic, description, name, token, username);
    }

    @Override
    public String toString() {
        return "Bot{id=" + getId() +
                ", about='" + about + '\'' +
                ", botpic='" + botpic + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", username='" + username +
                '}';
    }
}
