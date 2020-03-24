package org.rp.telegram.botapi.exception;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 23.03.20
 * Time: 12:10
 */

public class JsonException extends BotApiException {

    private static final long serialVersionUID = 3261195890738596332L;

    public JsonException() {
    }

    public JsonException(String message) {
        super(message);
    }

    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonException(Throwable cause) {
        super(cause);
    }
}
