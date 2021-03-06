package org.rp.telegram.botapi.type.old;

import java.util.List;
import java.util.Objects;

// TODO: add unit test for converter to json
// TODO: add builder

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 * https://core.telegram.org/bots/api#inlinekeyboardmarkup
 *
 * @author        Roman Parshin, roman.dev@gmail.com
 * @version       1.0
 * @since         1.0
 * @apiVersion    4.1
 */
public class InlineKeyboardMarkup extends AbstractEntity {

    private static final long serialVersionUID = 3870153957160849228L;

    // TODO: add smart setter methods and constructor
    // TODO: @Required
    private List<List<InlineKeyboardButton>> inlineKeyboard;

    public InlineKeyboardMarkup() {
        this.inlineKeyboard = inlineKeyboard;
    }

    /**
     * @return   Array of button rows
     */
    public List<List<InlineKeyboardButton>> getInlineKeyboard() {
        return inlineKeyboard;
    }

    /**
     * Each row represented by an Array of InlineKeyboardButton objects
     *
     * @param   inlineKeyboard   Array of button rows
     */
    public void setInlineKeyboard(List<List<InlineKeyboardButton>> inlineKeyboard) {
        this.inlineKeyboard = inlineKeyboard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InlineKeyboardMarkup)) return false;
        InlineKeyboardMarkup that = (InlineKeyboardMarkup) o;
        return Objects.equals(inlineKeyboard, that.inlineKeyboard);
    }

    @Override
    public int hashCode() {

        return Objects.hash(inlineKeyboard);
    }

    @Override
    public String toString() {
        return "InlineKeyboardMarkup{" +
                "inlineKeyboard=" + inlineKeyboard +
                '}';
    }
}
