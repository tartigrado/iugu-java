package com.iugu.services.plan;

import com.iugu.IuguConfiguration;
import com.iugu.components.HttpClientManager;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.plan.PlanCreate;
import com.iugu.model.plan.PlanFilter;
import com.iugu.model.plan.PlanUpdate;
import com.iugu.model.plan.response.PlanResponse;
import com.iugu.model.plan.response.PlansResponse;
import jakarta.ws.rs.WebApplicationException;

public final class PlanServiceImpl implements PlanService {
    private final PlanService proxy;

    public PlanServiceImpl(IuguConfiguration configuration) {
        this.proxy = HttpClientManager.proxy(PlanServiceProxy.class, configuration.authenticator());
    }

    @Override
    public PlansResponse listPlans(PlanFilter filter) {
        try {
            return proxy.listPlans(filter);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public PlanResponse getPlan(String id) {
        try {
            return proxy.getPlan(id);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public PlanResponse getPlanByIdentifier(String identifier) {
        try {
            return proxy.getPlanByIdentifier(identifier);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public PlanResponse createPlan(PlanCreate plan) {
        try {
            return proxy.createPlan(plan);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public PlanResponse updatePlan(String id, PlanUpdate plan) {
        try {
            return proxy.updatePlan(id, plan);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public PlanResponse deletePlan(String id) {
        try {
            return proxy.deletePlan(id);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }
}
