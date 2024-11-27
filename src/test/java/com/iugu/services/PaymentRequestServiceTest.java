package com.iugu.services;

import com.iugu.Mocks;
import com.iugu.exceptions.IuguException;
import com.iugu.model.PaymentRequest;
import com.iugu.responses.PaymentRequestResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRequestServiceTest {

    @Test
    public void testCreate() throws IuguException {
        PaymentRequestService paymentRequestService = new PaymentRequestService(Mocks.mockProdConfiguration());

        try {
            PaymentRequestResponse response = paymentRequestService.create(PaymentRequest.builder().amountCents(10).build());
        } catch (Exception ex) {
            Assertions.assertEquals("{\"errors\":{\"barcode\":\"is invalid\"}}", ex.getMessage());
        }
    }
}