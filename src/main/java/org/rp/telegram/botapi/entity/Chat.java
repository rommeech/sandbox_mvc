package org.rp.telegram.botapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * This object represents a chat.
 * https://core.telegram.org/bots/api#chat
 *
 * @author        Roman Parshin, roman.dev@gmail.com
 * @version       1.0
 * @since         1.0
 * @apiVersion    4.1
 */
public class Chat extends AbstractEntity {

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

    @JsonProperty(value = "all_members_are_administrators")
    private Boolean allMembersAreAdministrators;

    @JsonProperty(value = "photo")
    private ChatPhoto photo;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "invite_link")
    private String inviteLink;

    @JsonProperty(value = "pinned_message")
    private Message pinnedMessage;

    @JsonProperty(value = "sticker_set_name")
    private String stickerSetName;

    @JsonProperty(value = "can_set_sticker_set")
    private Boolean canSetStickerSet;

    /**
     * This object represents a chat.
     */
    public Chat() {
    }

    /**
     * @return    Unique identifier for this chat
     */
    public Long getId() {
        return id;
    }

    /**
     * @param     id    Unique identifier for this chat
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return    Type of chat, can be either “private”, “group”, “supergroup” or “channel”
     */
    public ChatType getType() {
        return type;
    }

    /**
     * @param    type    Type of chat, can be either “private”, “group”, “supergroup” or “channel”
     */
    public void setType(ChatType type) {
        this.type = type;
    }

    /**
     * Optional
     * @return    Title, for supergroups, channels and group chats
     */
    public String getTitle() {
        return title;
    }

    /**
     * Optional
     * @param    title    Title, for supergroups, channels and group chats
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Optional
     * @return    Username, for private chats, supergroups and channels if available
     */
    public String getUsername() {
        return username;
    }

    /**
     * Optional
     * @param    username    Username, for private chats, supergroups and channels if available
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Optional
     * @return    First name of the other party in a private chat
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Optional
     * @param    firstName    First name of the other party in a private chat
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Optional
     * @return    Last name of the other party in a private chat
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Optional
     * @param    lastName    Last name of the other party in a private chat
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Optional
     * @return    True if a group has ‘All Members Are Admins’ enabled.
     */
    public Boolean getAllMembersAreAdministrators() {
        return allMembersAreAdministrators;
    }

    /**
     * Optional
     * @param    allMembersAreAdministrators    True if a group has ‘All Members Are Admins’ enabled.
     */
    public void setAllMembersAreAdministrators(Boolean allMembersAreAdministrators) {
        this.allMembersAreAdministrators = allMembersAreAdministrators;
    }

    /**
     * Optional
     * @return    Chat photo. Returned only in getChat.
     */
    public ChatPhoto getPhoto() {
        return photo;
    }

    /**
     * Optional
     * @param    photo    Chat photo. Returned only in getChat.
     */
    public void setPhoto(ChatPhoto photo) {
        this.photo = photo;
    }

    /**
     * Optional
     * @return    Description, for supergroups and channel chats. Returned only in getChat.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Optional
     * @param    description    Description, for supergroups and channel chats. Returned only in getChat.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Optional
     * @return    Chat invite link, for supergroups and channel chats. Returned only in getChat.
     */
    public String getInviteLink() {
        return inviteLink;
    }

    /**
     * Optional
     * @param    inviteLink    Chat invite link, for supergroups and channel chats. Returned only in getChat.
     */
    public void setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
    }

    /**
     * Optional
     * @return    Pinned message, for supergroups and channel chats. Returned only in getChat.
     */
    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    /**
     * Optional
     * @param    pinnedMessage    Pinned message, for supergroups and channel chats. Returned only in getChat.
     */
    public void setPinnedMessage(Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
    }

    /**
     * Optional
     * @return    For supergroups, name of group sticker set. Returned only in getChat.
     */
    public String getStickerSetName() {
        return stickerSetName;
    }

    /**
     * Optional
     * @param    stickerSetName    For supergroups, name of group sticker set. Returned only in getChat.
     */
    public void setStickerSetName(String stickerSetName) {
        this.stickerSetName = stickerSetName;
    }

    /**
     * Optional
     * @return    True, if the bot can change the group sticker set. Returned only in getChat.
     */
    public Boolean getCanSetStickerSet() {
        return canSetStickerSet;
    }

    /**
     * Optional
     * @param    canSetStickerSet    True, if the bot can change the group sticker set. Returned only in getChat.
     */
    public void setCanSetStickerSet(Boolean canSetStickerSet) {
        this.canSetStickerSet = canSetStickerSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;
        Chat chat = (Chat) o;
        return Objects.equals(id, chat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chat{");
        sb.append("id=").append(id);
        sb.append(", type='").append(type).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", allMembersAreAdministrators=").append(allMembersAreAdministrators);
        sb.append(", photo=").append(photo);
        sb.append(", description='").append(description).append('\'');
        sb.append(", inviteLink='").append(inviteLink).append('\'');
        sb.append(", pinnedMessage=").append(pinnedMessage);
        sb.append(", stickerSetName='").append(stickerSetName).append('\'');
        sb.append(", canSetStickerSet=").append(canSetStickerSet);
        sb.append('}');
        return sb.toString();
    }
}
