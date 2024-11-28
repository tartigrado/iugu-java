package com.iugu.services.email;

import com.iugu.Mocks;
import com.iugu.exceptions.IuguException;
import com.iugu.model.email.EmailCreateUpdate;
import com.iugu.model.email.EmailSend;
import com.iugu.model.email.response.DefaultEmailResponse;
import com.iugu.model.email.response.EmailPreviewResponse;
import com.iugu.model.email.response.EmailResponse;
import com.iugu.model.email.response.EmailSendResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class EmailServiceImplTest {

    EmailService service = new EmailServiceImpl(Mocks.mockConfiguration());

    @Test
    @DisplayName("EmailService: Should list supported emails")
    void testGetSupportedEmails() {
        List<String> supportedEmails = service.getSupportedEmails();
        Assertions.assertEquals(12, supportedEmails.size());
    }

    @Test
    @DisplayName("EmailService: Should get default email template")
    void testGetDefaultEmailTemplate() {
        DefaultEmailResponse defaultEmailTemplate = service.getDefaultEmailTemplate("invoice_due");
        Assertions.assertNotNull(defaultEmailTemplate);
        Assertions.assertNotNull(defaultEmailTemplate.getTemplate());
        Assertions.assertNotNull(defaultEmailTemplate.getSubject());
    }

    @Test
    @DisplayName("EmailService: Should preview email")
    void testPreviewEmail() {
        EmailPreviewResponse emailPreview = service.previewEmail("invoice_due");
        Assertions.assertNotNull(emailPreview);
        Assertions.assertNotNull(emailPreview.getPreview());
    }


    @Test
    @DisplayName("EmailService: Should throws exception for invalid identifier")
    void testPreviewEmailForInvalidIdentifier() {
        IuguException ex = Assertions.assertThrows(IuguException.class, () -> service.previewEmail("iugu_java_sdk_unit_test"));
        Assertions.assertEquals("O identificador do email é inválido", ex.getMessage());
    }

    @Test
    @DisplayName("EmailService: Should send email")
    void testSendEmail() {
        EmailSendResponse response = service.sendEmail("invoice_due", EmailSend.builder().to("iugu-sdk-test@test.com").build());
        Assertions.assertNotNull(response);
        Assertions.assertEquals(Boolean.TRUE, response.getSuccess());
    }

    @Test
    @DisplayName("EmailService: Should delete an email it if exists in list and create")
    void testCreateEmail() {
        DefaultEmailResponse defaultEmailResponse = service.getDefaultEmailTemplate("invoice_due");
        List<EmailResponse> emails = service.listEmails();
        if (emails.stream().anyMatch(email -> email.getIdentifier().equals("invoice_due"))) {
            service.deleteEmail(emails.stream().filter(email -> email.getIdentifier().equals("invoice_due")).findFirst().orElseThrow().getId());
        }
        EmailResponse email = Assertions.assertDoesNotThrow(() -> service.createEmail(EmailCreateUpdate
                .builder()
                .subject(defaultEmailResponse.getSubject())
                .template(defaultEmailResponse.getTemplate())
                .identifier("invoice_due")
                .build()));

        Assertions.assertNotNull(email);
        Assertions.assertNotNull(email.getId());
    }

    @Test
    @DisplayName("EmailService: Should update email")
    void testUpdateEmail() {
        DefaultEmailResponse defaultEmailResponse = service.getDefaultEmailTemplate("invoice_due");
        List<EmailResponse> emails = service.listEmails();
        EmailResponse email;
        if (emails.stream().noneMatch(it -> it.getIdentifier().equals("invoice_due"))) {
            email = service.createEmail(EmailCreateUpdate
                    .builder()
                    .subject(defaultEmailResponse.getSubject())
                    .template(defaultEmailResponse.getTemplate())
                    .identifier("invoice_due")
                    .build());
        } else {
            email = emails.stream().filter(it -> it.getIdentifier().equals("invoice_due")).findFirst().orElseThrow();
        }

        EmailResponse updatedEmail = service.updateEmail(email.getId(), EmailCreateUpdate
                .builder()
                .subject("Updated subject")
                .template("Updated template")
                .identifier("invoice_due")
                .build());

        Assertions.assertNotNull(updatedEmail);
        Assertions.assertEquals("Updated subject", updatedEmail.getSubject());
        Assertions.assertEquals("Updated template", updatedEmail.getTemplate());
    }

    @Test
    @DisplayName("EmailService: Should delete email")
    void testDeleteEmail() {
        DefaultEmailResponse defaultEmailResponse = service.getDefaultEmailTemplate("invoice_due");
        List<EmailResponse> emails = service.listEmails();
        EmailResponse email;
        if (emails.stream().noneMatch(it -> it.getIdentifier().equals("invoice_due"))) {
            email = service.createEmail(EmailCreateUpdate
                    .builder()
                    .subject(defaultEmailResponse.getSubject())
                    .template(defaultEmailResponse.getTemplate())
                    .identifier("invoice_due")
                    .build());
        } else {
            email = emails.stream().filter(it -> it.getIdentifier().equals("invoice_due")).findFirst().orElseThrow();
        }

        EmailResponse deletedEmail = service.deleteEmail(email.getId());
        Assertions.assertNotNull(deletedEmail);
        Assertions.assertEquals(email.getId(), deletedEmail.getId());
    }

    @Test
    @DisplayName("EmailService: Should detail email")
    void testDetailEmail() {
        DefaultEmailResponse defaultEmailResponse = service.getDefaultEmailTemplate("invoice_due");
        List<EmailResponse> emails = service.listEmails();
        EmailResponse email;
        if (emails.stream().noneMatch(it -> it.getIdentifier().equals("invoice_due"))) {
            email = service.createEmail(EmailCreateUpdate
                    .builder()
                    .subject(defaultEmailResponse.getSubject())
                    .template(defaultEmailResponse.getTemplate())
                    .identifier("invoice_due")
                    .build());
        } else {
            email = emails.stream().filter(it -> it.getIdentifier().equals("invoice_due")).findFirst().orElseThrow();
        }

        EmailResponse detailEmail = service.detailEmail(email.getId());
        Assertions.assertNotNull(detailEmail);
        Assertions.assertEquals(email.getId(), detailEmail.getId());
    }

    @Test
    @DisplayName("EmailService: Should list emails")
    void testListEmails() {
        List<EmailResponse> emails = service.listEmails();
        Assertions.assertNotNull(emails);
    }
}