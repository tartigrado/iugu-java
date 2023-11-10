package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.components.ClientWrapper;
import com.iugu.exceptions.IuguException;
import com.iugu.model.PaymentToken;
import com.iugu.responses.PaymentTokenResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PaymentTokenService extends GenericService {

    private final String CREATE_URL = IuguConfiguration.url("/payment_token");

    public PaymentTokenService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration);
    }

    public PaymentTokenResponse create(PaymentToken paymentToken) throws IuguException {
        try (ClientWrapper client = this.iugu.getNewClientNotAuth()) {
            Response response = client.target(CREATE_URL).request().post(Entity.entity(paymentToken, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(PaymentTokenResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error creating token!", ResponseStatus, ResponseText);
        }
    }

}
