package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public abstract class GenericService {

    protected final IuguConfiguration iugu;

    public GenericService(IuguConfiguration iugu) {
        this.iugu = iugu;
    }

    public static <T> T readResponse(Response response, GenericType<T> type, String exceptionMessage) throws IuguException {
        int status = response.getStatus();

        if (status == 200) {
            return response.readEntity(type);
        } else {
            String text = response.readEntity(String.class);
            response.close();
            throw new IuguException(exceptionMessage, status, text);
        }
    }

    public static <T> T readResponse(Response response, Class<T> clazz, String exceptionMessage) throws IuguException {
        int status = response.getStatus();

        if (status == 200) {
            return response.readEntity(clazz);
        } else {
            String text = response.readEntity(String.class);
            response.close();
            throw new IuguException(exceptionMessage, status, text);
        }
    }

    public IuguConfiguration getIugu() {
        return iugu;
    }

    public WebTarget getTarget(String url) {
        return getIugu().getNewClient().target(url);
    }
}
