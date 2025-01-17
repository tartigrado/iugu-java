package com.iugu.services.account;

import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.exceptions.IuguException;
import com.iugu.model.account.AccountConfiguration;
import com.iugu.model.account.AccountCreate;
import com.iugu.model.account.response.AccountResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountServiceImplTest {
    AccountService accountService = new AccountServiceImpl(Mocks.mockProdConfiguration());

    @Test
    @DisplayName("AccountService: should detail account")
    void testDetailAccount() {
        AccountResponse account = accountService.detailAccount(TestConstants.ACCOUNT_ID);

        Assertions.assertNotNull(account);
        Assertions.assertNotNull(account.getConfiguration());
    }

    @Test
    @DisplayName("AccountService: should create account")
    void testCreateAccount() {
        IuguException ex = Assertions.assertThrows(IuguException.class, () -> accountService.createAccount(AccountCreate
                .builder()
                .build()));

        Assertions.assertEquals("[Essa conta não tem autorização de marketplace]", ex.getIuguError().getMainMessage());
    }

    @Test
    @DisplayName("AccountService: should configure account")
    void testConfigureAccount() {
        AccountResponse account = accountService.configureAccount(AccountConfiguration
                .builder()
                .disabledWithdraw(true)
                .build());
        Assertions.assertNotNull(account);
        Assertions.assertTrue(account.getDisabledWithdraw());
    }

}
