package org.rp.telegram.botapi.request;

import org.rp.telegram.botapi.helper.FormatOption;

import java.io.Serializable;

public class SendMessageRequest implements Serializable {
    private static final long serialVersionUID = 7472599720120541333L;

    // TODO: @Required // @NotEmpty
    private String chatId;

    // TODO: @Required // @NotEmpty
    private String text;

    private FormatOption parseMode;
    private Boolean disableWebPagePreview;
    private Boolean disableNotification;
    private Integer replyToMessageId;

    /* TODO:
    private InlineKeyboardMarkup replyMarkupInlineKeyboardMarkup;
    private ReplyKeyboardMarkup replyMarkupReplyKeyboardMarkup;
    private ReplyKeyboardRemove replyMarkupReplyKeyboardRemove;
    private ForceReply replyMarkupForceReply;
    */

    public SendMessageRequest() {
    }

    public static SendMessageRequest getInstance() {
        return new SendMessageRequest();
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
}
