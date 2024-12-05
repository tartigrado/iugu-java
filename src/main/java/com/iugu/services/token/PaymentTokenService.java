package com.iugu.services.token;

import com.iugu.model.token.PaymentTokenCreate;
import com.iugu.model.token.response.PaymentTokenResponse;

public interface PaymentTokenService {

    PaymentTokenResponse createToken(PaymentTokenCreate paymentToken);
}
