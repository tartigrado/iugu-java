package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.responses.WebHookLogResponse;
import com.iugu.responses.WebHookResponse;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class WebHookLogService {

    private IuguConfiguration iugu;
    private final String FIND_ALL_URL = IuguConfiguration.url("/web_hook_logs/%s");

    public WebHookLogService(IuguConfiguration iugu) {
        this.iugu = iugu;
    }

    public List<WebHookLogResponse> findAll(String invoiceId) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(FIND_ALL_URL, invoiceId)).request().get();

        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(new GenericType<List<WebHookLogResponse>>() {
            });

        // Error Happened
        if (response.hasEntity())
            ResponseText = response.readEntity(String.class);

        response.close();

        throw new IuguException("Error finding web_hook logs ", ResponseStatus, ResponseText);
    }

}
