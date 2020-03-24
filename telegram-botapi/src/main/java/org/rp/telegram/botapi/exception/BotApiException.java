package org.rp.telegram.botapi.exception;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 23.03.20
 * Time: 12:08
 */
public class BotApiException extends Exception {

    private static final long serialVersionUID = -8208239118919878771L;

    public BotApiException() {
    }

    public BotApiException(String message) {
        super(message);
    }

    public BotApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BotApiException(Throwable cause) {
        super(cause);
    }
}
