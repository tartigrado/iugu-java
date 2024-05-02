package com.iugu.exceptions;

import lombok.Getter;

@Getter
public class IuguException extends Exception {

    private final String exception;
    private final int statusCode;
    private final String message;

    public IuguException(String exception, int statusCode, String message) {
        super(message);
        this.exception = exception;
        this.statusCode = statusCode;
        this.message = message;
    }
}
