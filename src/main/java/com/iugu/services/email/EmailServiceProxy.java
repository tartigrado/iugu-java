package com.iugu.services.email;


import com.iugu.model.email.EmailCreateUpdate;
import com.iugu.model.email.EmailSend;
import com.iugu.model.email.response.DefaultEmailResponse;
import com.iugu.model.email.response.EmailPreviewResponse;
import com.iugu.model.email.response.EmailResponse;
import com.iugu.model.email.response.EmailSendResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("")
public interface EmailServiceProxy extends EmailService {

    @Override
    @GET
    @Path("/emails/supported_emails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<String> getSupportedEmails();

    @Override
    @GET
    @Path("/emails/default_layout/{identifier}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    DefaultEmailResponse getDefaultEmailTemplate(@PathParam("identifier") String identifier);

    @Override
    @POST
    @Path("/emails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    EmailResponse createEmail(EmailCreateUpdate create);

    @Override
    @PUT
    @Path("/emails/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    EmailResponse updateEmail(@PathParam("id") String id, EmailCreateUpdate create);

    @Override
    @DELETE
    @Path("/emails/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    EmailResponse deleteEmail(@PathParam("id") String id);

    @Override
    @GET
    @Path("/emails/preview/{identifier}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    EmailPreviewResponse previewEmail(@PathParam("identifier") String identifier);

    @Override
    @POST
    @Path("/emails/test/{identifier}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    EmailSendResponse sendEmail(@PathParam("identifier") String identifier, EmailSend emailSend);

    @Override
    @GET
    @Path("/emails/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    EmailResponse detailEmail(@PathParam("id") String id);

    @Override
    @GET
    @Path("/emails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<EmailResponse> listEmails();
}
