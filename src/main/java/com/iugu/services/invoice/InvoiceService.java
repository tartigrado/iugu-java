package com.iugu.services.invoice;

import com.iugu.model.Invoice;
import com.iugu.model.invoice.*;
import com.iugu.model.invoice.response.InvoiceResponse;
import com.iugu.model.invoice.response.InvoicesResponse;
import jakarta.ws.rs.PathParam;

public interface InvoiceService {

    InvoiceResponse createInvoice(InvoiceCreate create);

    InvoiceResponse createInvoice(Invoice create);

    InvoiceResponse captureInvoice(String id);

    InvoiceResponse refundInvoice(String id, InvoiceRefund invoiceRefund);

    InvoiceResponse cancelInvoice(String id);

    InvoiceResponse duplicateInvoice(String id, DuplicateInvoice duplicateInvoice);

    InvoiceResponse reissueInvoice(String id, ReissueInvoice reissueInvoice);

    InvoiceResponse getInvoice(String id);

    InvoicesResponse listInvoices(InvoiceFilter filter);

    InvoiceResponse sendInvoiceEmail(String id);

    InvoiceResponse invoiceExternalPaid(String id, InvoiceExternalPaid invoiceExternalPaid);
}
