package org.rp.telegram.botapi.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.rp.telegram.botapi.BotApiResultType;
import org.rp.telegram.botapi.json.serialize.JacksonListDeserializer;
import org.rp.telegram.botapi.json.serialize.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * This object represents a chat.
 *
 * See also: https://core.telegram.org/bots/api#message
 *
 * @author     rp
 * @version    4.6
 */

    // TODO: refactoring
    // TODO: builder
    // TODO: unittests
    // TODO: javadoc
    // TODO: deserializers

public class Message implements BotApiResultType {

    private static final long serialVersionUID = 5854342279136595699L;

    @JsonProperty(value = "message_id")
    private Long messageId;

    @JsonProperty(value = "from")
    private User from;

    @JsonProperty(value = "date")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime date;

    @JsonProperty(value = "sender_chat")
    private Chat senderChat;

    @JsonProperty(value = "chat")
    private Chat chat;

    @JsonProperty(value = "forward_from")
    private User forwardFrom;

    @JsonProperty(value = "forward_from_chat")
    private Chat forwardFromChat;

    @JsonProperty(value = "forward_from_message_id")
    private Long forwardFromMessageId;

    @JsonProperty(value = "forward_signature")
    private String forwardSignature;

    @JsonProperty(value = "forward_sender_name")
    private String forwardSenderName;

    @JsonProperty(value = "forward_date")
    private LocalDateTime forwardDate;

    @JsonProperty(value = "reply_to_message")
    private Message replyToMessage;

    @JsonProperty(value = "via_bot")
    private User viaBot;

    @JsonProperty(value = "edit_date")
    private LocalDateTime editDate;

    @JsonProperty(value = "media_group_id")
    private String mediaGroupId;

    @JsonProperty(value = "author_signature")
    private String authorSignature;

    @JsonProperty(value = "text")
    private String text;

    @JsonProperty(value = "entities")
    private List<MessageEntity> entities;

    @JsonProperty(value = "caption_entities")
    private List<MessageEntity> captionEntities;

    // TODO: Should be Audio
    @JsonProperty(value = "audio")
    private Object audio;

    // TODO: Should be Document
    @JsonProperty(value = "document")
    private Object document;

    // TODO: Should be Animation
    @JsonProperty(value = "animation")
    private Object animation;

    // TODO: Should be Game
    @JsonProperty(value = "game")
    private Object game;

    // TODO: Should be PhotoSize
    @JsonProperty(value = "photo")
    private List<Object> photo;

    // TODO: Should be Sticker
    @JsonProperty(value = "sticker")
    private Object sticker;

    // TODO: Should be Video
    @JsonProperty(value = "video")
    private Object video;

    // TODO: Should be Voice
    @JsonProperty(value = "voice")
    private Object voice;

    // TODO: Should be VideoNote
    @JsonProperty(value = "video_note")
    private Object videoNote;

    @JsonProperty(value = "caption")
    private String caption;

    // TODO: Should be Contact
    @JsonProperty(value = "contact")
    private Object contact;

    // TODO: Should be Location
    @JsonProperty(value = "location")
    private Object location;

    // TODO: Should be Venue
    @JsonProperty(value = "venue")
    private Object venue;

    // TODO: Should be Poll
    @JsonProperty(value = "poll")
    private Object poll;

    @JsonProperty(value = "new_chat_members")
    private List<User> newChatMembers;

    @JsonProperty(value = "left_chat_member")
    private User leftChatMember;

    @JsonProperty(value = "new_chat_title")
    private String newChatTitle;

    // TODO: Should be PhotoSize
    @JsonProperty(value = "new_chat_photo")
    private List<Object> newChatPhoto;

    @JsonProperty(value = "delete_chat_photo")
    private Boolean deleteChatPhoto;

    @JsonProperty(value = "group_chat_created")
    private Boolean groupChatCreated;

    @JsonProperty(value = "supergroup_chat_created")
    private Boolean supergroupChatCreated;

    @JsonProperty(value = "channel_chat_created")
    private Boolean channelChatCreated;

    @JsonProperty(value = "migrate_to_chat_id")
    private Long migrateToChatId;

    @JsonProperty(value = "migrate_from_chat_id")
    private Long migrateFromChatId;

    @JsonProperty(value = "pinned_message")
    private Message pinnedMessage;

