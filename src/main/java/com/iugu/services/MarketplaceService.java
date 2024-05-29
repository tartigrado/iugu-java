package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.components.ClientWrapper;
import com.iugu.exceptions.IuguException;
import com.iugu.model.MarketPlace;
import com.iugu.responses.AccountCreationResponse;
import com.iugu.responses.MarketPlacesResponse;
import com.iugu.services.generic.GenericService;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MarketplaceService extends GenericService {
    private final String CREATE_ACCOUNT_URL = IuguConfiguration.url("/marketplace/create_account");
    private final String FIND_ALL_URL = IuguConfiguration.url("/marketplace");

    public MarketplaceService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration);
    }

    public AccountCreationResponse createAccount(MarketPlace marketPlace) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(CREATE_ACCOUNT_URL).request().post(Entity.entity(marketPlace, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(AccountCreationResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error creating account!", ResponseStatus, ResponseText);
        }
    }

    public MarketPlacesResponse findAll() throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(FIND_ALL_URL).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(MarketPlacesResponse.class);

            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error finding MarketPlaces!", ResponseStatus, ResponseText);
        }
    }
}
