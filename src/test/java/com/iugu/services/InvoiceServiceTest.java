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


        InvoiceResponse invoice = service.create(InvoiceCreate
                .builder()
                .customerId("5F9F9F785C4B43E9AD175E1A9D8927D9")
                .email("teste_revgas@revgas.com")
                .items(Collections.singletonList(InvoiceItemCreate.builder()
                        .description("Item 1")
                        .quantity(1)
                        .priceCents(2000)
                        .build()))
                .dueDate(Date.from(LocalDate.of(2023, 12, 5).atStartOfDay().atOffset(java.time.ZoneOffset.UTC).toInstant()))
                .build());

        System.out.println(invoice);
    }
}