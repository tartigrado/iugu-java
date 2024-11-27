package com.iugu.services.receivables;

import com.iugu.IuguConfiguration;
import com.iugu.components.HttpClientManager;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.receivables.AnticipationSimulation;
import com.iugu.model.receivables.ReceivablesFilter;
import com.iugu.model.receivables.TransactionAdvance;
import com.iugu.model.receivables.response.AnticipationSimulationResponse;
import com.iugu.model.receivables.response.CheckAdvanceResponse;
import com.iugu.model.receivables.response.ReceivablesResponse;
import com.iugu.model.receivables.response.TransactionAdvanceResponse;
import jakarta.ws.rs.WebApplicationException;

public final class ReceivablesServiceImpl implements ReceivablesService {
    private final ReceivablesService proxy;

    public ReceivablesServiceImpl(
            IuguConfiguration iuguConfiguration
    ) {
        this.proxy = HttpClientManager.proxy(ReceivablesServiceProxy.class, iuguConfiguration.authenticator());
    }

    @Override
    public ReceivablesResponse listReceivables(ReceivablesFilter filter) {
        try {
            return proxy.listReceivables(filter);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public TransactionAdvanceResponse transactionAdvance(TransactionAdvance advance) {
        try {
            return proxy.transactionAdvance(advance);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public void createAnticipationSimulation(AnticipationSimulation simulation) {
        try {
            proxy.createAnticipationSimulation(simulation);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public AnticipationSimulationResponse checkAnticipationSimulation() {
        try {
            return proxy.checkAnticipationSimulation();
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public void approveAdvance() {
        try {
            proxy.approveAdvance();
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public CheckAdvanceResponse checkAdvanceResponse() {
        try {
            return proxy.checkAdvanceResponse();
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }
}
