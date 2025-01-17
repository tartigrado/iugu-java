package com.iugu.services.account;

import com.iugu.IuguConfiguration;
import com.iugu.components.HttpClientManager;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.account.AccountConfiguration;
import com.iugu.model.account.AccountCreate;
import com.iugu.model.account.response.AccountCreateResponse;
import com.iugu.model.account.response.AccountResponse;
import com.iugu.model.generic.SignedBody;
import com.iugu.services.signature.ValidateSignatureService;
import com.iugu.services.signature.ValidateSignatureServiceImpl;
import jakarta.ws.rs.WebApplicationException;

public final class AccountServiceImpl implements AccountService {
    private final AccountService proxy;
    private final ValidateSignatureService validateSignatureService;
    private final IuguConfiguration configuration;

    public AccountServiceImpl(
            IuguConfiguration iuguConfiguration
    ) {
        this.configuration = iuguConfiguration;
        this.validateSignatureService = new ValidateSignatureServiceImpl(iuguConfiguration);
        this.proxy = HttpClientManager.proxy(AccountServiceProxy.class, iuguConfiguration.authenticator());
    }

    @Override
    public AccountCreateResponse createAccount(String requestTime, String signature, String body) {
        try {
            return proxy.createAccount(requestTime, signature, body);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    String createAccountUrl() {
        return IuguConfiguration.baseUrl("/marketplace/create_account");
    }

    @Override
    public AccountCreateResponse createAccount(AccountCreate accountCreate) {
        accountCreate = configuration.withToken(accountCreate);
        validateSignatureService.validateSignature(accountCreate);
        SignedBody body = configuration.signBody(accountCreate, "POST", createAccountUrl());
        return createAccount(body.signedAtAsString(), "signature=" + body.getSignedMessage(), body.getBody());
    }

    @Override
    public AccountResponse detailAccount(String id) {
        try {
            return proxy.detailAccount(id);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    String configureAccountUrl() {
        return IuguConfiguration.baseUrl("/accounts/configuration");
    }

    @Override
    public AccountResponse configureAccount(AccountConfiguration accountConfiguration) {
        accountConfiguration = configuration.withToken(accountConfiguration);
        validateSignatureService.validateSignature(accountConfiguration);
        SignedBody body = configuration.signBody(accountConfiguration, "POST", configureAccountUrl());
        return configureAccount(body.signedAtAsString(), "signature=" + body.getSignedMessage(), body.getBody());
    }

    @Override
    public AccountResponse configureAccount(String requestTime, String signature, String body) {
        try {
            return proxy.configureAccount(requestTime, signature, body);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }
}
