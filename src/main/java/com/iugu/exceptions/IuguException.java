package com.iugu.exceptions;

public class IuguException extends Exception {
    private static final long serialVersionUID = 8701207870125630038L;

    private final String exception;
    private final int statusCode;
    private final String message;

    public IuguException(String exception, int statusCode, String message) {
        super(message);
        this.exception = exception;
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