    // TODO: Should be Invoice
    @JsonProperty(value = "invoice")
    private Object invoice;

    // TODO: Should be SuccessfulPayment
    @JsonProperty(value = "successful_payment")
    private Object successfulPayment;

    @JsonProperty(value = "connected_website")
    private String connectedWebsite;

    // TODO: Should be PassportData
    @JsonProperty(value = "passport_data")
    private Object passportData;

    // TODO: Should be InlineKeyboardMarkup
    @JsonProperty(value = "reply_markup")
    private Object replyMarkup;

    /**
     * Default constructor
     */
    public Message() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Unique message identifier inside this chat
     *
     * @return    message identifier
     */
    public Long getMessageId() {
        return messageId;
    }

    /**
     * @param    messageId   message identifier
     */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    /**
     * Optional. Sender, empty for messages sent to channels
     *
     * @return    sender
     */
    public User getFrom() {
        return from;
    }

    /**
     * @param    from    sender
     */
    public void setFrom(User from) {
        this.from = from;
    }

    /**
     * Date the message was sent
     *
     * @return    date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @param    date    date the message was sent
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Conversation the message belongs to
     *
     * @return    chat object
     */
    public Chat getChat() {
        return chat;
    }

    /**
     * @param    chat    chat object
     */
    public void setChat(Chat chat) {
        this.chat = chat;
    }

    /**
     * Optional. For forwarded messages, sender of the original message
     * @return    sender
     */
    public User getForwardFrom() {
        return forwardFrom;
    }

    /**
     * @param    forwardFrom    sender of the original message
     */
    public void setForwardFrom(User forwardFrom) {
        this.forwardFrom = forwardFrom;
    }

    /**
     * Optional. For messages forwarded from channels, information about the original channel.
     *
     * @return    original channel
     */
    public Chat getForwardFromChat() {
        return forwardFromChat;
    }

    /**
     * @param    forwardFromChat    original channel
     */
    public void setForwardFromChat(Chat forwardFromChat) {
        this.forwardFromChat = forwardFromChat;
    }

    /**
     * Optional. For messages forwarded from channels, identifier of the original message in the channel
     *
     * @return    identifier of the original message
     */
    public Long getForwardFromMessageId() {
        return forwardFromMessageId;
    }

    /**
     * @param    forwardFromMessageId    identifier of the original message
     */
    public void setForwardFromMessageId(Long forwardFromMessageId) {
        this.forwardFromMessageId = forwardFromMessageId;
    }

    /**
     * Optional. For messages forwarded from channels, signature of the post author if present
     *
     * @return    signature of the post author
     */
    public String getForwardSignature() {
        return forwardSignature;
    }

    /**
     * @param    forwardSignature    signature of the post author
     */
    public void setForwardSignature(String forwardSignature) {
        this.forwardSignature = forwardSignature;
    }

    /**
     * Optional. Sender's name for messages forwarded from users who disallow adding a link
     * to their account in forwarded messages
     *
     * @return    sender's name
     */
    public String getForwardSenderName() {
        return forwardSenderName;
    }

    /**
     * @param    forwardSenderName    sender's name
     */
    public void setForwardSenderName(String forwardSenderName) {
        this.forwardSenderName = forwardSenderName;
    }

    /**
     * Optional. For forwarded messages, date the original message was sent in Unix time
     *
     * @return    date the original message
     */
    public LocalDateTime getForwardDate() {
        return forwardDate;
    }

    /**
     * @param    forwardDate    date the original message
     */
    public void setForwardDate(LocalDateTime forwardDate) {
        this.forwardDate = forwardDate;
    }

    /**
     * Optional. For replies, the original message. Note that the Message object
     * in this field will not contain further reply_to_message fields even if it
     * itself is a reply.
     *
     * @return    original message
     */
    public Message getReplyToMessage() {
        return replyToMessage;
    }

    /**
     * @param    replyToMessage    original message
     */
    public void setReplyToMessage(Message replyToMessage) {
        this.replyToMessage = replyToMessage;
    }

    /**
     * Optional. Date the message was last edited in Unix time
     *
     * @return    last edited date
     */
    public LocalDateTime getEditDate() {
        return editDate;
    }

