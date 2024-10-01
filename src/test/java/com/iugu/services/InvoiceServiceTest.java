package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.TestConstants;
import com.iugu.exceptions.IuguException;
import com.iugu.model.invoice.InvoiceCreate;
import com.iugu.model.invoice.InvoiceItemCreate;
import com.iugu.responses.InvoiceResponse;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;

public class InvoiceServiceTest {


    @Test
    public void create() throws IuguException {
        InvoiceService service = new InvoiceService(new IuguConfiguration(TestConstants.PROD_ARTUR_TOKEN));

        InvoiceResponse invoice = service.find("FB9A0253021C4655A2527AA997EF709D");

    }
}