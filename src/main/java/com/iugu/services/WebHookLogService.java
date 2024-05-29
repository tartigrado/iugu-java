package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.components.ClientWrapper;
import com.iugu.exceptions.IuguException;
import com.iugu.responses.WebHookLogResponse;
import com.iugu.services.generic.GenericService;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class WebHookLogService extends GenericService {
    private final String FIND_ALL_URL = IuguConfiguration.url("/web_hook_logs/%s");
    private final String CREATE_URL = IuguConfiguration.url("/web_hook_logs/%s/retry");

    public WebHookLogService(IuguConfiguration iugu) {
        super(iugu);
    }

    public List<WebHookLogResponse> findAll(String invoiceId) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_ALL_URL, invoiceId)).request().get();

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

    public WebHookLogResponse create(String logId) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(String.format(CREATE_URL, logId)).request().get();

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(WebHookLogResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error creating web_hook logs ", ResponseStatus, ResponseText);
        }
    }

}
