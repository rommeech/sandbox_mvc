package org.rp.telegram.botapi.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rp.telegram.botapi.BotApiResultType;

import java.util.Objects;

/**
 * This object represents a Telegram user or bot.
 *
 * See also: https://core.telegram.org/bots/api#user
 *
 * @author     rp
 * @version    4.6
 */
public class User implements BotApiResultType {

    private static final long serialVersionUID = 1020566709953373521L;
    private Long id;
    private Boolean isBot;
    private String firstName;
    private String lastName;
    private String username;
    private String languageCode; // TODO: use enum or locale class for this field.
    private Boolean canJoinGroups;
    private Boolean canReadAllGroupMessages;
    private Boolean supportsInlineQueries;

    /**
     * Default constructor.
     */
    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Unique identifier for this user or bot
     *
     * @return   Unique identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * @param   id   Unique identifier
     */
    @JsonProperty(value = "id")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * True, if this user is a bot
     *
     * @return   True, if this user is a bot
     */
    public Boolean getBot() {
        return isBot;
    }

    /**
     * @param   bot   true or false
     */
    @JsonProperty(value = "is_bot")
    public void setBot(Boolean bot) {
        isBot = bot;
    }

    /**
     * User‘s or bot’s first name
     *
     * @return   First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Optional. User‘s or bot’s last name
     *
     * @param   firstName   First name
     */
    @JsonProperty(value = "first_name")
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
     * @param   lastName   Last name
     */
    @JsonProperty(value = "last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Optional. User‘s or bot’s username
     *
     * @return   username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param   username   username
     */
    @JsonProperty(value = "username")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Optional. IETF language tag of the user's language
     *
     * @return   IETF language tag
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * @param   languageCode   IETF language tag
     */
    @JsonProperty(value = "language_code")
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    /**
     * Optional. True, if the bot can be invited to groups. Returned only in getMe.
     *
     * @return   True, if the bot can be invited to groups
     */
    public Boolean getCanJoinGroups() {
        return canJoinGroups;
    }

    /**
     * @param   canJoinGroups   true or false
     */
    @JsonProperty(value = "can_join_groups")
    public void setCanJoinGroups(Boolean canJoinGroups) {
        this.canJoinGroups = canJoinGroups;
    }

    /**
     * Optional. True, if privacy mode is disabled for the bot. Returned only in getMe.
     *
     * @return   True, if privacy mode is disabled for the bot
     */
    public Boolean getCanReadAllGroupMessages() {
        return canReadAllGroupMessages;
    }

    /**
     * @param   canReadAllGroupMessages   true or false
     */
    @JsonProperty(value = "can_read_all_group_messages")
    public void setCanReadAllGroupMessages(Boolean canReadAllGroupMessages) {
        this.canReadAllGroupMessages = canReadAllGroupMessages;
    }

    /**
     * Optional. True, if the bot supports inline queries. Returned only in getMe.
     *
     * @return   True, if the bot supports inline queries
     */
    public Boolean getSupportsInlineQueries() {
        return supportsInlineQueries;
    }

    /**
     * @param   supportsInlineQueries   true or false
     */
    @JsonProperty(value = "supports_inline_queries")
    public void setSupportsInlineQueries(Boolean supportsInlineQueries) {
        this.supportsInlineQueries = supportsInlineQueries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(isBot, user.isBot) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(username, user.username) &&
                Objects.equals(languageCode, user.languageCode) &&
                Objects.equals(canJoinGroups, user.canJoinGroups) &&
                Objects.equals(canReadAllGroupMessages, user.canReadAllGroupMessages) &&
                Objects.equals(supportsInlineQueries, user.supportsInlineQueries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isBot, firstName, lastName, username, languageCode, canJoinGroups,
                canReadAllGroupMessages, supportsInlineQueries);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isBot=" + isBot +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", languageCode='" + languageCode + '\'' +
                ", canJoinGroups=" + canJoinGroups +
                ", canReadAllGroupMessages=" + canReadAllGroupMessages +
                ", supportsInlineQueries=" + supportsInlineQueries +
                '}';
    }
}
