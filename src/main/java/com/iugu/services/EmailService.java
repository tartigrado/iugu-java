package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.responses.EmailResponse;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class EmailService {

    private IuguConfiguration iugu;
    private final String FIND_SUPPORTED_URL = IuguConfiguration.url("/emails/supported_emails");
    private final String FIND_EMAILS_URL = IuguConfiguration.url("/emails");

    public EmailService(IuguConfiguration iuguConfiguration) {
        this.iugu = iuguConfiguration;
    }

    public List<String> findSupportedEmails() throws IuguException {
        Response response = this.iugu.getNewClient().target(FIND_SUPPORTED_URL).request().get();
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(new GenericType<List<String>>() {
            });

        // Error Happened
        if (response.hasEntity()) {
            ResponseText = response.readEntity(String.class);
        }

        response.close();

        throw new IuguException("Error finding supported emails!", ResponseStatus, ResponseText);
    }

    public List<EmailResponse> findEmails() throws IuguException {
        Response response = this.iugu.getNewClient().target(FIND_EMAILS_URL).request().get();
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(new GenericType<List<EmailResponse>>() {
            });

        // Error Happened
        if (response.hasEntity()) {
            ResponseText = response.readEntity(String.class);
        }

        response.close();

        throw new IuguException("Error finding emails!", ResponseStatus, ResponseText);
    }

}
