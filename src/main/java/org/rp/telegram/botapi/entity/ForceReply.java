package org.rp.telegram.botapi.entity;

// TODO: add unit test for converter to json
// TODO: add builder

import java.util.Objects;

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the user
 * (act as if the user has selected the bot‘s message and tapped ’Reply'). This can be extremely useful
 * if you want to create user-friendly step-by-step interfaces without having to sacrifice privacy mode.
 * https://core.telegram.org/bots/api#forcereply
 *
 * @author        Roman Parshin, roman.dev@gmail.com
 * @version       1.0
 * @since         1.0
 * @apiVersion    4.1
 */

public class ForceReply extends AbstractEntity {
    private static final long serialVersionUID = 6299847134914194529L;
    private static final Boolean forceReply = true;
    private Boolean selective;

    public ForceReply() {
    }

    public ForceReply(Boolean selective) {
        this.selective = selective;
    }

    /**
     * Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'
     *
     * @return   force_reply
     */
    public static Boolean getForceReply() {
        return forceReply;
    }

    /**
     * @return   selective
     */
    public Boolean getSelective() {
        return selective;
    }

    /**
     * Optional. Use this parameter if you want to force reply from specific users only. Targets:
     * 1) users that are @mentioned in the text of the Message object;
     * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     *
     * @param   selective   selective
     */
    public void setSelective(Boolean selective) {
        this.selective = selective;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForceReply)) return false;
        ForceReply that = (ForceReply) o;
        return Objects.equals(selective, that.selective);
    }

    @Override
    public int hashCode() {

        return Objects.hash(selective);
    }

    @Override
    public String toString() {
        return "ForceReply{" +
                "forceReply=" + forceReply +
                "selective=" + selective +
                '}';
    }
}
