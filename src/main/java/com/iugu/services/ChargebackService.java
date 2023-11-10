package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.components.ClientWrapper;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Contest;
import com.iugu.responses.ChargebackResponse;
import com.iugu.responses.ChargebacksResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ChargebackService extends GenericService {

    private final String FIND_ALL_URL = IuguConfiguration.url("/chargebacks");
    private final String FIND_URL = IuguConfiguration.url("/chargebacks/%s");
    private final String ACCEPT_URL = IuguConfiguration.url("/chargebacks/%s/accept");
    private final String CONTEST_URL = IuguConfiguration.url("/chargebacks/%s/contest");

    public ChargebackService(IuguConfiguration iugu) {
        super(iugu);
    }

    public ChargebacksResponse findAll() throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(FIND_ALL_URL).request().get();
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

    public ChargebackResponse find(String id) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_URL, id)).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;
            if (ResponseStatus == 200) {
                return response.readEntity(ChargebackResponse.class);
            }
            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }
            response.close();
            throw new IuguException("Error finding chargeback with id: " + id, ResponseStatus, ResponseText);
        }
    }

    public ChargebackResponse accept(String id) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(String.format(ACCEPT_URL, id)).request().put(null);
            int ResponseStatus = response.getStatus();
            String ResponseText = null;
            if (ResponseStatus == 200) {
                return response.readEntity(ChargebackResponse.class);
            }
            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }
            response.close();
            throw new IuguException("Error accepting chargeback with id: " + id, ResponseStatus, ResponseText);
        }
    }

    public ChargebackResponse contest(String id, Contest contest) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(String.format(CONTEST_URL, id)).request().put(Entity.entity(contest, MediaType.APPLICATION_JSON_TYPE));
            int ResponseStatus = response.getStatus();
            String ResponseText = null;
            if (ResponseStatus == 200) {
                return response.readEntity(ChargebackResponse.class);
            }
            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }
            response.close();
            throw new IuguException("Error contesting chargeback with id: " + id, ResponseStatus, ResponseText);
        }
    }

}
