package com.iugu.services;

import com.iugu.IuguConfiguration;
import jakarta.ws.rs.client.Client;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Email;
import com.iugu.model.SendEmailTest;
import com.iugu.model.email.response.DefaultEmailResponse;
import com.iugu.model.email.response.EmailResponse;
import com.iugu.responses.SendEmailTestResponse;
import com.iugu.services.generic.GenericService;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

public class EmailService extends GenericService {
    private final String FIND_SUPPORTED_URL = IuguConfiguration.url("/emails/supported_emails");
    private final String FIND_DEFAULT_LAYOUT_URL = IuguConfiguration.url("/emails/default_layout/%s");
    private final String FIND_EMAILS_URL = IuguConfiguration.url("/emails");
    private final String FIND_URL = IuguConfiguration.url("/emails/%s");
    private final String UPDATE_URL = IuguConfiguration.url("/emails/%s");
    private final String CREATE_URL = IuguConfiguration.url("/emails");
    private final String SEND_TEST_URL = IuguConfiguration.url("/emails/test/%s");

    public EmailService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration);
    }

    public List<String> findSupportedEmails() throws IuguException {
        try (Client client = getIugu().getNewClient()) {

            Response response = client.target(FIND_SUPPORTED_URL).request().get();
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
    }

    public DefaultEmailResponse findDefaultLayout(String identifier) throws IuguException {
        try (Client client = getIugu().getNewClient()) {

            Response response = client.target(String.format(FIND_DEFAULT_LAYOUT_URL, identifier)).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(DefaultEmailResponse.class);

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error finding default layout!", ResponseStatus, ResponseText);
        }
    }

    public List<EmailResponse> findEmails() throws IuguException {
        try (Client client = getIugu().getNewClient()) {

            Response response = client.target(FIND_EMAILS_URL).request().get();
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

    public EmailResponse findEmail(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {

            Response response = client.target(String.format(FIND_URL, id)).request().get();
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
    }

    public EmailResponse update(Email email) throws IuguException {
        try (Client client = getIugu().getNewClient()) {

            Response response = client.target(String.format(UPDATE_URL, email.getId())).request().put(Entity.entity(email, MediaType.APPLICATION_JSON));
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
    }

    public EmailResponse create(Email email) throws IuguException {
        try (Client client = getIugu().getNewClient()) {

            Response response = client.target(CREATE_URL).request().post(Entity.entity(email, MediaType.APPLICATION_JSON));
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

    public SendEmailTestResponse sendTest(String identifier, SendEmailTest email) throws IuguException {
        try (Client client = getIugu().getNewClient()) {

            Response response = client.target(String.format(SEND_TEST_URL, identifier)).request().post(Entity.entity(email, MediaType.APPLICATION_JSON));
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(SendEmailTestResponse.class);

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error creating email!", ResponseStatus, ResponseText);
        }
    }

}
