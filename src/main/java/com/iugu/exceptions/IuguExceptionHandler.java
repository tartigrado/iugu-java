package com.iugu.exceptions;

import com.iugu.components.Jackson;
import com.iugu.model.generic.IuguError;
import jakarta.ws.rs.ProcessingException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import lombok.extern.log4j.Log4j2;

import java.util.Map;


@Log4j2
public final class IuguExceptionHandler {
    final ExceptionTranslator translator = new ExceptionTranslator();

    private IuguExceptionHandler() {

    }

    public static IuguExceptionHandler getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final IuguExceptionHandler INSTANCE = new IuguExceptionHandler();
    }

    public static IuguException getException(WebApplicationException ex) {
        return getInstance().newException(ex);
    }

    IuguError getIuguError(WebApplicationException ex) {
        Map<String, Object> errors;
        try (Response error = ex.getResponse()) {
            try {
                errors = error.readEntity(new GenericType<>() {
                });
            } catch (ProcessingException e) {
                errors = Map.of("errors", error.readEntity(String.class));
            }
        }
        log.error("Iugu error: {}", errors);
        Map<String, Object> translatedErrors = translator.translate(errors);
        return Jackson.getInstance().convertValue(translatedErrors, IuguError.class);
    }

    IuguException newException(WebApplicationException ex) {
        return new IuguException(ex, getIuguError(ex));
    }
}
