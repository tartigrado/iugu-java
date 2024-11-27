package com.iugu.services.invoice;


import com.iugu.model.Invoice;
import com.iugu.model.invoice.*;
import com.iugu.model.invoice.response.InvoiceResponse;
import com.iugu.model.invoice.response.InvoicesResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("")
public interface InvoiceServiceProxy extends InvoiceService {

    @Override
    @POST
    @Path("/invoices")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceResponse createInvoice(InvoiceCreate create);

    @Override
    @POST
    @Path("/invoices")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceResponse createInvoice(Invoice create);

    @Override
    @POST
    @Path("/invoices/{id}/capture")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceResponse captureInvoice(@PathParam("id") String id);

    @Override
    @POST
    @Path("/invoices/{id}/refund")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceResponse refundInvoice(@PathParam("id") String id, InvoiceRefund invoiceRefund);

    @Override
    @PUT
    @Path("/invoices/{id}/cancel")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceResponse cancelInvoice(@PathParam("id") String id);

    @Override
    @POST
    @Path("/invoices/{id}/duplicate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceResponse duplicateInvoice(@PathParam("id") String id, DuplicateInvoice duplicateInvoice);

    @Override
    @POST
    @Path("/invoices/{id}/duplicate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceResponse reissueInvoice(@PathParam("id") String id, ReissueInvoice reissueInvoice);

    @Override
    @GET
    @Path("/invoices/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceResponse getInvoice(@PathParam("id") String id);


    @Override
    @GET
    @Path("/invoices")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoicesResponse listInvoices(@BeanParam InvoiceFilter filter);

    @Override
    @POST
    @Path("/invoices/{id}/send_email")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceResponse sendInvoiceEmail(@PathParam("id") String id);

    @Override
    @PUT
    @Path("/invoices/{id}/externally_pay")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    InvoiceResponse invoiceExternalPaid(@PathParam("id") String id, InvoiceExternalPaid invoiceExternalPaid);


}
