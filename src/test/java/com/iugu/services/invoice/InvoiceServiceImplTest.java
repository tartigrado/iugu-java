package com.iugu.services.invoice;

import com.iugu.Mocks;
import com.iugu.exceptions.IuguException;
import com.iugu.model.invoice.InvoiceCreate;
import com.iugu.model.invoice.InvoiceFilter;
import com.iugu.model.invoice.InvoiceStatus;
import com.iugu.model.invoice.response.InvoiceResponse;
import com.iugu.model.invoice.response.InvoicesResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class InvoiceServiceImplTest {

    InvoiceService service = new InvoiceServiceImpl(Mocks.mockConfiguration());

    @Test
    @DisplayName("InvoiceService: Should list invoice given a customer id")
    public void testListInvoicesWithCustomerId() {
        InvoicesResponse invoicesResponse = service.listInvoices(InvoiceFilter
                .builder()
                .customerId("9C2964F52DE747C384261DC7D236B1EC")
                .build());

        Assertions.assertNotNull(invoicesResponse.getFacets());
        Assertions.assertEquals(4, invoicesResponse.getTotalItems());
        Assertions.assertNotNull(invoicesResponse.getItems());
    }

    @Test
    @DisplayName("InvoiceService: Should list invoice given a period")
    public void testListInvoicesGivenAnPeriod() {
        InvoicesResponse invoicesResponse = service.listInvoices(InvoiceFilter
                .builder()
                .createdAtFrom("2024-10-01T00:00:00-00:00")
                .createdAtTo("2024-10-31T23:59:59-00:00")
                .start(0)
                .limit(5)
                .build());

        Assertions.assertNotNull(invoicesResponse.getFacets());
        Assertions.assertEquals(1, invoicesResponse.getTotalItems());
        Assertions.assertNotNull(invoicesResponse.getItems());
        Assertions.assertEquals(1, invoicesResponse.getItems().size());
    }

    @Test
    @DisplayName("InvoiceService: Should list invoice given a status")
    public void testListInvoicesGivenAnStatus() {
        InvoicesResponse invoicesResponse = service.listInvoices(InvoiceFilter
                .builder()
                .statusFilter("expired")
                .start(0)
                .limit(10)
                .build());

        Assertions.assertNotNull(invoicesResponse.getFacets());
        Assertions.assertNotNull(invoicesResponse.getTotalItems());
        Assertions.assertNotNull(invoicesResponse.getItems());
        Assertions.assertEquals(1, invoicesResponse.getItems().size());
        Assertions.assertTrue(invoicesResponse.getItems().stream().allMatch(it -> Objects.equals(it.getStatus(), InvoiceStatus.EXPIRED)));
    }

    @Test
    @DisplayName("InvoiceService: Should get invoice and return a invoice response without any properties")
    void testGetInvoiceWithoutAnyProperties() {
        InvoiceResponse response = service.getInvoice("26B50467AA0F4DFF97C37A0140E736C4");
        Assertions.assertNotNull(response);
        Assertions.assertNull(response.getAny());
        if (Objects.nonNull(response.getPix())) {
            Assertions.assertNull(response.getPix().getAny());
        }
        if (Objects.nonNull(response.getBankSlip())) {
            Assertions.assertNull(response.getBankSlip().getAny());
        }
        response.getCustomVariables().forEach(it -> {
            Assertions.assertNull(it.getAny());
        });
        response.getItems().forEach(it -> {
            Assertions.assertNotNull(it.getId());
            Assertions.assertNull(it.getAny());
        });
        if (Objects.nonNull(response.getFinancialReturnDates())) {
            response.getFinancialReturnDates().forEach(it -> {
                Assertions.assertNull(it.getAny());
            });
        }
    }


    @Test
    @DisplayName("InvoiceService: Should throws not found exception for not found")
    void testGetInvoiceNotFound() {
        IuguException ex = Assertions.assertThrows(IuguException.class, () -> service.getInvoice("TESTING_NOT_FOUND_INVOICE"));
        Assertions.assertEquals("Fatura não encontrada", ex.getMessage());
    }

    @Test
    @DisplayName("InvoiceService: Should throws iugu error when creating invoice without due date")
    void testCreateInvoiceWithoutDueDate() {
        IuguException ex = Assertions.assertThrows(IuguException.class, () -> service.createInvoice((InvoiceCreate) null));
        Assertions.assertEquals("Data de vencimento é obrigatório", ex.getMessage());
    }

    @Test
    @DisplayName("InvoiceService: Should throws anothers errors when creating invoice with due date")
    void testCreateInvoiceErrorWithDueDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 5);

        IuguException ex = Assertions.assertThrows(IuguException.class, () -> service.createInvoice(InvoiceCreate
                .builder()
                .dueDate(calendar.getTime())
                .build()));

        Assertions.assertTrue(ex.getMessage().contains("payer.cpf_cnpj [não pode ficar em branco]"), ex.getMessage());
        Assertions.assertTrue(ex.getMessage().contains("total [deve ser maior que 1]"), ex.getMessage());
        Assertions.assertTrue(ex.getMessage().contains("payer.name [não pode ficar em branco]"), ex.getMessage());
        Assertions.assertTrue(ex.getMessage().contains("email [não pode ficar em branco, é inválido]"), ex.getMessage());
        Assertions.assertTrue(ex.getMessage().contains("Geral [Faturas pendentes necessitam de pelo menos um item]"), ex.getMessage());
    }

    @Test
    @DisplayName("InvoiceService: Should not throws error when creating invoice")
    void testCreateInvoiceComplete() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 5);

        InvoiceResponse response = Assertions.assertDoesNotThrow(() -> service.createInvoice(InvoiceCreate
                .builder()
                .customerId("1BB58F934C4C4714A18403F1B6A4D739")
                .items(List.of(InvoiceCreate.InvoiceItem
                        .builder()
                        .quantity(1)
                        .description("Iugu Java Test")
                        .priceCents(100)
                        .build()))
                .dueDate(calendar.getTime())
                .build()));

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getId());
        Assertions.assertNull(response.getAny());
        response.getItems().forEach(it -> {
            Assertions.assertNotNull(it.getId());
            Assertions.assertNull(it.getAny());
        });
    }

}