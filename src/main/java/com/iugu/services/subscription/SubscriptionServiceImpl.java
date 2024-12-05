package com.iugu.services.subscription;

import com.iugu.IuguConfiguration;
import com.iugu.components.HttpClientManager;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.subscription.*;
import com.iugu.model.subscription.response.SimulateChangePlanResponse;
import com.iugu.model.subscription.response.SubscriptionResponse;
import com.iugu.model.subscription.response.SubscriptionsResponse;
import jakarta.ws.rs.WebApplicationException;

public final class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionService proxy;

    public SubscriptionServiceImpl(IuguConfiguration configuration) {
        this.proxy = HttpClientManager.proxy(SubscriptionServiceProxy.class, configuration.authenticator());
    }

    @Override
    public SubscriptionsResponse listSubscriptions(SubscriptionFilter subscriptionFilter) {
        try {
            return proxy.listSubscriptions(subscriptionFilter);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public SubscriptionResponse createSubscription(SubscriptionCreate subscription) {
        try {
            return proxy.createSubscription(subscription);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public SubscriptionResponse activateSubscription(String id) {
        try {
            return proxy.activateSubscription(id);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public SubscriptionResponse suspendSubscription(String id) {
        try {
            return proxy.suspendSubscription(id);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public SubscriptionResponse getSubscription(String id) {
        try {
            return proxy.getSubscription(id);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public SubscriptionResponse updateSubscription(String id, SubscriptionUpdate subscription) {
        try {
            return proxy.updateSubscription(id, subscription);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public SubscriptionResponse deleteSubscription(String id) {
        try {
            return proxy.deleteSubscription(id);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public SubscriptionResponse changePlan(String id, String planIdentifier, ChangePlan changePlan) {
        try {
            return proxy.changePlan(id, planIdentifier, changePlan);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public SimulateChangePlanResponse simulateChangePlan(String id, String planIdentifier) {
        try {
            return proxy.simulateChangePlan(id, planIdentifier);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public SubscriptionResponse addCredits(String id, AddRemoveCredit addCredit) {
        try {
            return proxy.addCredits(id, addCredit);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }

    @Override
    public SubscriptionResponse removeCredits(String id, AddRemoveCredit addRemoveCredit) {
        try {
            return proxy.removeCredits(id, addRemoveCredit);
        } catch (WebApplicationException e) {
            throw IuguExceptionHandler.getException(e);
        }
    }
}
