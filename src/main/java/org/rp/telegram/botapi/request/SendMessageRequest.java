package org.rp.telegram.botapi.request;

import org.rp.telegram.botapi.entity.ForceReply;
import org.rp.telegram.botapi.entity.InlineKeyboardMarkup;
import org.rp.telegram.botapi.entity.ReplyKeyboardMarkup;
import org.rp.telegram.botapi.entity.ReplyKeyboardRemove;
import org.rp.telegram.botapi.helper.FormatOption;

import java.io.Serializable;
import java.util.Objects;

//TODO: add javadoc
//TODO: add unit test for converter to json

/**
 *
 * @author        Roman Parshin, roman.dev@gmail.com
 * @version       1.0
 * @since         1.0
 * @apiVersion    4.1
 */
public class SendMessageRequest implements Serializable {
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

    private InlineKeyboardMarkup replyMarkupInlineKeyboardMarkup;
    private ReplyKeyboardMarkup replyMarkupReplyKeyboardMarkup;
    private ReplyKeyboardRemove replyMarkupReplyKeyboardRemove;
    private ForceReply replyMarkupForceReply;

    public SendMessageRequest() {
    }

    public SendMessageRequest(Builder builder) {
        this.chatId = builder.chatId;
        this.text = builder.text;
        this.parseMode = builder.parseMode;
        this.disableWebPagePreview = builder.disableWebPagePreview;
        this.disableNotification = builder.disableNotification;
        this.replyToMessageId = builder.replyToMessageId;
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

        public Builder() {

        }

        public Builder chatId(Integer chatId) {
            this.chatId = chatId.toString();
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder parseMode(FormatOption parseMode) {
            this.parseMode = parseMode;
            return this;
        }

        public Builder disableWebPagePreview(Boolean disableWebPagePreview) {
            this.disableWebPagePreview = disableWebPagePreview;
            return this;
        }

        public Builder disableNotification(Boolean disableNotification) {
            this.disableNotification = disableNotification;
            return this;
        }

        public Builder replyToMessageId(Integer replyToMessageId) {
            this.replyToMessageId = replyToMessageId;
            return this;
        }

        public SendMessageRequest build() {
            return new SendMessageRequest(this);
        }

    }
}
