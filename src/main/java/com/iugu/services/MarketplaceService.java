package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.services.signature.ValidateSignatureServiceImpl;
import jakarta.ws.rs.client.Client;
import com.iugu.exceptions.IuguException;
import com.iugu.model.MarketPlace;
import com.iugu.model.account.response.AccountCreateResponse;
import com.iugu.responses.MarketPlacesResponse;
import com.iugu.services.generic.GenericRsaService;

import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.core.Response;

public class MarketplaceService extends GenericRsaService {
    private final static String CREATE_ACCOUNT_URL = "/marketplace/create_account";
    private final String FIND_ALL_URL = IuguConfiguration.url("/marketplace");

    public MarketplaceService(IuguConfiguration iugu) {
        super(iugu, new ValidateSignatureServiceImpl(iugu));
    }

    public AccountCreateResponse createAccount(MarketPlace marketPlace) throws IuguException {
        marketPlace = getIugu().withToken(marketPlace);
        return requestWithSignature(HttpMethod.POST, CREATE_ACCOUNT_URL, marketPlace, AccountCreateResponse.class);
    }

    public MarketPlacesResponse findAll() throws IuguException {
        try (Client client = getIugu().getNewClient()) {
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
