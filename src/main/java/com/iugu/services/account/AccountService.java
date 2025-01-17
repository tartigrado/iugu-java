package com.iugu.services.account;

import com.iugu.model.account.AccountConfiguration;
import com.iugu.model.account.AccountCreate;
import com.iugu.model.account.response.AccountCreateResponse;
import com.iugu.model.account.response.AccountResponse;

public interface AccountService {
    AccountCreateResponse createAccount(AccountCreate accountCreate);

    AccountCreateResponse createAccount(String requestTime, String signature, String body);

    AccountResponse configureAccount(AccountConfiguration accountConfiguration);

    AccountResponse configureAccount(String requestTime, String signature, String body);

    AccountResponse detailAccount(String id);
}
