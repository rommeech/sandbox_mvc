package org.rp.telegram.botapi.http;

public class HttpException extends Exception {
    private static final long serialVersionUID = -5690460992261703743L;

    public HttpException() {
        super();
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
