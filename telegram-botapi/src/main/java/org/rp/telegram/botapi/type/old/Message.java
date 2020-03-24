package org.rp.telegram.botapi.type.old;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

// TODO: Add javadoc

public class Message extends AbstractEntity {
    private static final long serialVersionUID = 5854342279136595699L;

    @JsonProperty(value = "message_id")
    private Integer messageId;

    //private User from;

    @JsonProperty(value = "date")
    private Date date;

    @JsonProperty(value = "chat")
    private Chat chat;

    //private User forwardFrom;
    //private Chat forwardFromChat;
    //private Integer forwardFromMessageId;
    //private String forwardSignature;
    //private Date forwardDate;
    //private Message replyToMessage;

    @JsonProperty(value = "edit_date")
    private Date editDate;

    @JsonProperty(value = "media_group_id")
    private String mediaGroupId;

    @JsonProperty(value = "author_signature")
    private String authorSignature;

    @JsonProperty(value = "text")
    private String text;

    //private List<MessageEntity> entities;
    //private List<MessageEntity> captionEntities;
    //private Audio audio;
    //private Document document;
    //private Animation animation;
    //private Game game;
    //private List<PhotoSize> photo;
    //private Sticker sticker;
    //private Video video;
    //private Voice voice;
    //private VideoNote video_note;

    @JsonProperty(value = "caption")
    private String caption;

    //private Contact contact;
    //private Location location;
    //private Venue venue;
    //private List<User> new_chat_members;
    //private User left_chat_member;

    @JsonProperty(value = "new_chat_title")
    private String newChatTitle;

    //private List<PhotoSize> new_chat_photo;

    @JsonProperty(value = "delete_chat_photo")
    private Boolean deleteChatPhoto;

    @JsonProperty(value = "group_chat_created")
    private Boolean groupChatCreated;

    @JsonProperty(value = "supergroup_chat_created")
    private Boolean supergroupChatCreated;

    @JsonProperty(value = "channel_chat_created")
    private Boolean channelChatCreated;

    @JsonProperty(value = "migrate_to_chat_id")
    private Integer migrateToChatId;

    @JsonProperty(value = "migrate_from_chat_id")
    private Integer migrateFromChatId;

    @JsonProperty(value = "pinned_message")
    private Message pinnedMessage;

    //private Invoice invoice

    //private SuccessfulPayment successful_payment;

    @JsonProperty(value = "connected_website")
    private String connectedWebsite;

    //private PassportData passport_data;

    public Message() {
    }

    // TODO: add getters and setters


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(messageId, message.messageId) &&
                Objects.equals(chat, message.chat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, chat);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("messageId=").append(messageId);
        sb.append(", date=").append(date);
        sb.append(", chat=").append(chat);
        sb.append(", editDate=").append(editDate);
        sb.append(", mediaGroupId='").append(mediaGroupId).append('\'');
        sb.append(", authorSignature='").append(authorSignature).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", caption='").append(caption).append('\'');
        sb.append(", newChatTitle='").append(newChatTitle).append('\'');
        sb.append(", deleteChatPhoto=").append(deleteChatPhoto);
        sb.append(", groupChatCreated=").append(groupChatCreated);
        sb.append(", supergroupChatCreated=").append(supergroupChatCreated);
        sb.append(", channelChatCreated=").append(channelChatCreated);
        sb.append(", migrateToChatId=").append(migrateToChatId);
        sb.append(", migrateFromChatId=").append(migrateFromChatId);
        sb.append(", pinnedMessage=").append(pinnedMessage);
        sb.append(", connectedWebsite='").append(connectedWebsite).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
