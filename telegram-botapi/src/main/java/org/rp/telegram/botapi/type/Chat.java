package org.rp.telegram.botapi.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rp.telegram.botapi.BotApiResultType;
import org.rp.telegram.botapi.util.ChatType;

import java.util.Objects;

/**
 * This object represents a chat.
 *
 * See also: https://core.telegram.org/bots/api#chat
 *
 * @author     rp
 * @version    4.6
 */

// TODO: builder
// TODO: unittests

public class Chat implements BotApiResultType {

    private static final long serialVersionUID = -179517108807022711L;

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "type")
    private ChatType type;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "first_name")
    private String firstName;

    @JsonProperty(value = "last_name")
    private String lastName;

    @JsonProperty(value = "photo")
    private Object photo;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "invite_link")
    private String inviteLink;

    @JsonProperty(value = "pinned_message")
    private Message pinnedMessage;

    @JsonProperty(value = "permissions")
    private Object permissions;

    @JsonProperty(value = "sticker_set_name")
    private String stickerSetName;

    @JsonProperty(value = "slow_mode_delay")
    private Long slowModeDelay;

    @JsonProperty(value = "can_set_sticker_set")
    private Boolean canSetStickerSet;

    public Chat() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Unique identifier for this chat
     *
     * @return    identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * @param     id    identifier
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Type of chat, can be either “private”, “group”, “supergroup” or “channel”
     *
     * @return    type of chat
     */
    public ChatType getType() {
        return type;
    }

    /**
     * @param    type    type of chat
     */
    public void setType(ChatType type) {
        this.type = type;
    }

    /**
     * Optional. Title, for supergroups, channels and group chats
     * @return    title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param    title    title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Optional. Username, for private chats, supergroups and channels if available
     *
     * @return    username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param    username    username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Optional. First name of the other party in a private chat
     * @return    first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param    firstName    first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Optional. Last name of the other party in a private chat
     * @return    last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param    lastName    last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Optional. Chat photo. Returned only in getChat.
     *
     * @return    photo object
     */
    public Object getPhoto() {
        return photo;
    }

    /**
     * @param    photo    photo object
     */
    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    /**
     * Optional. Description, for supergroups and channel chats. Returned only in getChat.
     *
     * @return    description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param    description    description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Optional. Chat invite link, for supergroups and channel chats. Returned only in getChat.
     *
     * @return    invite link URL
     */
    public String getInviteLink() {
        return inviteLink;
    }

    /**
     * @param    inviteLink    invite link URL
     */
    public void setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
    }

    /**
     * Optional. Pinned message, for supergroups and channel chats. Returned only in getChat.
     *
     * @return    message object
     */
    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    /**
     * @param    pinnedMessage    message object
     */
    public void setPinnedMessage(Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
    }

    /**
     * Optional. For supergroups, name of group sticker set. Returned only in getChat.
     *
     * @return    sticker set name
     */
    public String getStickerSetName() {
        return stickerSetName;
    }

    /**
     * @param    stickerSetName    sticker set name
     */
    public void setStickerSetName(String stickerSetName) {
        this.stickerSetName = stickerSetName;
    }

    /**
     * Optional. True, if the bot can change the group sticker set. Returned only in getChat.
     *
     * @return     true or false
     */
    public Boolean getCanSetStickerSet() {
        return canSetStickerSet;
    }

    /**
     * @param    canSetStickerSet    true or false
     */
    public void setCanSetStickerSet(Boolean canSetStickerSet) {
        this.canSetStickerSet = canSetStickerSet;
    }

    /**
     * Optional. Default chat member permissions, for groups and supergroups. Returned only in getChat.
     *
     * @return    chat member permissions object
     */
    public Object getPermissions() {
        return permissions;
    }

    /**
     * @param    permissions    chat member permissions object
     */
    public void setPermissions(Object permissions) {
        this.permissions = permissions;
    }

    /**
     * Optional. For supergroups, the minimum allowed delay between consecutive messages
     * sent by each unpriviledged user. Returned only in getChat.
     *
     * @return    minimum allowed delay
     */
    public Long getSlowModeDelay() {
        return slowModeDelay;
    }

    /**
     * @param    slowModeDelay    minimum allowed delay
     */
    public void setSlowModeDelay(Long slowModeDelay) {
        this.slowModeDelay = slowModeDelay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(id, chat.id) &&
                type == chat.type &&
                Objects.equals(title, chat.title) &&
                Objects.equals(username, chat.username) &&
                Objects.equals(firstName, chat.firstName) &&
                Objects.equals(lastName, chat.lastName) &&
                Objects.equals(photo, chat.photo) &&
                Objects.equals(description, chat.description) &&
                Objects.equals(inviteLink, chat.inviteLink) &&
                Objects.equals(pinnedMessage, chat.pinnedMessage) &&
                Objects.equals(permissions, chat.permissions) &&
                Objects.equals(stickerSetName, chat.stickerSetName) &&
                Objects.equals(slowModeDelay, chat.slowModeDelay) &&
                Objects.equals(canSetStickerSet, chat.canSetStickerSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, title, username, firstName, lastName, photo, description, inviteLink,
                pinnedMessage, permissions, stickerSetName, slowModeDelay, canSetStickerSet);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photo=" + photo +
                ", description='" + description + '\'' +
                ", inviteLink='" + inviteLink + '\'' +
                ", pinnedMessage=" + pinnedMessage +
                ", permissions=" + permissions +
                ", stickerSetName='" + stickerSetName + '\'' +
                ", slowModeDelay=" + slowModeDelay +
                ", canSetStickerSet=" + canSetStickerSet +
                '}';
    }
}
