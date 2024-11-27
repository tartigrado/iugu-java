package com.iugu.services;

import com.iugu.IuguConfiguration;
import jakarta.ws.rs.client.Client;
import com.iugu.exceptions.IuguException;
import com.iugu.model.invoice.DuplicateInvoice;
import com.iugu.model.Invoice;
import com.iugu.model.invoice.InvoiceCreate;
import com.iugu.model.invoice.response.InvoiceResponse;
import com.iugu.model.invoice.response.InvoicesResponse;
import com.iugu.services.generic.GenericService;
import com.iugu.utils.ConvertionUtils;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoiceService extends GenericService {

    private final String FIND_ALL_URL = IuguConfiguration.url("/invoices");
    private final String CREATE_URL = IuguConfiguration.url("/invoices");
    private final String FIND_URL = IuguConfiguration.url("/invoices/%s");
    private final String FIND_PARAMS_URL = IuguConfiguration.url("/invoices?%s");
    private final String DUPLICATE_URL = IuguConfiguration.url("/invoices/%s/duplicate");
    private final String UPDATE_URL = IuguConfiguration.url("/invoices/%s");
    private final String CANCEL_URL = IuguConfiguration.url("/invoices/%s/cancel");
    private final String REFUND_URL = IuguConfiguration.url("/invoices/%s/refund");
    private final String FIND_CUSTOMER_URL = IuguConfiguration.url("/invoices?customer_id=%s");
    private final String FIND_ORDER_ID = IuguConfiguration.url("/invoices?order_id=%s");
    private final String SEND_EMAIL_URL = IuguConfiguration.url("/invoices/%s/send_email");

    public InvoiceService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration);
    }

    public InvoiceResponse create(InvoiceCreate invoice) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(CREATE_URL).request().post(Entity.entity(invoice, MediaType.APPLICATION_JSON));
            return readResponse(response, InvoiceResponse.class, "Error creating invoice!");
        }
    }

    public InvoiceResponse create(Invoice invoice) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(CREATE_URL).request().post(Entity.entity(invoice, MediaType.APPLICATION_JSON));
            return readResponse(response, InvoiceResponse.class, "Error creating invoice!");
        }
    }

    public InvoiceResponse find(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_URL, id)).request().get();
            return readResponse(response, InvoiceResponse.class, "Error finding invoice with id: " + id);

        }
    }

    public InvoiceResponse duplicate(String id, DuplicateInvoice invoice) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(DUPLICATE_URL, id)).request().post(Entity.entity(invoice, MediaType.APPLICATION_JSON));
            return readResponse(response, InvoiceResponse.class, "Error duplicating invoice with id: " + id);
        }
    }

    public InvoiceResponse duplicate(String id, Date date, boolean ignoreCanceledEmail, boolean currentFinesOption) throws IuguException {
        SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
        Form form = new Form();

        form.param("due_date", sm.format(date));
        form.param("ignore_canceled_email", ConvertionUtils.booleanToString(ignoreCanceledEmail));
        form.param("current_fines_option", ConvertionUtils.booleanToString(currentFinesOption));

        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(DUPLICATE_URL, id)).request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
            return readResponse(response, InvoiceResponse.class, "Error duplicating invoice with id: " + id);
        }
    }


    public InvoiceResponse cancel(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(CANCEL_URL, id)).request().put(null);

            return readResponse(response, InvoiceResponse.class, "Error canceling invoice with id: " + id);
        }
    }

    public InvoiceResponse update(Invoice invoice) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(UPDATE_URL, invoice.getId())).request().put(Entity.entity(invoice, MediaType.APPLICATION_JSON));
            return readResponse(response, InvoiceResponse.class, "Error updating invoice with id: " + invoice.getId());
        }
    }

    public InvoiceResponse refund(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(REFUND_URL, id)).request().post(null);

            return readResponse(response, InvoiceResponse.class, "Error refunding invoice with id: " + id);
        }
    }

    //
    public InvoicesResponse findByParams(String params) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_PARAMS_URL, params)).request().get();
            return readResponse(response, InvoicesResponse.class, "Error finding invoices requests!");
        }
    }

    public InvoicesResponse findByOrderId(String orderId) throws IuguException {
        return findByParams("query=" + orderId);
    }

    public InvoiceResponse sendEmail(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(SEND_EMAIL_URL, id)).request().post(Entity.entity(null, MediaType.APPLICATION_JSON));
            return readResponse(response, InvoiceResponse.class, "Error send Email invoices request!");
        }
    }

}
