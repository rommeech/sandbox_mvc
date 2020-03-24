package org.rp.telegram.botapi.type.old;

// TODO: add unit test for converter to json
// TODO: add builder

import java.util.Objects;

/**
 * This object represents one button of the reply keyboard. For simple text buttons String can be used
 * instead of this object to specify text of the button. Optional fields are mutually exclusive.
 * https://core.telegram.org/bots/api#keyboardbutton
 *
 * @author        Roman Parshin, roman.dev@gmail.com
 * @version       1.0
 * @since         1.0
 * @apiVersion    4.1
 */
public class KeyboardButton extends AbstractEntity {
    private static final long serialVersionUID = 3100829535429655762L;

    // TODO: @Required
    private String text;
    private Boolean requestContact;
    private Boolean requestLocation;

    public KeyboardButton() {
    }

    /**
     * @return   Text of the button
     */
    public String getText() {
        return text;
    }

    /**
     * If none of the optional fields are used, it will be sent as a message when the button is pressed
     *
     * @param   text   Text of the button
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return   request_contact
     */
    public Boolean getRequestContact() {
        return requestContact;
    }

    /**
     * Optional. If True, the user's phone number will be sent as a contact when the button is pressed.
     * Available in private chats only
     *
     * @param    requestContact   request_contact
     */
    public void setRequestContact(Boolean requestContact) {
        this.requestContact = requestContact;
    }

    /**
     * @return   request_location
     */
    public Boolean getRequestLocation() {
        return requestLocation;
    }

    /**
     * Optional. If True, the user's current location will be sent when the button is pressed.
     * Available in private chats only
     *
     * @param   requestLocation   request_location
     */
    public void setRequestLocation(Boolean requestLocation) {
        this.requestLocation = requestLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyboardButton)) return false;
        KeyboardButton that = (KeyboardButton) o;
        return Objects.equals(text, that.text) &&
                Objects.equals(requestContact, that.requestContact) &&
                Objects.equals(requestLocation, that.requestLocation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text, requestContact, requestLocation);
    }

    @Override
    public String toString() {
        return "KeyboardButton{" +
                "text='" + text + '\'' +
                ", requestContact=" + requestContact +
                ", requestLocation=" + requestLocation +
                '}';
    }
}
