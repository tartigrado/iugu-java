package com.iugu.services;

import com.iugu.IuguConfiguration;
import jakarta.ws.rs.client.Client;
import com.iugu.exceptions.IuguException;
import com.iugu.model.PaymentRequest;
import com.iugu.model.ValidatePaymentRequest;
import com.iugu.responses.PaymentRequestResponse;
import com.iugu.responses.ValidatePaymentRequestResponse;
import com.iugu.services.generic.GenericRsaService;

import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

public class PaymentRequestService extends GenericRsaService {
    private final static String CREATE_URL = "/payment_requests";
    private final String FIND_URL = IuguConfiguration.url("/payment_requests/%s");
    private final String FIND_PARAMS_URL = IuguConfiguration.url("/payment_requests?%s");
    private final String VALIDATE_URL = IuguConfiguration.url("/payment_requests/validate");

    public PaymentRequestService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration, new ValidateSignatureService(iuguConfiguration));
    }

    public PaymentRequestResponse create(PaymentRequest paymentRequest) throws IuguException {
        getIugu().withToken(paymentRequest);
        return requestWithSignature(HttpMethod.POST, CREATE_URL, paymentRequest, PaymentRequestResponse.class);
    }

    public PaymentRequestResponse find(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_URL, id)).request().get();

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(PaymentRequestResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error finding payment request with id: " + id, ResponseStatus, ResponseText);
        }
    }

    public List<PaymentRequestResponse> findByParams(String params) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_PARAMS_URL, params)).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(new GenericType<List<PaymentRequestResponse>>() {
                });
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error finding payment requests!", ResponseStatus, ResponseText);
        }
    }

    public ValidatePaymentRequestResponse validate(ValidatePaymentRequest validatePaymentRequest) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(VALIDATE_URL).request().post(Entity.entity(validatePaymentRequest, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(ValidatePaymentRequestResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error validating payment request!", ResponseStatus, ResponseText);
        }
    }
}
