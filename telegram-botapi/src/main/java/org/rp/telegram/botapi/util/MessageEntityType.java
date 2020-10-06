package org.rp.telegram.botapi.util;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Type of the {@link org.rp.telegram.botapi.type.MessageEntity entity}. Can be “mention” (@username),
 * “hashtag” (#hashtag), “cashtag” ($USD), “bot_command” (/start@jobs_bot), “url” (https://telegram.org),
 * “email” (do-not-reply@telegram.org), “phone_number” (+1-212-555-0123), “bold” (bold text),
 * “italic” (italic text), “underline” (underlined text), “strikethrough” (strikethrough text),
 * “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs),
 * “text_mention” (for users without usernames)
 *
 * See also: https://core.telegram.org/bots/api#messageentity

 * Date: 13.05.20
 * Time: 16:56
 *
 * @author     rp
 * @version    4.6
 */
public enum MessageEntityType {

    @JsonProperty("mention")
    MENTION,

    @JsonProperty("hashtag")
    HASHTAG,

    @JsonProperty("cashtag")
    CASHTAG,

    @JsonProperty("bot_command")
    BOT_COMMAND,

    @JsonProperty("url")
    URL,

    @JsonProperty("email")
    EMAIL,

    @JsonProperty("phone_number")
    PHONE_NUMBER,

    @JsonProperty("bold")
    BOLD,

    @JsonProperty("italic")
    ITALIC,

    @JsonProperty("underline")
    UNDERLINE,

    @JsonProperty("strikethrough")
    STRIKETHROUGH,

    @JsonProperty("code")
    CODE,

    @JsonProperty("pre")
    PRE,

    @JsonProperty("text_link")
    TEXT_LINK,

    @JsonProperty("text_mention")
    TEXT_MENTION

}
