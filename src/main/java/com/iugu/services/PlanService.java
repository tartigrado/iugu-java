package com.iugu.services;

import com.iugu.IuguConfiguration;
import jakarta.ws.rs.client.Client;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Plan;
import com.iugu.responses.PlanResponse;
import com.iugu.responses.PlansResponse;
import com.iugu.services.generic.GenericService;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class PlanService extends GenericService {
    private final String CREATE_URL = IuguConfiguration.url("/plans");
    private final String FIND_URL = IuguConfiguration.url("/plans/%s");
    private final String FIND_BY_IDENTIFIER_URL = IuguConfiguration.url("/plans/identifier/%s");
    private final String CHANGE_URL = IuguConfiguration.url("/plans/%s");
    private final String REMOVE_URL = IuguConfiguration.url("/plans/%s");
    private final String FIND_ALL_URL = IuguConfiguration.url("/plans");

    public PlanService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration);
    }

    public PlanResponse create(Plan plan) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(CREATE_URL).request().post(Entity.entity(plan, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(PlanResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error creating plan!", ResponseStatus, ResponseText);
        }
    }

    public PlanResponse find(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_URL, id)).request().get();

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(PlanResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error finding plan!", ResponseStatus, ResponseText);
        }
    }

    public PlanResponse findByIdentifier(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_BY_IDENTIFIER_URL, id)).request().get();

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(PlanResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error finding plan by identifier!", ResponseStatus, ResponseText);
        }
    }

    public PlanResponse change(String id, Plan plan) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(CHANGE_URL, id)).request().put(Entity.entity(plan, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(PlanResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error changing plan!", ResponseStatus, ResponseText);
        }
    }

    public PlanResponse remove(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(REMOVE_URL, id)).request().delete();

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(PlanResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error removing plan!", ResponseStatus, ResponseText);
        }
    }

    public PlansResponse findAll() throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(FIND_ALL_URL).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(PlansResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error finding plans!", ResponseStatus, ResponseText);
        }
    }
}
