package com.iugu.services;

import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.exceptions.IuguException;
import com.iugu.model.withdraw.RequestWithdraw;
import com.iugu.model.withdraw.response.WithdrawResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountServiceTest {

    @Test
    public void testRequestWithdraw() throws Exception {
        AccountService accountService = new AccountService(Mocks.mockProdConfiguration());
        try {
            WithdrawResponse response = accountService.requestWithdraw(RequestWithdraw.builder().amount(BigDecimal.ZERO).build(), TestConstants.ACCOUNT_ID);
            Assertions.assertNotNull(response);
        } catch (IuguException ex) {
            Assertions.assertEquals("{\"errors\":{\"amount\":[\"deve ser maior que ou igual a 5\"]}}", ex.getMessage());
        }

    }
}