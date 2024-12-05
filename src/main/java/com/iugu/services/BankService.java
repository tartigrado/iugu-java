package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.BankAddress;
import com.iugu.responses.BankAddressVerificationResponse;
import com.iugu.responses.BankVerificationResponse;
import com.iugu.services.generic.GenericRsaService;
import com.iugu.services.signature.ValidateSignatureServiceImpl;
import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class BankService extends GenericRsaService {
    private final static String ADD_URL = "/bank_verification";
    private final String VERIFICATION_URL = IuguConfiguration.url("/bank_verification");

    public BankService(IuguConfiguration iugu) {
        super(iugu, new ValidateSignatureServiceImpl(iugu));
    }

    public BankVerificationResponse add(BankAddress bankAddress) throws IuguException {
        bankAddress = getIugu().withToken(bankAddress);
        return requestWithSignature(HttpMethod.POST, ADD_URL, bankAddress, BankVerificationResponse.class);
    }

    public List<BankAddressVerificationResponse> verification() throws IuguException {
        try (Client client = getIugu().getNewClient()) {
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
