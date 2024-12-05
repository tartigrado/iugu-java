package com.iugu.services.dunning;

import com.iugu.IuguConfiguration;
import com.iugu.components.HttpClientManager;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.dunning.ChangeDunningStep;
import com.iugu.model.dunning.DunningStep;
import jakarta.ws.rs.WebApplicationException;

import java.util.List;

public final class DunningStepsServiceImpl implements DunningStepsService {

    private final DunningStepsService proxy;

    public DunningStepsServiceImpl(
            IuguConfiguration iuguConfiguration
    ) {
        this.proxy = HttpClientManager.proxy(DunningStepsServiceProxy.class, iuguConfiguration.authenticator());
    }

    @Override
    public List<DunningStep> getDunningSteps() {
        try {
            return proxy.getDunningSteps();
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public List<DunningStep> changeDunningSteps(ChangeDunningStep change) {
        try {
            return proxy.changeDunningSteps(change);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }
}
