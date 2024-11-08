package com.iugu.services;

import com.iugu.IuguConfiguration;
import jakarta.ws.rs.client.Client;
import com.iugu.exceptions.IuguException;
import com.iugu.responses.WithdrawConciliationsResponse;
import com.iugu.responses.WithdrawRequestResponse;
import com.iugu.responses.WithdrawRequestsResponse;
import com.iugu.services.generic.GenericService;

import jakarta.ws.rs.core.Response;

public class WithdrawRequestsService extends GenericService {

    private final String FIND_URL = IuguConfiguration.url("/withdraw_requests/%s");
    private final String FIND_ALL_URL = IuguConfiguration.url("/withdraw_requests");
    private final String WITHDRAW_CONCILIATIONS_URL = IuguConfiguration.url("/withdraw_conciliations?%s");

    public WithdrawRequestsService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration);
    }

    public WithdrawRequestResponse find(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_URL, id)).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(WithdrawRequestResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error finding withdraw request with id: " + id, ResponseStatus, ResponseText);
        }
    }

    public WithdrawRequestsResponse findAll() throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(FIND_ALL_URL).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(WithdrawRequestsResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error finding withdraw requests!", ResponseStatus, ResponseText);
        }
    }

    public WithdrawConciliationsResponse findAllWithdrawConciliations(String params) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(WITHDRAW_CONCILIATIONS_URL, params)).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(WithdrawConciliationsResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error finding withdraw conciliations!", ResponseStatus, ResponseText);
        }
    }

}
