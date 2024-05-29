package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.components.ClientWrapper;
import com.iugu.exceptions.IuguException;
import com.iugu.model.TransactionAdvance;
import com.iugu.responses.FinancialTransactionRequestIResponse;
import com.iugu.responses.TransactionAdvanceResponse;
import com.iugu.services.generic.GenericService;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class FinancialTransactionRequestService extends GenericService {
    private final String FIND_ALL_URL = IuguConfiguration.url("/financial_transaction_requests");
    private final String ADVANCE_URL = IuguConfiguration.url("/financial_transaction_requests/advance");

    public FinancialTransactionRequestService(IuguConfiguration iugu) {
        super(iugu);
    }

    public FinancialTransactionRequestIResponse findAll() throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(FIND_ALL_URL).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;
            if (ResponseStatus == 200) {
                return response.readEntity(FinancialTransactionRequestIResponse.class);
            }
            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }
            response.close();
            throw new IuguException("Error finding financial transactions", ResponseStatus, ResponseText);
        }
    }

    public TransactionAdvanceResponse advance(TransactionAdvance transactionAdvance) throws IuguException {
        try (ClientWrapper client = getIugu().getNewClient()) {
            Response response = client.target(ADVANCE_URL).request().post(Entity.entity(transactionAdvance, MediaType.APPLICATION_JSON));
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200)
                return response.readEntity(TransactionAdvanceResponse.class);

            // Error Happened
            if (response.hasEntity())
                ResponseText = response.readEntity(String.class);

            response.close();

            throw new IuguException("Error on transaction advance!", ResponseStatus, ResponseText);
        }
    }

}
