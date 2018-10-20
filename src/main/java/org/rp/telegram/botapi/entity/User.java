package org.rp.telegram.botapi.entity;

import java.util.Objects;

// TODO: add unit test for converter to json
// TODO: add builder

/**
 * This object represents a Telegram user or bot.
 * https://core.telegram.org/bots/api#user
 *
 * @author        Roman Parshin, roman.dev@gmail.com
 * @version       1.0
 * @since         1.0
 * @apiVersion    4.1
 */
public class User extends AbstractEntity {
    private static final long serialVersionUID = 1020566709953373521L;

    private Integer id;
    private Boolean isBot;
    private String firstName;
    private String lastName;
    private String userName;
    // TODO: use enum or locale class for this field. But it is optional, so maybe later.
    private String languageCode;

    /**
     * This object represents a Telegram user or bot.
     */
    public User() {
    }

    /**
     * @return   Unique identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Unique identifier for this user or bot
     *
     * @param   id   Unique identifier
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return   True, if this user is a bot
     */
    public Boolean getBot() {
        return isBot;
    }

    /**
     * True, if this user is a bot
     * @param   bot
     */
    public void setBot(Boolean bot) {
        isBot = bot;
    }

    /**
     * @return   First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * User‘s or bot’s first name
     *
     * @param   firstName   First name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return   Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Optional. User‘s or bot’s last name
     *
     * @param   lastName   Last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return   username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Optional. User‘s or bot’s username
     *
     * @param   userName   username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return   IETF language tag
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * Optional. IETF language tag of the user's language
     * @param   languageCode   IETF language tag
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isBot=" + isBot +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", languageCode='" + languageCode + '\'' +
                '}';
    }
}
