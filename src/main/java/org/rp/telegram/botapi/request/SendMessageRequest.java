package org.rp.telegram.botapi.request;

import org.rp.telegram.botapi.entity.*;
import org.rp.telegram.botapi.helper.FormatOption;

import java.io.Serializable;
import java.util.Objects;

//TODO: add unit test for converter to json

/**
 * Use this method to send text messages. On success, the sent Message is returned.
 *
 * @author        Roman Parshin, roman.dev@gmail.com
 * @version       1.0
 * @since         1.0
 * @apiVersion    4.1
 */
public class SendMessageRequest extends AbstractApiRequest {
    private static final long serialVersionUID = 7472599720120541333L;

    // TODO: Add some annotation to convert field to json-field in request

    // TODO: @Required // @NotEmpty
    private String chatId;

    // TODO: @Required // @NotEmpty
    private String text;

    private FormatOption parseMode;
    private Boolean disableWebPagePreview;
    private Boolean disableNotification;
    private Integer replyToMessageId;
    private AbstractEntity replyMarkup;

    public SendMessageRequest() {
    }

    @Override
    public String getApiMethodName() {
        return "sendMessage";
    }

    @Override
    public void doRequest(String token) {

    }

    public SendMessageRequest(Builder builder) {
        this.chatId = builder.chatId;
        this.text = builder.text;
        this.parseMode = builder.parseMode;
        this.disableWebPagePreview = builder.disableWebPagePreview;
        this.disableNotification = builder.disableNotification;
        this.replyToMessageId = builder.replyToMessageId;
        this.replyMarkup = builder.replyMarkup;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public FormatOption getParseMode() {
        return parseMode;
    }

    public void setParseMode(FormatOption parseMode) {
        this.parseMode = parseMode;
    }

    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    public void setDisableWebPagePreview(Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public void setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public void setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    public AbstractEntity getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    public void setReplyMarkup(ReplyKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    public void setReplyMarkup(ReplyKeyboardRemove replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    public void setReplyMarkup(ForceReply replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SendMessageRequest)) return false;
        SendMessageRequest that = (SendMessageRequest) o;
        return Objects.equals(chatId, that.chatId) &&
                Objects.equals(text, that.text) &&
                parseMode == that.parseMode &&
                Objects.equals(disableWebPagePreview, that.disableWebPagePreview) &&
                Objects.equals(disableNotification, that.disableNotification) &&
                Objects.equals(replyToMessageId, that.replyToMessageId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(chatId, text, parseMode, disableWebPagePreview, disableNotification, replyToMessageId);
    }

    @Override
    public String toString() {
        return "SendMessageRequest{" +
                "chatId='" + chatId + '\'' +
                ", text='" + text + '\'' +
                ", parseMode=" + parseMode +
                ", disableWebPagePreview=" + disableWebPagePreview +
                ", disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                '}';
    }

    public static class Builder {

        private String chatId;
        private String text;
        private FormatOption parseMode;
        private Boolean disableWebPagePreview;
        private Boolean disableNotification;
        private Integer replyToMessageId;
        private AbstractEntity replyMarkup;

        public Builder() {
        }

        /**
         * @param    chatId   Unique identifier for the target chat
         * @return   a reference to this object.
         */
        public Builder chatId(Integer chatId) {
            this.chatId = chatId.toString();
            return this;
        }

        /**
         * @param    username   Unique username of the target channel (in the format @channelusername)
         * @return   a reference to this object.
         */
        public Builder chatId(String username) {
            this.chatId = username;
            return this;
        }

        /**
         * @param    text   Text of the message to be sent
         * @return   a reference to this object.
         */
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs
         * in your bot's message.
         *
         * @param    parseMode   Markdown or HTML
         * @return   a reference to this object.
         */
        public Builder parseMode(FormatOption parseMode) {
            this.parseMode = parseMode;
            return this;
        }

        /**
         * Disables link previews for links in this message
         *
         * @param    disableWebPagePreview   disable_web_page_preview
         * @return   a reference to this object.
         */
        public Builder disableWebPagePreview(Boolean disableWebPagePreview) {
            this.disableWebPagePreview = disableWebPagePreview;
            return this;
        }

        /**
         * Sends the message silently. Users will receive a notification with no sound.
         *
         * @param    disableNotification   disable_notification
         * @return   a reference to this object.
         */
        public Builder disableNotification(Boolean disableNotification) {
            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * If the message is a reply, ID of the original message
         *
         * @param    replyToMessageId   ID of the original message
         * @return   a reference to this object.
         */
        public Builder replyToMessageId(Integer replyToMessageId) {
            this.replyToMessageId = replyToMessageId;
            return this;
        }

        /**
         * Additional interface options. A JSON-serialized object for an inline keyboard.
         *
         * @param    replyMarkup   InlineKeyboardMarkup object
         * @return   a reference to this object.
         */
        public Builder replyMarkup(InlineKeyboardMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * Additional interface options. A JSON-serialized object for a custom reply keyboard.
         *
         * @param    replyMarkup   ReplyKeyboardMarkup object
         * @return   a reference to this object.
         */
        public Builder replyMarkup(ReplyKeyboardMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * Additional interface options. A JSON-serialized object for an instructions to remove reply keyboard.
         *
         * @param    replyMarkup   ReplyKeyboardRemove object
         * @return   a reference to this object.
         */
        public Builder replyMarkup(ReplyKeyboardRemove replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * Additional interface options. A JSON-serialized object to force a reply from the user.
         *
         * @param    replyMarkup   ForceReply object
         * @return   a reference to this object.
         */
        public Builder replyMarkup(ForceReply replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * Build and return SendMessageRequest object.
         *
         * @return   SendMessageRequest object.
         */
        public SendMessageRequest build() {
            return new SendMessageRequest(this);
        }

    }
}
