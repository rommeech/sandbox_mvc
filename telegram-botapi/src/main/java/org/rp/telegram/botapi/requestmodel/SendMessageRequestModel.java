package org.rp.telegram.botapi.requestmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.rp.telegram.botapi.BotApiRequestModel;
import org.rp.telegram.botapi.util.ParseMode;

import java.util.Objects;

/**
 * RequestModel to send text messages.
 *
 * See also: https://core.telegram.org/bots/api#sendmessage
 *
 * @author     rp
 * @version    4.6
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMessageRequestModel implements BotApiRequestModel {

    private static final long serialVersionUID = 7845603988170609979L;

    @JsonProperty(value = "chat_id")
    private String chatId;

    @JsonProperty(value = "text")
    private String text;

    @JsonProperty(value = "parse_mode")
    private ParseMode parseMode;

    @JsonProperty(value = "disable_web_page_preview")
    private Boolean disableWebPagePreview;

    @JsonProperty(value = "disable_notification")
    private Boolean disableNotification;

    @JsonProperty(value = "reply_to_message_id")
    private Long replyToMessageId;

    @JsonProperty(value = "reply_markup")
    private Object replyMarkup;

    private SendMessageRequestModel(SendMessageRequestModel.Builder builder) {
        this.chatId = builder.chatId;
        this.text = builder.text;
        this.parseMode = builder.parseMode;
        this.disableWebPagePreview = builder.disableWebPagePreview;
        this.disableNotification = builder.disableNotification;
        this.replyToMessageId = builder.replyToMessageId;
        this.replyMarkup = builder.replyMarkup;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Unique identifier for the target chat or username of the target channel
     * (in the format @channelusername)
     *
     * @return    target chat identifier
     */
    public String getChatId() {
        return chatId;
    }

    /**
     *
     * @param    chatId    target chat identifier
     */
    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    /**
     * Text of the message to be sent, 1-4096 characters after entities parsing
     *
     * @return    text of the message
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param    text    text of the message
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Send Markdown or HTML, if you want Telegram apps to show bold, italic,
     * fixed-width text or inline URLs in your bot's message.
     *
     * @return
     */
    public ParseMode getParseMode() {
        return parseMode;
    }

    /**
     *
     * @param    parseMode   parse mode
     */
    public void setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
    }

    /**
     * Disables link previews for links in this message
     *
     * @return    true to disable link previews
     */
    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    /**
     *
     * @param    disableWebPagePreview    true when link previews should be disabled
     */
    public void setDisableWebPagePreview(Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
    }

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     *
     * @return    true to send the message silently
     */
    public Boolean getDisableNotification() {
        return disableNotification;
    }

    /**
     *
     * @param    disableNotification    true when the message silently should be sent
     */
    public void setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    /**
     * If the message is a reply, ID of the original message
     *
     * @return    ID of the original message
     */
    public Long getReplyToMessageId() {
        return replyToMessageId;
    }

    /**
     *
     * @param    replyToMessageId    ID of the original message
     */
    public void setReplyToMessageId(Long replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    /**
     * Additional interface options. A JSON-serialized object for an inline keyboard,
     * custom reply keyboard, instructions to remove reply keyboard or to force a reply
     * from the user.
     *
     * @return    interface options
     */
    public Object getReplyMarkup() {
        return replyMarkup;
    }

    /**
     *
     * @param    replyMarkup    interface options
     */
    public void setReplyMarkup(Object replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendMessageRequestModel that = (SendMessageRequestModel) o;
        return Objects.equals(chatId, that.chatId) &&
                Objects.equals(text, that.text) &&
                parseMode == that.parseMode &&
                Objects.equals(disableWebPagePreview, that.disableWebPagePreview) &&
                Objects.equals(disableNotification, that.disableNotification) &&
                Objects.equals(replyToMessageId, that.replyToMessageId) &&
                Objects.equals(replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, text, parseMode, disableWebPagePreview, disableNotification,
                replyToMessageId, replyMarkup);
    }

    @Override
    public String toString() {
        return "MessageRequestModel{" +
                "chatId='" + chatId + '\'' +
                ", text='" + text + '\'' +
                ", parseMode=" + parseMode +
                ", disableWebPagePreview=" + disableWebPagePreview +
                ", disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                ", replyMarkup=" + replyMarkup +
                '}';
    }

    /**
     * MessageRequestModel Builder
     */
    public static class Builder {

        private String chatId;
        private String text;
        private ParseMode parseMode;
        private Boolean disableWebPagePreview;
        private Boolean disableNotification;
        private Long replyToMessageId;
        private Object replyMarkup;

        /**
         * 
         * @param     chatId
         * @return    Builder instance
         */
        public SendMessageRequestModel.Builder chatId(String chatId) {
            this.chatId = chatId;
            return this;
        }

        /**
         * 
         * @param     text
         * @return    Builder instance
         */
        public SendMessageRequestModel.Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * 
         * @param     parseMode
         * @return    Builder instance
         */
        public SendMessageRequestModel.Builder parseMode(ParseMode parseMode) {
            this.parseMode = parseMode;
            return this;
        }

        /**
         * 
         * @param disableWebPagePreview
         * @return    Builder instance
         */
        public SendMessageRequestModel.Builder disableWebPagePreview(Boolean disableWebPagePreview) {
            this.disableWebPagePreview = disableWebPagePreview;
            return this;
        }

        /**
         * 
         * @param disableNotification
         * @return    Builder instance
         */
        public SendMessageRequestModel.Builder disableNotification(Boolean disableNotification) {
            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * 
         * @param replyToMessageId
         * @return    Builder instance
         */
        public SendMessageRequestModel.Builder replyToMessageId(Long replyToMessageId) {
            this.replyToMessageId = replyToMessageId;
            return this;
        }

        /**
         * 
         * @param replyMarkup
         * @return    Builder instance
         */
        public SendMessageRequestModel.Builder replyMarkup(Object replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * 
         * @return    MessageRequestModel instance
         */
        public SendMessageRequestModel build() {
            return new SendMessageRequestModel(this);
        }
    }
}
