package com.iugu.services.email;

import com.iugu.model.email.EmailCreateUpdate;
import com.iugu.model.email.EmailSend;
import com.iugu.model.email.response.DefaultEmailResponse;
import com.iugu.model.email.response.EmailPreviewResponse;
import com.iugu.model.email.response.EmailResponse;
import com.iugu.model.email.response.EmailSendResponse;

import java.util.List;

public interface EmailService {

    List<String> getSupportedEmails();

    DefaultEmailResponse getDefaultEmailTemplate(String identifier);

    EmailResponse createEmail(EmailCreateUpdate create);

    EmailResponse updateEmail(String id, EmailCreateUpdate create);

    EmailResponse deleteEmail(String id);

    EmailPreviewResponse previewEmail(String identifier);

    EmailSendResponse sendEmail(String identifier, EmailSend emailSend);

    EmailResponse detailEmail(String id);

    List<EmailResponse> listEmails();
}
