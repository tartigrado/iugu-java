package com.iugu.services.general;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.invoice.InvoiceCreate;
import com.iugu.services.invoice.InvoiceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneralServiceTest {

    @Test
    @DisplayName("General: Test if client is handling unauthorized requests")
    void test() {
        InvoiceServiceImpl invoiceService = new InvoiceServiceImpl(new IuguConfiguration("invalid_token"));

        IuguException exception = Assertions.assertThrows(IuguException.class, () -> invoiceService.createInvoice((InvoiceCreate) null));
        Assertions.assertEquals("Não autorizado", exception.getMessage());
    }
}
