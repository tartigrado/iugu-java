package com.iugu.services.generic;

import com.iugu.IuguConfiguration;
import com.iugu.components.ClientWrapper;
import com.iugu.exceptions.IuguException;
import lombok.Getter;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Getter
public abstract class GenericService {

    protected final IuguConfiguration iugu;

    public GenericService(final IuguConfiguration iugu) {
        this.iugu = iugu;
    }

    protected <T> T get(URI uri, Class<T> clz) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response res = client.target(uri).request().get();
            return readResponse(res, clz, "Get error");
        }
    }

    protected <T> T get(URI uri, GenericType<T> clz) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response res = client.target(uri).request().get();
            return readResponse(res, clz, "Get error");
        }
    }

    protected <T> T postNotAuth(URI uri, Object body, Class<T> clz) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClientNotAuth()) {
            Response res = client.target(uri).request().post(Entity.entity(body, MediaType.APPLICATION_JSON));
            return readResponse(res, clz, "Post error");
        }
    }

    protected <T> T postNotAuth(URI uri, Object body, GenericType<T> clz) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClientNotAuth()) {
            Response res = client.target(uri).request().post(Entity.entity(body, MediaType.APPLICATION_JSON));
            return readResponse(res, clz, "Post error");
        }
    }

    protected <T> T post(URI uri, Object body, Class<T> clz) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response res = client.target(uri).request().post(Entity.entity(body, MediaType.APPLICATION_JSON));
            return readResponse(res, clz, "Post error");
        }
    }

    protected <T> T post(URI uri, Object body, GenericType<T> clz) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response res = client.target(uri).request().post(Entity.entity(body, MediaType.APPLICATION_JSON));
            return readResponse(res, clz, "Post error");
        }
    }

    protected <T> T put(URI uri, Object body, Class<T> clz) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response res = client.target(uri).request().put(Entity.entity(body, MediaType.APPLICATION_JSON));
            return readResponse(res, clz, "Put error");
        }
    }

    protected <T> T put(URI uri, Object body, GenericType<T> clz) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response res = client.target(uri).request().put(Entity.entity(body, MediaType.APPLICATION_JSON));
            return readResponse(res, clz, "Put error");
        }
    }

    protected <T> T delete(URI uri, Class<T> clz) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response res = client.target(uri).request().get();
            return readResponse(res, clz, "Delete error");
        }
    }

    protected <T> T delete(URI uri, GenericType<T> clz) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response res = client.target(uri).request().delete();
            return readResponse(res, clz, "Delete error");
        }
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
        try (Response res = response) {
            int status = res.getStatus();
            if (status >= 200 && status <= 300) {
                return res.readEntity(clazz);
            }
            throw new IuguException(exceptionMessage, status, res.readEntity(String.class));
        }
    }

}
