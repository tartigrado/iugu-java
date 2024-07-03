package com.iugu.services;

import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.enums.PayableWith;
import com.iugu.exceptions.IuguException;
import com.iugu.model.CardData;
import com.iugu.model.payment_token.CreatePaymentToken;
import com.iugu.responses.payment_token.PaymentTokenResponse;
import org.junit.Assert;
import org.junit.Test;

import java.time.Year;
import java.util.Objects;

public class PaymentTokenServiceTest {

    @Test
    public void testToken() {
        PaymentTokenService paymentRequestService = new PaymentTokenService(Mocks.mockConfiguration());

        try {
            PaymentTokenResponse tokenResponse = paymentRequestService.token(CreatePaymentToken
                    .builder()
                    .accountId(TestConstants.ACCOUNT_ID)
                    .test(true)
                    .payableWith(PayableWith.CREDIT_CARD)
                    .cardData(CardData
                            .builder()
                            .number("4111111111111111")
                            .firstName("ARTUR O")
                            .lastName("CARVALHO")
                            .verificationValue("123")
                            .month("12")
                            .year(Objects.toString(Year.now().plusYears(10).getValue()))
                            .build())
                    .build());

            Assert.assertNotNull(tokenResponse.getId());
            Assert.assertNotNull(tokenResponse.getExtraInfo());
            Assert.assertEquals("VISA", tokenResponse.getExtraInfo().getBrand());
            Assert.assertEquals("ARTUR O CARVALHO", tokenResponse.getExtraInfo().getHolderName());
            Assert.assertEquals("XXXX-XXXX-XXXX-1111", tokenResponse.getExtraInfo().getDisplayNumber());

        } catch (IuguException e) {
            throw new RuntimeException(e);
        }
    }
}