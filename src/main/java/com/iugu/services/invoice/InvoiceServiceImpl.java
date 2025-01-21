package com.iugu.services.invoice;

import com.iugu.IuguConfiguration;
import com.iugu.components.HttpClientManager;
import com.iugu.components.RetryComponent;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.Invoice;
import com.iugu.model.invoice.*;
import com.iugu.model.invoice.response.InvoiceResponse;
import com.iugu.model.invoice.response.InvoicesResponse;
import jakarta.ws.rs.WebApplicationException;

public final class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceService proxy;

    public InvoiceServiceImpl(
            IuguConfiguration iuguConfiguration
    ) {
        this.proxy = HttpClientManager.proxy(InvoiceServiceProxy.class, iuguConfiguration.authenticator());
    }

    @Override
    public InvoiceResponse createInvoice(InvoiceCreate create) {
        try {
            return proxy.createInvoice(create);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public InvoiceResponse createInvoice(Invoice create) {
        try {
            return proxy.createInvoice(create);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public InvoiceResponse captureInvoice(String id) {
        try {
            return proxy.captureInvoice(id);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public InvoiceResponse refundInvoice(String id, InvoiceRefund invoiceRefund) {
        try {
            return proxy.refundInvoice(id, invoiceRefund);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public InvoiceResponse cancelInvoice(String id) {
        try {
            return proxy.cancelInvoice(id);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public InvoiceResponse duplicateInvoice(String id, DuplicateInvoice duplicateInvoice) {
        try {
            return proxy.duplicateInvoice(id, duplicateInvoice);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public InvoiceResponse reissueInvoice(String id, ReissueInvoice reissueInvoice) {
        try {
            return proxy.reissueInvoice(id, reissueInvoice);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public InvoiceResponse getInvoice(String id) {
        try {
            return proxy.getInvoice(id);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public InvoicesResponse listInvoices(InvoiceFilter filter) {
        try {
            return RetryComponent.getInstance().retry(() -> proxy.listInvoices(filter));
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public InvoiceResponse sendInvoiceEmail(String id) {
        try {
            return proxy.sendInvoiceEmail(id);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public InvoiceResponse invoiceExternalPaid(String id, InvoiceExternalPaid invoiceExternalPaid) {
        try {
            return proxy.invoiceExternalPaid(id, invoiceExternalPaid);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

}
