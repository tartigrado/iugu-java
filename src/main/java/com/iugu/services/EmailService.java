package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Email;
import com.iugu.responses.EmailDefaultLayoutResponse;
import com.iugu.responses.EmailResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class EmailService {

    private IuguConfiguration iugu;
    private final String FIND_SUPPORTED_URL = IuguConfiguration.url("/emails/supported_emails");
    private final String FIND_DEFAULT_LAYOUT_URL = IuguConfiguration.url("/emails/default_layout/%s");
    private final String FIND_EMAILS_URL = IuguConfiguration.url("/emails");
    private final String FIND_URL = IuguConfiguration.url("/emails/%s");
    private final String UPDATE_URL = IuguConfiguration.url("/emails/%s");
    private final String CREATE_URL = IuguConfiguration.url("/emails");

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

    public EmailDefaultLayoutResponse findDefaultLayout(String identifier) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(FIND_DEFAULT_LAYOUT_URL, identifier)).request().get();
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(EmailDefaultLayoutResponse.class);

        // Error Happened
        if (response.hasEntity()) {
            ResponseText = response.readEntity(String.class);
        }

        response.close();

        throw new IuguException("Error finding default layout!", ResponseStatus, ResponseText);
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

    public EmailResponse findEmail(String id) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(FIND_URL, id)).request().get();
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(EmailResponse.class);

        // Error Happened
        if (response.hasEntity()) {
            ResponseText = response.readEntity(String.class);
        }

        response.close();

        throw new IuguException("Error finding email!", ResponseStatus, ResponseText);
    }

    public EmailResponse update(Email email) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(UPDATE_URL, email.getId())).request().put(Entity.entity(email, MediaType.APPLICATION_JSON));
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(EmailResponse.class);

        // Error Happened
        if (response.hasEntity()) {
            ResponseText = response.readEntity(String.class);
        }

        response.close();

        throw new IuguException("Error updating email!", ResponseStatus, ResponseText);
    }

    public EmailResponse create(Email email) throws IuguException {
        Response response = this.iugu.getNewClient().target(CREATE_URL).request().post(Entity.entity(email, MediaType.APPLICATION_JSON));
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(EmailResponse.class);

        // Error Happened
        if (response.hasEntity()) {
            ResponseText = response.readEntity(String.class);
        }

        response.close();

        throw new IuguException("Error creating email!", ResponseStatus, ResponseText);
    }

}
