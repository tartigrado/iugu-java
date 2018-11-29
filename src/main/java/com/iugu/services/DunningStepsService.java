package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.responses.StepsResponse;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class DunningStepsService {

    private IuguConfiguration iugu;
    private final String FIND_URL = IuguConfiguration.url("/dunning_steps");

    public DunningStepsService(IuguConfiguration iugu) {
        this.iugu = iugu;
    }

    public List<StepsResponse> findAll() throws IuguException {
        Response response = this.iugu.getNewClient().target(FIND_URL).request().get();
        int ResponseStatus = response.getStatus();
        String ResponseText = null;

        if (ResponseStatus == 200)
            return response.readEntity(new GenericType<List<StepsResponse>>() {
            });

        // Error Happened
        if (response.hasEntity()) {
            ResponseText = response.readEntity(String.class);
        }

        response.close();

        throw new IuguException("Error finding dunning steps!", ResponseStatus, ResponseText);
    }

}
