package com.iugu.services.withdraw;

import com.iugu.IuguConfiguration;
import com.iugu.components.HttpClientManager;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.withdraw.RequestWithdraw;
import com.iugu.model.generic.SignedBody;
import com.iugu.model.withdraw.response.WithdrawResponse;
import com.iugu.model.withdraw.WithdrawFilter;
import com.iugu.model.withdraw.response.WithdrawsResponse;
import com.iugu.services.signature.ValidateSignatureService;
import com.iugu.services.signature.ValidateSignatureServiceImpl;
import jakarta.ws.rs.WebApplicationException;

public final class WithdrawServiceImpl implements WithdrawService {

    private final WithdrawService proxy;
    private final ValidateSignatureService validateSignatureService;
    private final IuguConfiguration configuration;

    public WithdrawServiceImpl(
            IuguConfiguration iuguConfiguration
    ) {
        this.configuration = iuguConfiguration;
        this.validateSignatureService = new ValidateSignatureServiceImpl(iuguConfiguration);
        this.proxy = HttpClientManager.proxy(WithdrawServiceProxy.class, iuguConfiguration.authenticator());
    }

    @Override
    public WithdrawsResponse listWithdraws(WithdrawFilter withdrawFilter) {
        try {
            return proxy.listWithdraws(withdrawFilter);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public WithdrawResponse detailWithdraw(String id) {
        try {
            return proxy.detailWithdraw(id);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    String getWithdrawEndpoint(String accountId) {
        return IuguConfiguration.baseUrl("/accounts/" + accountId + "/request_withdraw");
    }

    @Override
    public WithdrawResponse withdrawRequest(String accountId, String requestTime, String signature, String body) {
        try {
            return proxy.withdrawRequest(accountId, requestTime, signature, body);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public WithdrawResponse withdrawRequest(String accountId, RequestWithdraw withdraw) {
        withdraw = configuration.withToken(withdraw);
        validateSignatureService.validateSignature(withdraw);
        SignedBody body = configuration.signBody(withdraw, "POST", getWithdrawEndpoint(accountId));
        return withdrawRequest(accountId, body.signedAtAsString(), "signature=" + body.getSignedMessage(), body.getBody());
    }
}
