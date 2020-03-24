package org.rp.telegram.botapi.type.old;

// TODO: add unit test for converter to json
// TODO: add builder

import java.util.Objects;

/**
 * Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display
 * the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot.
 * An exception is made for one-time keyboards that are hidden immediately after the user presses a button
 * (see ReplyKeyboardMarkup).
 *
 *  @author        Roman Parshin, roman.dev@gmail.com
 *  @version       1.0
 *  @since         1.0
 *  @apiVersion    4.1
 */

public class ReplyKeyboardRemove extends AbstractEntity {

    private static final long serialVersionUID = -3450326662474293285L;
    private static final Boolean removeKeyboard = true;
    private Boolean selective;

    public ReplyKeyboardRemove() {
    }

    public ReplyKeyboardRemove(Boolean selective) {
        this.selective = selective;
    }

    /**
     * Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want
     * to hide the keyboard from sight but keep it accessible, use one_time_keyboard in ReplyKeyboardMarkup)
     *
     * @return   remove_keyboard
     */
    public static Boolean getRemoveKeyboard() {
        return removeKeyboard;
    }

    /**
     * @return   selective
     */
    public Boolean getSelective() {
        return selective;
    }

    /**
     * Optional. Use this parameter if you want to remove the keyboard for specific users only. Targets:
     * 1) users that are @mentioned in the text of the Message object;
     * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     *
     * Example: A user votes in a poll, bot returns confirmation message in reply to the vote and removes
     * the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
     *
     * @param   selective   selective
     */
    public void setSelective(Boolean selective) {
        this.selective = selective;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReplyKeyboardRemove)) return false;
        ReplyKeyboardRemove that = (ReplyKeyboardRemove) o;
        return Objects.equals(selective, that.selective);
    }

    @Override
    public int hashCode() {

        return Objects.hash(selective);
    }

    @Override
    public String toString() {
        return "ReplyKeyboardRemove{" +
                "removeKeyboard=" + removeKeyboard +
                "selective=" + selective +
                '}';
    }
}
