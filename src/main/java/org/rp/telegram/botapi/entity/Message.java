package org.rp.telegram.botapi.entity;

import java.util.Date;

public class Message extends AbstractEntity {
    private static final long serialVersionUID = 5854342279136595699L;

    private Integer messageId;
    //private User from;
    private Date date;
    //private Chat chat;
    //private User forwardFrom;
    //private Chat forwardFromChat;
    private Integer forwardFromMessageId;
    private String forwardSignature;
    private Date forwardDate;
    private Message replyToMessage;
    private Date editDate;
    private String mediaGroupId;
    private String authorSignature;
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
    private String caption;
    //private Contact contact;
    //private Location location;
    //private Venue venue;
    //private List<User> new_chat_members;
    //private User left_chat_member;
    private String new_chat_title;
    //private List<PhotoSize> new_chat_photo;
    private Boolean delete_chat_photo;
    private Boolean group_chat_created;
    private Boolean supergroup_chat_created;
    private Boolean channel_chat_created;
    private Integer migrate_to_chat_id;
    private Integer migrate_from_chat_id;
    private Message pinned_message;
    //private Invoice invoice;
    //private SuccessfulPayment successful_payment;
    private String connected_website;
    //private PassportData passport_data;





    public Message() {
    }
}
