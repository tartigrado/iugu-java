package com.iugu.services;

import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.exceptions.IuguException;
import com.iugu.model.CardData;
import com.iugu.model.customer.AddCreditCard;
import com.iugu.model.customer.PaymentMethodEdit;
import com.iugu.responses.customer.PaymentMethodListResponse;
import com.iugu.responses.customer.PaymentMethodResponse;
import org.junit.Assert;
import org.junit.Test;

import java.time.Year;
import java.util.List;
import java.util.Objects;

public class CustomerServiceTest {

    @Test
    public void testListPaymentMethods() {
        try {
            CustomerService customerService = new CustomerService(Mocks.mockConfiguration());
            PaymentMethodListResponse paymentMethods = customerService.listPaymentMethods("41C41E6EEB824B27B980E9509143229A");
            Assert.assertNotNull(paymentMethods);
            Assert.assertEquals(2, paymentMethods.getData().size());
        } catch (IuguException ex) {
            Assert.assertEquals("", ex.getMessage());
        }
    }

    @Test
    public void testEditPaymentMethod() {
        try {
            String customerId = "41C41E6EEB824B27B980E9509143229A";
            CustomerService customerService = new CustomerService(Mocks.mockConfiguration());
            PaymentMethodListResponse paymentMethods = customerService.listPaymentMethods(customerId);
            PaymentMethodResponse paymentMethod = paymentMethods.first();

            PaymentMethodResponse paymentMethodResponse = customerService.editPaymentMethod(customerId, paymentMethod.getId(), PaymentMethodEdit.builder().description("Cartao de teste ediçao").build());

            Assert.assertEquals("Cartao de teste ediçao", paymentMethodResponse.getDescription());
        } catch (IuguException ex) {
            Assert.assertEquals("", ex.getMessage());
        }
    }
}