    /**
     * @param    editDate    last edited date
     */
    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }

    /**
     * Optional. The unique identifier of a media message group this message belongs to
     *
     * @return    unique identifier of a media message group
     */
    public String getMediaGroupId() {
        return mediaGroupId;
    }

    /**
     * @param    mediaGroupId    unique identifier of a media message group
     */
    public void setMediaGroupId(String mediaGroupId) {
        this.mediaGroupId = mediaGroupId;
    }

    /**
     * Optional. Signature of the post author for messages in channels
     *
     * @return    signature of the post author
     */
    public String getAuthorSignature() {
        return authorSignature;
    }

    /**
     * @param    authorSignature    signature of the post author
     */
    public void setAuthorSignature(String authorSignature) {
        this.authorSignature = authorSignature;
    }

    /**
     * Optional. For text messages, the actual UTF-8 text of the message, 0-4096 characters
     *
     * @return    text of the message
     */
    public String getText() {
        return text;
    }

    /**
     * @param    text    text of the message
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Optional. For text messages, special entities like usernames, URLs,
     * bot commands, etc. that appear in the text
     *
     * @return    special entity list for text messages
     */
    public List<MessageEntity> getEntities() {
        return entities;
    }

    /**
     * @param    entities    special entity list for text messages
     */
    public void setEntities(List<MessageEntity> entities) {
        this.entities = entities;
    }

    /**
     * Optional. For messages with a caption, special entities like usernames,
     * URLs, bot commands, etc. that appear in the caption
     *
     * @return    special entity list for messages with a caption
     */
    public List<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

    /**
     * @param    captionEntities    special entity list for messages with a caption
     */
    public void setCaptionEntities(List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
    }

    /**
     * Optional. Message is an audio file, information about the file
     *
     * @return    audio object
     */
    public Object getAudio() {
        return audio;
    }

    /**
     * @param    audio    audio object
     */
    public void setAudio(Object audio) {
        this.audio = audio;
    }

    /**
     * Optional. Message is a general file, information about the file
     *
     * @return    document object
     */
    public Object getDocument() {
        return document;
    }

    /**
     * @param    document    document object
     */
    public void setDocument(Object document) {
        this.document = document;
    }

    /**
     * Optional. Message is an animation, information about the animation. For backward
     * compatibility, when this field is set, the document field will also be set
     *
     * @return    animation object
     */
    public Object getAnimation() {
        return animation;
    }

    /**
     * @param    animation    animation object
     */
    public void setAnimation(Object animation) {
        this.animation = animation;
    }

    /**
     * Optional. Message is a game, information about the game. More about games: {@link Game}
     *
     * @return    game object
     */
    public Object getGame() {
        return game;
    }

    /**
     * @param    game    game object
     */
    public void setGame(Object game) {
        this.game = game;
    }

    /**
     * Optional. Message is a photo, available sizes of the photo
     *
     * @return    photo object
     */
    public List<Object> getPhoto() {
        return photo;
    }

    /**
     * @param    photo    photo object
     */
    public void setPhoto(List<Object> photo) {
        this.photo = photo;
    }

    /**
     * Optional. Message is a sticker, information about the sticker
     *
     * @return    sticker object
     */
    public Object getSticker() {
        return sticker;
    }

    /**
     * @param    sticker    sticker object
     */
    public void setSticker(Object sticker) {
        this.sticker = sticker;
    }

    /**
     * Optional. Message is a video, information about the video
     *
     * @return    video object
     */
    public Object getVideo() {
        return video;
    }

    /**
     * @param    video    video object
     */
    public void setVideo(Object video) {
        this.video = video;
    }

    /**
     * Optional. Message is a voice message, information about the file
     *
     * @return    voice object
     */
    public Object getVoice() {
        return voice;
    }

    /**
     * @param    voice    voice object
     */
    public void setVoice(Object voice) {
        this.voice = voice;
    }

    /**
     * Optional. Message is a video note, information about the video message
     *
     * @return    video note object
     */
    public Object getVideoNote() {
        return videoNote;
    }

    /**
     * @param    videoNote    video note object
     */
    public void setVideoNote(Object videoNote) {
        this.videoNote = videoNote;
    }

    /**
     * Optional. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
     *
     * @return    caption of media object
     */
    public String getCaption() {
        return caption;
    }

    /**
     * @param    caption    caption of media object
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * Optional. Message is a shared contact, information about the contact
     *
     * @return    contact object
     */
    public Object getContact() {
        return contact;
    }

    /**
     * @param    contact    contact object
     */
    public void setContact(Object contact) {
        this.contact = contact;
    }

    /**
     * Optional. Message is a shared location, information about the location
     *
     * @return    location object
     */
    public Object getLocation() {
        return location;
    }

    /**
     * @param    location    location object
     */
    public void setLocation(Object location) {
        this.location = location;
    }

    /**
     * Optional. Message is a venue, information about the venue
     *
     * @return    venue object
     */
    public Object getVenue() {
        return venue;
    }

    /**
     * @param    venue    venue object
     */
    public void setVenue(Object venue) {
        this.venue = venue;
    }

    /**
     * Optional. Message is a native poll, information about the poll
     *
     * @return    poll object
     */
    public Object getPoll() {
        return poll;
    }

    /**
     * @param    poll    poll object
     */
    public void setPoll(Object poll) {
        this.poll = poll;
    }

    /**
     * Optional. New members that were added to the group or supergroup and information
     * about them (the bot itself may be one of these members)
     *
     * @return    new members information
     */
    public List<User> getNewChatMembers() {
        return newChatMembers;
    }

    /**
     * @param    newChatMembers    new members information
     */
    public void setNewChatMembers(List<User> newChatMembers) {
        this.newChatMembers = newChatMembers;
    }

    /**
     * Optional. A member was removed from the group, information about them
     * (this member may be the bot itself)
     *
     * @return    removed member information
     */
    public User getLeftChatMember() {
        return leftChatMember;
    }

    /**
     * @param    leftChatMember    removed member information
     */
    public void setLeftChatMember(User leftChatMember) {
        this.leftChatMember = leftChatMember;
    }

    /**
     * Optional. A chat title was changed to this value
     *
     * @return    new chat title
     */
    public String getNewChatTitle() {
        return newChatTitle;
    }

    /**
     * @param    newChatTitle    new chat title
     */
    public void setNewChatTitle(String newChatTitle) {
        this.newChatTitle = newChatTitle;
    }

    /**
     * Optional. A chat photo was change to this value
     *
     * @return    new chat photo
     */
    public List<Object> getNewChatPhoto() {
        return newChatPhoto;
    }

    /**
     * @param    newChatPhoto    new chat photo
     */
    public void setNewChatPhoto(List<Object> newChatPhoto) {
        this.newChatPhoto = newChatPhoto;
    }

    /**
     * Optional. Service message: the chat photo was deleted
     *
     * @return   true when chat photo was deleted
     */
    public Boolean getDeleteChatPhoto() {
        return deleteChatPhoto;
    }

    /**
     * @param    deleteChatPhoto    true when chat photo was deleted
     */
    public void setDeleteChatPhoto(Boolean deleteChatPhoto) {
        this.deleteChatPhoto = deleteChatPhoto;
    }

    /**
     * Optional. Service message: the group has been created
     *
     * @return    true when the group has been created
     */
    public Boolean getGroupChatCreated() {
        return groupChatCreated;
    }

    /**
     * @param    groupChatCreated    true when the group has been created
     */
    public void setGroupChatCreated(Boolean groupChatCreated) {
        this.groupChatCreated = groupChatCreated;
    }

    /**
     * Optional. Service message: the supergroup has been created. This field can‘t be
     * received in a message coming through updates, because bot can’t be a member of
     * a supergroup when it is created. It can only be found in reply_to_message if
     * someone replies to a very first message in a directly created supergroup.
     *
     * @return    true when the supergroup has been created
     */
    public Boolean getSupergroupChatCreated() {
        return supergroupChatCreated;
    }

    /**
     * @param    supergroupChatCreated    true when the supergroup has been created
     */
    public void setSupergroupChatCreated(Boolean supergroupChatCreated) {
        this.supergroupChatCreated = supergroupChatCreated;
    }

    /**
     * Optional. Service message: the channel has been created. This field can‘t be
     * received in a message coming through updates, because bot can’t be a member
     * of a channel when it is created. It can only be found in reply_to_message
     * if someone replies to a very first message in a channel.
     *
     * @return    true when the channel has been created
     */
    public Boolean getChannelChatCreated() {
        return channelChatCreated;
    }

    /**
     * @param    channelChatCreated    true when the channel has been created
     */
    public void setChannelChatCreated(Boolean channelChatCreated) {
        this.channelChatCreated = channelChatCreated;
    }

    /**
     * Optional. The group has been migrated to a supergroup with the specified identifier.
     *
     * @return    supergroup identifier
     */
    public Long getMigrateToChatId() {
        return migrateToChatId;
    }

    /**
     * @param    migrateToChatId    supergroup identifier
     */
    public void setMigrateToChatId(Long migrateToChatId) {
        this.migrateToChatId = migrateToChatId;
    }

    /**
     * Optional. The supergroup has been migrated from a group with the specified identifier.
     *
     * @return    group identifier
     */
    public Long getMigrateFromChatId() {
        return migrateFromChatId;
    }

    /**
     * @param    migrateFromChatId    group identifier
     */
    public void setMigrateFromChatId(Long migrateFromChatId) {
        this.migrateFromChatId = migrateFromChatId;
    }

    /**
     * Optional. Specified message was pinned. Note that the Message object
     * in this field will not contain further reply_to_message fields even
     * if it is itself a reply.
     *
     * @return    pinned message
     */
    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    /**
     * @param    pinnedMessage    pinned message
     */
    public void setPinnedMessage(Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
    }

    /**
     * Optional. Message is an invoice for a payment, information about the invoice.
     * More about payments {@link Invoice}
     *
     * @return    invoice information
     */
    public Object getInvoice() {
        return invoice;
    }

    /**
     * @param    invoice    invoice information
     */
    public void setInvoice(Object invoice) {
        this.invoice = invoice;
    }

    /**
     * Optional. Message is a service message about a successful payment,
     * information about the payment. More about payments {@link SuccessfulPayment}
     *
     * @return    successful payment information
     */
    public Object getSuccessfulPayment() {
        return successfulPayment;
    }

    /**
     * @param    successfulPayment    successful payment information
     */
    public void setSuccessfulPayment(Object successfulPayment) {
        this.successfulPayment = successfulPayment;
    }

    /**
     * Optional. The domain name of the website on which the user has logged in.
     * <a href="https://core.telegram.org/widgets/login">More about Telegram Login</a>
     *
     * @return    domain name
     */
    public String getConnectedWebsite() {
        return connectedWebsite;
    }

    /**
     * @param    connectedWebsite    domain name
     */
    public void setConnectedWebsite(String connectedWebsite) {
        this.connectedWebsite = connectedWebsite;
    }

    /**
     * Optional. Telegram Passport data
     *
     * @return    passport data
     */
    public Object getPassportData() {
        return passportData;
    }

    /**
     * @param    passportData    passport data
     */
    public void setPassportData(Object passportData) {
        this.passportData = passportData;
    }

    /**
     * Optional. Inline keyboard attached to the message. login_url
     * buttons are represented as ordinary url buttons.
     *
     * @return    inline keyboard
     */
    public Object getReplyMarkup() {
        return replyMarkup;
    }

    /**
     * @param    replyMarkup    inline keyboard
     */
    public void setReplyMarkup(Object replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(messageId, message.messageId) &&
                Objects.equals(from, message.from) &&
                Objects.equals(date, message.date) &&
                Objects.equals(chat, message.chat) &&
                Objects.equals(forwardFrom, message.forwardFrom) &&
                Objects.equals(forwardFromChat, message.forwardFromChat) &&
                Objects.equals(forwardFromMessageId, message.forwardFromMessageId) &&
                Objects.equals(forwardSignature, message.forwardSignature) &&
                Objects.equals(forwardSenderName, message.forwardSenderName) &&
                Objects.equals(forwardDate, message.forwardDate) &&
                Objects.equals(replyToMessage, message.replyToMessage) &&
                Objects.equals(editDate, message.editDate) &&
                Objects.equals(mediaGroupId, message.mediaGroupId) &&
                Objects.equals(authorSignature, message.authorSignature) &&
                Objects.equals(text, message.text) &&
                Objects.equals(entities, message.entities) &&
                Objects.equals(captionEntities, message.captionEntities) &&
                Objects.equals(audio, message.audio) &&
                Objects.equals(document, message.document) &&
                Objects.equals(animation, message.animation) &&
                Objects.equals(game, message.game) &&
                Objects.equals(photo, message.photo) &&
                Objects.equals(sticker, message.sticker) &&
                Objects.equals(video, message.video) &&
                Objects.equals(voice, message.voice) &&
                Objects.equals(videoNote, message.videoNote) &&
                Objects.equals(caption, message.caption) &&
                Objects.equals(contact, message.contact) &&
                Objects.equals(location, message.location) &&
                Objects.equals(venue, message.venue) &&
                Objects.equals(poll, message.poll) &&
                Objects.equals(newChatMembers, message.newChatMembers) &&
                Objects.equals(leftChatMember, message.leftChatMember) &&
                Objects.equals(newChatTitle, message.newChatTitle) &&
                Objects.equals(newChatPhoto, message.newChatPhoto) &&
                Objects.equals(deleteChatPhoto, message.deleteChatPhoto) &&
                Objects.equals(groupChatCreated, message.groupChatCreated) &&
                Objects.equals(supergroupChatCreated, message.supergroupChatCreated) &&
                Objects.equals(channelChatCreated, message.channelChatCreated) &&
                Objects.equals(migrateToChatId, message.migrateToChatId) &&
                Objects.equals(migrateFromChatId, message.migrateFromChatId) &&
                Objects.equals(pinnedMessage, message.pinnedMessage) &&
                Objects.equals(invoice, message.invoice) &&
                Objects.equals(successfulPayment, message.successfulPayment) &&
                Objects.equals(connectedWebsite, message.connectedWebsite) &&
                Objects.equals(passportData, message.passportData) &&
                Objects.equals(replyMarkup, message.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, from, date, chat, forwardFrom, forwardFromChat, forwardFromMessageId,
                forwardSignature, forwardSenderName, forwardDate, replyToMessage, editDate, mediaGroupId,
                authorSignature, text, entities, captionEntities, audio, document, animation, game, photo,
                sticker, video, voice, videoNote, caption, contact, location, venue, poll, newChatMembers,
                leftChatMember, newChatTitle, newChatPhoto, deleteChatPhoto, groupChatCreated,
                supergroupChatCreated, channelChatCreated, migrateToChatId, migrateFromChatId, pinnedMessage,
                invoice, successfulPayment, connectedWebsite, passportData, replyMarkup);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", forwardFrom=" + forwardFrom +
                ", forwardFromChat=" + forwardFromChat +
                ", forwardFromMessageId=" + forwardFromMessageId +
                ", forwardSignature='" + forwardSignature + '\'' +
                ", forwardSenderName='" + forwardSenderName + '\'' +
                ", forwardDate=" + forwardDate +
                ", replyToMessage=" + replyToMessage +
                ", editDate=" + editDate +
                ", mediaGroupId='" + mediaGroupId + '\'' +
                ", authorSignature='" + authorSignature + '\'' +
                ", text='" + text + '\'' +
                ", entities=" + entities +
                ", captionEntities=" + captionEntities +
                ", audio=" + audio +
                ", document=" + document +
                ", animation=" + animation +
                ", game=" + game +
                ", photo=" + photo +
                ", sticker=" + sticker +
                ", video=" + video +
                ", voice=" + voice +
                ", videoNote=" + videoNote +
                ", caption='" + caption + '\'' +
                ", contact=" + contact +
                ", location=" + location +
                ", venue=" + venue +
                ", poll=" + poll +
                ", newChatMembers=" + newChatMembers +
                ", leftChatMember=" + leftChatMember +
                ", newChatTitle='" + newChatTitle + '\'' +
                ", newChatPhoto=" + newChatPhoto +
                ", deleteChatPhoto=" + deleteChatPhoto +
                ", groupChatCreated=" + groupChatCreated +
                ", supergroupChatCreated=" + supergroupChatCreated +
                ", channelChatCreated=" + channelChatCreated +
                ", migrateToChatId=" + migrateToChatId +
                ", migrateFromChatId=" + migrateFromChatId +
                ", pinnedMessage=" + pinnedMessage +
                ", invoice=" + invoice +
                ", successfulPayment=" + successfulPayment +
                ", connectedWebsite='" + connectedWebsite + '\'' +
                ", passportData=" + passportData +
                ", replyMarkup=" + replyMarkup +
                '}';
    }
}
