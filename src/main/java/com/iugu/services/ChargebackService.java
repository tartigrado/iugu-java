package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.responses.ChargebacksResponse;

import javax.ws.rs.core.Response;

public class ChargebackService {

    private IuguConfiguration iugu;
    private final String FIND_ALL_URL = IuguConfiguration.url("/chargebacks");

    public ChargebackService(IuguConfiguration iugu) {
        this.iugu = iugu;
    }

    public ChargebacksResponse findAll() throws IuguException {
        Response response = this.iugu.getNewClient().target(FIND_ALL_URL).request().get();
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(ChargebacksResponse.class);

        // Error Happened
        if (response.hasEntity())
            ResponseText = response.readEntity(String.class);

        response.close();

        throw new IuguException("Error finding chargebacks!", ResponseStatus, ResponseText);
    }

}
