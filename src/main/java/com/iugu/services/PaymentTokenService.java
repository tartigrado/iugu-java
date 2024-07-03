package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.payment_token.CreatePaymentToken;
import com.iugu.responses.payment_token.PaymentTokenResponse;
import com.iugu.services.generic.GenericService;
import com.iugu.utils.UriUtils;

public final class PaymentTokenService extends GenericService {

    private final static String CREATE_URL = IuguConfiguration.url("/payment_token");

    public PaymentTokenService(
            IuguConfiguration iuguConfiguration
    ) {
        super(iuguConfiguration);
    }

    public PaymentTokenResponse create(CreatePaymentToken createPaymentToken) throws IuguException {
        return token(createPaymentToken);
    }

    public PaymentTokenResponse token(CreatePaymentToken createPaymentToken) throws IuguException {
        return postNotAuth(UriUtils.createURI(CREATE_URL), createPaymentToken, PaymentTokenResponse.class);
    }

}
