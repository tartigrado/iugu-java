package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.components.rsa.FilePrivateKeyProvider;
import com.iugu.exceptions.IuguException;
import com.iugu.model.RequestWithdraw;
import com.iugu.responses.RequestWithdrawResponse;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class AccountServiceTest {

    @Test
    public void testRequestWithdraw() throws Exception {
        AccountService accountService = new AccountService(Mocks.mockConfiguration());
        try {
            accountService.requestWithdraw(RequestWithdraw.builder().amount(0F).build(), TestConstants.ACCOUNT_ID);
        } catch (IuguException ex) {
            Assert.assertTrue(
                    Objects.equals("{\"errors\":{\"amount\":[\"deve ser maior que ou igual a 5\"]}}", ex.getMessage()) ||
                    Objects.equals("{\"errors\":{\"amount\":[\"must be greater than or equal to 5\"]}}", ex.getMessage())
            );
        }

    }
}