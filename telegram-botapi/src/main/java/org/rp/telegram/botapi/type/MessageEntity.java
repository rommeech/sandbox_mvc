package org.rp.telegram.botapi.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rp.telegram.botapi.BotApiResultType;
import org.rp.telegram.botapi.util.MessageEntityType;

import java.util.Objects;

/**
 * This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.
 *
 * See also: https://core.telegram.org/bots/api#messageentity
 *
 * Date: 13.05.20
 * Time: 16:50
 *
 * @author     rp
 * @version    4.6
 */

// TODO: refactoring
// TODO: builder - ?
// TODO: unittests
// TODO: javadoc

public class MessageEntity implements BotApiResultType {
    private static final long serialVersionUID = -8987675355573150418L;

    @JsonProperty(value = "type")
    private MessageEntityType type;

    @JsonProperty(value = "offset")
    private Integer offset;

    @JsonProperty(value = "length")
    private Integer length;

    @JsonProperty(value = "url")
    private String url;

    @JsonProperty(value = "user")
    private User user;

    @JsonProperty(value = "language")
    private String language;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Type of the entity
     *
     * @return    MessageEntityType
     */
    public MessageEntityType getType() {
        return type;
    }

    /**
     * @param    type    MessageEntityType
     */
    public void setType(MessageEntityType type) {
        this.type = type;
    }

    /**
     * Offset in UTF-16 code units to the start of the entity
     *
     * @return    offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * @param    offset    in UTF-16 code units to the start of the entity
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Length of the entity in UTF-16 code units
     *
     * @return    length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @param    length    Length of the entity in UTF-16 code units
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * Optional. For “text_link” only, url that will be opened after user taps on the text
     *
     * @return    url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param    url    that will be opened after user taps on the text
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Optional. For “text_mention” only, the mentioned user
     * @return    mentioned user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param    user    mentioned user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Optional. For “pre” only, the programming language of the entity text
     *
     * @return    programming language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param    language    programming language of the entity text
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return type == that.type &&
                Objects.equals(offset, that.offset) &&
                Objects.equals(length, that.length) &&
                Objects.equals(url, that.url) &&
                Objects.equals(user, that.user) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, offset, length, url, user, language);
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "type=" + type +
                ", offset=" + offset +
                ", length=" + length +
                ", url='" + url + '\'' +
                ", user=" + user +
                ", language='" + language + '\'' +
                '}';
    }
}
