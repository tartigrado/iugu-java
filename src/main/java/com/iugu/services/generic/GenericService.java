package com.iugu.services.generic;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import lombok.Getter;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

@Getter
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
        try (Response res = response) {
            int status = res.getStatus();
            if (status >= 200 && status <= 300) {
                return res.readEntity(clazz);
            }
            throw new IuguException(exceptionMessage, status, res.readEntity(String.class));
        }
    }

}
