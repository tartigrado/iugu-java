package com.iugu.services.token;

import com.iugu.TestConstants;
import com.iugu.enums.PayableWith;
import com.iugu.model.card.CardData;
import com.iugu.model.token.PaymentTokenCreate;
import com.iugu.model.token.response.PaymentTokenResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.Objects;

public class PaymentTokenServiceTest {
    PaymentTokenService paymentTokenService = new PaymentTokenServiceImpl();

    @Test
    @DisplayName("PaymentTokenService: should create token")
    public void testCreateToken() {
        PaymentTokenResponse tokenResponse = paymentTokenService.createToken(PaymentTokenCreate
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

        Assertions.assertNotNull(tokenResponse.getId());
        Assertions.assertNotNull(tokenResponse.getExtraInfo());
        Assertions.assertEquals("VISA", tokenResponse.getExtraInfo().getBrand());
        Assertions.assertEquals("ARTUR O CARVALHO", tokenResponse.getExtraInfo().getHolderName());
        Assertions.assertEquals("XXXX-XXXX-XXXX-1111", tokenResponse.getExtraInfo().getDisplayNumber());
    }
}