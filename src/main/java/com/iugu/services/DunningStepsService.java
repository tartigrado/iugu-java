package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.components.ClientWrapper;
import com.iugu.exceptions.IuguException;
import com.iugu.model.DunningSteps;
import com.iugu.responses.StepsResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class DunningStepsService extends GenericService {
    private final String FIND_URL = IuguConfiguration.url("/dunning_steps");
    private final String UPDATE_URL = IuguConfiguration.url("/dunning_steps");

    public DunningStepsService(IuguConfiguration iugu) {
        super(iugu);
    }

    public List<StepsResponse> findAll() throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(FIND_URL).request().get();
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

    public List<StepsResponse> update(DunningSteps dunningSteps) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(UPDATE_URL).request().put(Entity.entity(dunningSteps, MediaType.APPLICATION_JSON_TYPE));
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

            throw new IuguException("Error updating dunning steps!", ResponseStatus, ResponseText);
        }
    }

}
