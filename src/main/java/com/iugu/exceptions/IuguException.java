package com.iugu.exceptions;

import com.iugu.model.generic.IuguError;
import jakarta.ws.rs.WebApplicationException;
import lombok.Getter;

@Getter
public class IuguException extends RuntimeException {

    private final String exception;
    private final int statusCode;
    private final String message;
    private final IuguError iuguError;

    public IuguException(WebApplicationException exception, IuguError iuguError) {
        super(iuguError.getMainMessage(), exception);
        this.exception = exception.getMessage();
        this.statusCode = exception.getResponse().getStatus();
        this.message = iuguError.getMainMessage();
        this.iuguError = iuguError;
    }

    public IuguException(String exception, int statusCode, String message) {
        super(message);
        this.exception = exception;
        this.statusCode = statusCode;
        this.message = message;
        this.iuguError = null;
    }
}
