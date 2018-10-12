package org.rp.telegram.botapi.entity;

import java.util.List;
import java.util.Objects;

// TODO: add unit test for converter to json
// TODO: add builder

/**
 * This object represents a custom keyboard with reply options (see Introduction to bots for details and examples).
 * https://core.telegram.org/bots/api#replykeyboardmarkup
 *
 * @author        Roman Parshin, roman.dev@gmail.com
 * @version       1.0
 * @since         1.0
 * @apiVersion    4.1
 */
public class ReplyKeyboardMarkup extends AbstractEntity {

    private static final long serialVersionUID = -8395427484632972213L;

    // TODO: add smart setter methods and constructor
    // TODO: required
    private List<List<KeyboardButton>> keyboard;
    private Boolean resizeKeyboard;
    private Boolean oneTimeKeyboard;
    private Boolean selective;

    public ReplyKeyboardMarkup() {
    }

    /**
     * @return   Array of button rows
     */
    public List<List<KeyboardButton>> getKeyboard() {
        return keyboard;
    }

    /**
     * Array of button rows, each represented by an Array of KeyboardButton objects
     * @param   keyboard   Array of button rows
     */
    public void setKeyboard(List<List<KeyboardButton>> keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * @return   resize_keyboard
     */
    public Boolean getResizeKeyboard() {
        return resizeKeyboard;
    }

    /**
     * Optional. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller
     * if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always
     * of the same height as the app's standard keyboard.
     *
     * @param   resizeKeyboard   resize_keyboard
     */
    public void setResizeKeyboard(Boolean resizeKeyboard) {
        this.resizeKeyboard = resizeKeyboard;
    }

    /**
     * @return   one_time_keyboard
     */
    public Boolean getOneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    /**
     * Optional. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available,
     * but clients will automatically display the usual letter-keyboard in the chat – the user can press a special
     * button in the input field to see the custom keyboard again. Defaults to false.
     *
     * @param   oneTimeKeyboard   one_time_keyboard
     */
    public void setOneTimeKeyboard(Boolean oneTimeKeyboard) {
        this.oneTimeKeyboard = oneTimeKeyboard;
    }

    /**
     * @return   selective
     */
    public Boolean getSelective() {
        return selective;
    }

    /**
     * Optional. Use this parameter if you want to show the keyboard to specific users only. Targets:
     * 1) users that are @mentioned in the text of the Message object;
     * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     *
     * Example: A user requests to change the bot‘s language, bot replies to the request with a keyboard to select
     * the new language. Other users in the group don’t see the keyboard.
     *
     * @param   selective   selective
     */
    public void setSelective(Boolean selective) {
        this.selective = selective;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReplyKeyboardMarkup)) return false;
        ReplyKeyboardMarkup that = (ReplyKeyboardMarkup) o;
        return Objects.equals(keyboard, that.keyboard) &&
                Objects.equals(resizeKeyboard, that.resizeKeyboard) &&
                Objects.equals(oneTimeKeyboard, that.oneTimeKeyboard) &&
                Objects.equals(selective, that.selective);
    }

    @Override
    public int hashCode() {

        return Objects.hash(keyboard, resizeKeyboard, oneTimeKeyboard, selective);
    }

    @Override
    public String toString() {
        return "ReplyKeyboardMarkup{" +
                "keyboard=" + keyboard +
                ", resizeKeyboard=" + resizeKeyboard +
                ", oneTimeKeyboard=" + oneTimeKeyboard +
                ", selective=" + selective +
                '}';
    }
}
