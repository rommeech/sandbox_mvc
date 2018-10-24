package org.rp.telegram.botapi.request;

public class RequestException extends Exception {
    private static final long serialVersionUID = 3158803460427621986L;

    public RequestException() {
    }

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestException(Throwable cause) {
        super(cause);
    }
}
