package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.responses.FinancialTransactionRequestIResponse;

import javax.ws.rs.core.Response;

public class FinancialTransactionRequestService {

    private IuguConfiguration iugu;
    private final String FIND_ALL_URL = IuguConfiguration.url("/financial_transaction_requests");

    public FinancialTransactionRequestService(IuguConfiguration iugu) {
        this.iugu = iugu;
    }

    public FinancialTransactionRequestIResponse findAll() throws IuguException {
        Response response = this.iugu.getNewClient().target(FIND_ALL_URL).request().get();
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
