package com.iugu.services.email;

import com.iugu.IuguConfiguration;
import com.iugu.components.HttpClientManager;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.email.EmailCreateUpdate;
import com.iugu.model.email.EmailSend;
import com.iugu.model.email.response.DefaultEmailResponse;
import com.iugu.model.email.response.EmailPreviewResponse;
import com.iugu.model.email.response.EmailResponse;
import com.iugu.model.email.response.EmailSendResponse;
import jakarta.ws.rs.WebApplicationException;

import java.util.List;

public final class EmailServiceImpl implements EmailService {

    private final EmailService proxy;

    public EmailServiceImpl(
            IuguConfiguration iuguConfiguration
    ) {
        this.proxy = HttpClientManager.proxy(EmailServiceProxy.class, iuguConfiguration.authenticator());
    }

    @Override
    public List<String> getSupportedEmails() {
        try {
            return proxy.getSupportedEmails();
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public DefaultEmailResponse getDefaultEmailTemplate(String identifier) {
        try {
            return proxy.getDefaultEmailTemplate(identifier);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public EmailPreviewResponse previewEmail(String identifier) {
        try {
            return proxy.previewEmail(identifier);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public EmailSendResponse sendEmail(String identifier, EmailSend emailSend) {
        try {
            return proxy.sendEmail(identifier, emailSend);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public EmailResponse createEmail(EmailCreateUpdate create) {
        try {
            return proxy.createEmail(create);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public EmailResponse updateEmail(String id, EmailCreateUpdate create) {
        try {
            return proxy.updateEmail(id, create);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public EmailResponse deleteEmail(String id) {
        try {
            return proxy.deleteEmail(id);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public EmailResponse detailEmail(String id) {
        try {
            return proxy.detailEmail(id);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public List<EmailResponse> listEmails() {
        try {
            return proxy.listEmails();
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

}
