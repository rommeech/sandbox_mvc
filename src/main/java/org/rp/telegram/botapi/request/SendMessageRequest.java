package org.rp.telegram.botapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.telegram.botapi.entity.*;
import org.rp.telegram.botapi.helper.ApiMethod;
import org.rp.telegram.botapi.entity.FormatOption;
import org.rp.telegram.botapi.http.HttpClient;
import org.rp.telegram.botapi.http.HttpException;
import org.rp.telegram.botapi.http.HttpMethod;
import org.rp.telegram.botapi.response.MessageResponse;
import java.util.Objects;

//TODO: add unit test for converter to json
//TODO: split this class to SendMessageEntity and SendMessageRequest (model + logic)

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
    private static final Logger logger = LogManager.getLogger(SendMessageRequest.class);

    // TODO: @Required // @NotEmpty
    @JsonProperty(value = "chat_id")
    private String chatId;

    // TODO: @Required // @NotEmpty
    @JsonProperty(value = "text")
    private String text;

    @JsonProperty(value = "parse_mode")
    private FormatOption parseMode;

    @JsonProperty(value = "disable_web_page_preview")
    private Boolean disableWebPagePreview;

    @JsonProperty(value = "disable_notification")
    private Boolean disableNotification;

    @JsonProperty(value = "reply_to_message_id")
    private Integer replyToMessageId;

    @JsonProperty(value = "reply_markup")
    private AbstractEntity replyMarkup;

    public SendMessageRequest() {
    }

    public SendMessageRequest(SendMessageRequest.Builder builder) {
        this.chatId = builder.chatId;
        this.text = builder.text;
        this.parseMode = builder.parseMode;
        this.disableWebPagePreview = builder.disableWebPagePreview;
        this.disableNotification = builder.disableNotification;
        this.replyToMessageId = builder.replyToMessageId;
        this.replyMarkup = builder.replyMarkup;
    }

    @Override
    public MessageResponse doRequest(String token) throws RequestException {
        HttpClient request = new HttpClient.Builder()
                .httpMethod(HttpMethod.POST)
                .apiMethod(ApiMethod.SEND_MESSAGE)
                .request(this)
                .responseClass(MessageResponse.class)
                .token(token)
                .build();

        MessageResponse response;
        try {
            response = (MessageResponse) request.doRequest();
        } catch (HttpException e) {
            logger.error("SendMessageRequest: " + e);
            throw new RequestException("SendMessageRequest error", e);

        }
        return response;
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

    public void setReplyMarkup(AbstractEntity replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SendMessageRequest)) return false;
        SendMessageRequest request = (SendMessageRequest) o;
        return Objects.equals(chatId, request.chatId) &&
                Objects.equals(text, request.text) &&
                parseMode == request.parseMode &&
                Objects.equals(disableWebPagePreview, request.disableWebPagePreview) &&
                Objects.equals(disableNotification, request.disableNotification) &&
                Objects.equals(replyToMessageId, request.replyToMessageId) &&
                Objects.equals(replyMarkup, request.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, text, parseMode, disableWebPagePreview, disableNotification,
                replyToMessageId, replyMarkup);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SendMessageRequest{");
        sb.append("chatId='").append(chatId).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", parseMode=").append(parseMode);
        sb.append(", disableWebPagePreview=").append(disableWebPagePreview);
        sb.append(", disableNotification=").append(disableNotification);
        sb.append(", replyToMessageId=").append(replyToMessageId);
        sb.append(", replyMarkup=").append(replyMarkup);
        sb.append('}');
        return sb.toString();
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
        public SendMessageRequest.Builder chatId(Integer chatId) {
            this.chatId = chatId.toString();
            return this;
        }

        /**
         * @param    username   Unique username of the target channel (in the format @channelusername)
         * @return   a reference to this object.
         */
        public SendMessageRequest.Builder chatId(String username) {
            this.chatId = username;
            return this;
        }

        /**
         * @param    text   Text of the message to be sent
         * @return   a reference to this object.
         */
        public SendMessageRequest.Builder text(String text) {
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
        public SendMessageRequest.Builder parseMode(FormatOption parseMode) {
            this.parseMode = parseMode;
            return this;
        }

        /**
         * Disables link previews for links in this message
         *
         * @param    disableWebPagePreview   disable_web_page_preview
         * @return   a reference to this object.
         */
        public SendMessageRequest.Builder disableWebPagePreview(Boolean disableWebPagePreview) {
            this.disableWebPagePreview = disableWebPagePreview;
            return this;
        }

        /**
         * Sends the message silently. Users will receive a notification with no sound.
         *
         * @param    disableNotification   disable_notification
         * @return   a reference to this object.
         */
        public SendMessageRequest.Builder disableNotification(Boolean disableNotification) {
            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * If the message is a reply, ID of the original message
         *
         * @param    replyToMessageId   ID of the original message
         * @return   a reference to this object.
         */
        public SendMessageRequest.Builder replyToMessageId(Integer replyToMessageId) {
            this.replyToMessageId = replyToMessageId;
            return this;
        }

        /**
         * Additional interface options. A JSON-serialized object for an inline keyboard.
         *
         * @param    replyMarkup   InlineKeyboardMarkup object
         * @return   a reference to this object.
         */
        public SendMessageRequest.Builder replyMarkup(InlineKeyboardMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * Additional interface options. A JSON-serialized object for a custom reply keyboard.
         *
         * @param    replyMarkup   ReplyKeyboardMarkup object
         * @return   a reference to this object.
         */
        public SendMessageRequest.Builder replyMarkup(ReplyKeyboardMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * Additional interface options. A JSON-serialized object for an instructions to remove reply keyboard.
         *
         * @param    replyMarkup   ReplyKeyboardRemove object
         * @return   a reference to this object.
         */
        public SendMessageRequest.Builder replyMarkup(ReplyKeyboardRemove replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * Additional interface options. A JSON-serialized object to force a reply from the user.
         *
         * @param    replyMarkup   ForceReply object
         * @return   a reference to this object.
         */
        public SendMessageRequest.Builder replyMarkup(ForceReply replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * Build and return SendMessage object.
         *
         * @return   SendMessage object.
         */
        public SendMessageRequest build() {
            return new SendMessageRequest(this);
        }

    }


}
