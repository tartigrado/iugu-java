package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.PaymentRequest;
import com.iugu.responses.PaymentRequestResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class PaymentRequestService {

    private IuguConfiguration iugu;
    private final String FIND_ALL_URL = IuguConfiguration.url("/payment_requests");
    private final String CREATE_URL = IuguConfiguration.url("/payment_requests");
    private final String FIND_URL = IuguConfiguration.url("/payment_requests/%s");
    private final String FIND_PARAMS_URL = IuguConfiguration.url("/payment_requests?%s");
    private final String VALIDATE_URL = IuguConfiguration.url("/payment_requests/validate");

    public PaymentRequestService(IuguConfiguration iuguConfiguration) { this.iugu = iuguConfiguration; }

    public PaymentRequestResponse create(PaymentRequest paymentRequest) throws IuguException {
        Response response = this.iugu.getNewClient().target(CREATE_URL).request().post(Entity.entity(paymentRequest, MediaType.APPLICATION_JSON));

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

        throw new IuguException("Error creating payment request!", ResponseStatus, ResponseText);
    }

    public PaymentRequestResponse find(String id) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(FIND_URL, id)).request().get();

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

    public List<PaymentRequestResponse> findByParams(String params) throws IuguException {
        Response response = this.iugu.getNewClient().target(String.format(FIND_PARAMS_URL, params)).request().get();
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

    public List<PaymentRequestResponse> findAll() throws IuguException {
        Response response = this.iugu.getNewClient().target(FIND_ALL_URL).request().get();
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

    // TODO: Validate payment request
}
