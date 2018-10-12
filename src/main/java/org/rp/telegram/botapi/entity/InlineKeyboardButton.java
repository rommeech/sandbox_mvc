package org.rp.telegram.botapi.entity;

import java.util.Objects;

//TODO: add unit test for converter to json

/**
 * This object represents one button of an inline keyboard. You must use exactly one of the optional fields.
 * https://core.telegram.org/bots/api#inlinekeyboardbutton
 *
 * @author        Roman Parshin, roman.dev@gmail.com
 * @version       1.0
 * @since         1.0
 * @apiVersion    4.1
 */
public class InlineKeyboardButton extends AbstractEntity {

    private static final long serialVersionUID = 6257129681414814309L;

    // TODO: @Required
    private String text;

    // TODO @OptionalOnlyOne(name = ...)
    private String url; // TODO: URL Object???
    private String callbackData;
    private String switchInlineQuery;
    private String switchInlineQueryCurrentChat;
    private CallbackGame callbackGame;
    private Boolean pay;

    public InlineKeyboardButton() {
    }

    /**
     * @return   Label text on the button
     */
    public String getText() {
        return text;
    }

    /**
     * @param   text   Label text on the button
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return   HTTP or tg:// url to be opened when button is pressed
     */
    public String getUrl() {
        return url;
    }

    /**
     * Optional
     * @param   url   HTTP or tg:// url to be opened when button is pressed
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return   Data to be sent in a <a href="https://core.telegram.org/bots/api#callbackquery"callback query</a>
     *           to the bot when button is pressed, 1-64 bytes
     */
    public String getCallbackData() {
        return callbackData;
    }

    /**
     * Optional
     * @param   callbackData   Data to be sent in a <a href="https://core.telegram.org/bots/api#callbackquery"callback query</a>
     *                         to the bot when button is pressed, 1-64 bytes
     */
    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }

    /**
     * @return   switch_inline_query
     */
    public String getSwitchInlineQuery() {
        return switchInlineQuery;
    }

    /**
     * Optional. If set, pressing the button will prompt the user to select one of their chats, open
     * that chat and insert the bot‘s username and the specified inline query in the input field. Can be empty,
     * in which case just the bot’s username will be inserted.
     *
     * Note: This offers an easy way for users to start using your bot in inline mode when they are currently
     * in a private chat with it. Especially useful when combined with switch_pm… actions – in this case
     * the user will be automatically returned to the chat they switched from, skipping the chat selection screen.
     *
     * @param   switchInlineQuery   switch_inline_query
     */
    public void setSwitchInlineQuery(String switchInlineQuery) {
        this.switchInlineQuery = switchInlineQuery;
    }

    /**
     * @return   switch_inline_query_current_chat
     */
    public String getSwitchInlineQueryCurrentChat() {
        return switchInlineQueryCurrentChat;
    }

    /**
     * Optional. If set, pressing the button will insert the bot‘s username and the specified inline query
     * in the current chat's input field. Can be empty, in which case only the bot’s username will be inserted.
     *
     * This offers a quick way for the user to open your bot in inline mode in the same chat – good for selecting
     * something from multiple options.
     *
     * @param   switchInlineQueryCurrentChat   switch_inline_query_current_chat
     */
    public void setSwitchInlineQueryCurrentChat(String switchInlineQueryCurrentChat) {
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
    }

    /**
     * @return   description of the game
     */
    public CallbackGame getCallbackGame() {
        return callbackGame;
    }

    /**
     * Description of the game that will be launched when the user presses the button.
     *
     * NOTE: This type of button must always be the first button in the first row.
     *
     * @param   callbackGame   description of the game
     */
    public void setCallbackGame(CallbackGame callbackGame) {
        this.callbackGame = callbackGame;
    }

    /**
     * @return   pay
     */
    public Boolean getPay() {
        return pay;
    }

    /**
     * Optional. Specify True, to send a Pay button.
     *
     * NOTE: This type of button must always be the first button in the first row.
     *
     * @param    pay   pay
     */
    public void setPay(Boolean pay) {
        this.pay = pay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InlineKeyboardButton)) return false;
        InlineKeyboardButton that = (InlineKeyboardButton) o;
        return Objects.equals(text, that.text) &&
                Objects.equals(url, that.url) &&
                Objects.equals(callbackData, that.callbackData) &&
                Objects.equals(switchInlineQuery, that.switchInlineQuery) &&
                Objects.equals(switchInlineQueryCurrentChat, that.switchInlineQueryCurrentChat) &&
                Objects.equals(callbackGame, that.callbackGame) &&
                Objects.equals(pay, that.pay);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text, url, callbackData, switchInlineQuery, switchInlineQueryCurrentChat, callbackGame, pay);
    }

    @Override
    public String toString() {
        return "InlineKeyboardButton{" +
                "text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", callbackData='" + callbackData + '\'' +
                ", switchInlineQuery='" + switchInlineQuery + '\'' +
                ", switchInlineQueryCurrentChat='" + switchInlineQueryCurrentChat + '\'' +
                ", callbackGame=" + callbackGame +
                ", pay=" + pay +
                '}';
    }
}
