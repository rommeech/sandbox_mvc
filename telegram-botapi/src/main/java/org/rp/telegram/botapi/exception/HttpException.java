package org.rp.telegram.botapi.exception;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 23.03.20
 * Time: 12:08
 */
public class HttpException extends BotApiException {

    private static final long serialVersionUID = -6063031672418590142L;

    public HttpException() {
    }

    public HttpException(String message) {
        super(message);
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpException(Throwable cause) {
        super(cause);
    }
}
