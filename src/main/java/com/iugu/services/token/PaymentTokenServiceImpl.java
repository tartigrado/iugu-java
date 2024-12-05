package com.iugu.services.token;

import com.iugu.components.HttpClientManager;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.token.PaymentTokenCreate;
import com.iugu.model.token.response.PaymentTokenResponse;
import jakarta.ws.rs.WebApplicationException;

public final class PaymentTokenServiceImpl implements PaymentTokenService {

    private final PaymentTokenService proxy = HttpClientManager.proxy(PaymentTokenServiceProxy.class);

    @Override
    public PaymentTokenResponse createToken(PaymentTokenCreate paymentToken) {
        try {
            return proxy.createToken(paymentToken);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }
}
