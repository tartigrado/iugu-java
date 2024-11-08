package com.iugu.services;

import com.iugu.IuguConfiguration;
import jakarta.ws.rs.client.Client;
import com.iugu.exceptions.IuguException;
import com.iugu.model.DunningSteps;
import com.iugu.responses.StepsResponse;
import com.iugu.services.generic.GenericService;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

public class DunningStepsService extends GenericService {
    private final String FIND_URL = IuguConfiguration.url("/dunning_steps");
    private final String UPDATE_URL = IuguConfiguration.url("/dunning_steps");

    public DunningStepsService(IuguConfiguration iugu) {
        super(iugu);
    }

    public List<StepsResponse> findAll() throws IuguException {
        try (Client client = getIugu().getNewClient()) {
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
        try (Client client = getIugu().getNewClient()) {
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
