package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.components.ClientWrapper;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Charge;
import com.iugu.responses.ChargeResponse;
import com.iugu.services.generic.GenericService;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ChargeService extends GenericService {
    private final String CREATE_URL = IuguConfiguration.url("/charge");

    public ChargeService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration);
    }

    public ChargeResponse create(Charge charge) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(CREATE_URL).request().post(Entity.entity(charge, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(ChargeResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error creating charge!", ResponseStatus, ResponseText);
        }
    }
}
