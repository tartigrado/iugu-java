package com.iugu.services;

import com.iugu.Mocks;
import com.iugu.exceptions.IuguException;
import com.iugu.model.PaymentRequest;
import com.iugu.responses.PaymentRequestResponse;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentRequestServiceTest {

    @Test
    public void testCreate() throws IuguException {
        PaymentRequestService paymentRequestService = new PaymentRequestService(Mocks.mockConfiguration());

        try {
            PaymentRequestResponse response = paymentRequestService.create(PaymentRequest.builder().amountCents(10).build());
        } catch (Exception ex) {
            Assert.assertEquals("{\"errors\":{\"barcode\":\"is invalid\"}}", ex.getMessage());
        }
    }
}