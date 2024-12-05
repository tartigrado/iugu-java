package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Transfer;
import com.iugu.responses.TransferResponse;
import com.iugu.responses.TransfersResponse;
import com.iugu.services.generic.GenericRsaService;
import com.iugu.services.signature.ValidateSignatureServiceImpl;
import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.Response;

public class TransferService extends GenericRsaService {
    private final static String TRANSFER_URL = "/transfers";
    private final String FIND_URL = IuguConfiguration.url("/transfers/%s");
    private final String FIND_ALL_URL = IuguConfiguration.url("/transfers");
    private final String FIND_PARAMS_URL = IuguConfiguration.url("/transfers?%s");

    public TransferService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration, new ValidateSignatureServiceImpl(iuguConfiguration));
    }

    public TransferResponse transfer(Transfer transfer) throws IuguException {
        transfer = getIugu().withToken(transfer);
        return requestWithSignature(HttpMethod.POST, TRANSFER_URL, transfer, TransferResponse.class);
    }

    public TransferResponse find(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_URL, id)).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(TransferResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error finding transfer with id: " + id, ResponseStatus, ResponseText);
        }
    }

    public TransfersResponse findAll(String params) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_PARAMS_URL, params)).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(TransfersResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error finding transfers!", ResponseStatus, ResponseText);
        }
    }

}
