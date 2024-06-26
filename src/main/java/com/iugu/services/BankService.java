package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.components.ClientWrapper;
import com.iugu.exceptions.IuguException;
import com.iugu.model.BankAddress;
import com.iugu.responses.BankAddressVerificationResponse;
import com.iugu.responses.BankVerificationResponse;
import com.iugu.services.generic.GenericService;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class BankService extends GenericService {
    private final String ADD_URL = IuguConfiguration.url("/bank_verification");
    private final String VERIFICATION_URL = IuguConfiguration.url("/bank_verification");

    public BankService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration);
    }

    public BankVerificationResponse add(BankAddress bankAddress) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(ADD_URL).request().post(Entity.entity(bankAddress, MediaType.APPLICATION_JSON));
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(BankVerificationResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error add bank address!", ResponseStatus, ResponseText);
        }
    }

    public List<BankAddressVerificationResponse> verification() throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(VERIFICATION_URL).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(new GenericType<List<BankAddressVerificationResponse>>() {
                });

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error verifying insertion of bank address!", ResponseStatus, ResponseText);
        }
    }
}
