package com.iugu.services;

import com.iugu.IuguConfiguration;
import jakarta.ws.rs.client.Client;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Credit;
import com.iugu.model.Subscription;
import com.iugu.model.subscription.response.SimulateChangePlanResponse;
import com.iugu.model.subscription.response.SubscriptionResponse;
import com.iugu.model.subscription.response.SubscriptionsResponse;
import com.iugu.services.generic.GenericService;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class SubscriptionService extends GenericService {
    private final String CREATE_URL = IuguConfiguration.url("/subscriptions");
    private final String FIND_URL = IuguConfiguration.url("/subscriptions/%s");
    private final String CHANGE_URL = IuguConfiguration.url("/subscriptions/%s");
    private final String REMOVE_URL = IuguConfiguration.url("/subscriptions/%s");
    private final String SUSPEND_URL = IuguConfiguration.url("/subscriptions/%s/suspend");
    private final String ACTIVATE_URL = IuguConfiguration.url("/subscriptions/%s/activate");
    private final String CHANGE_SUBSCRIPTION_PLAN_URL = IuguConfiguration.url("/subscriptions/%s/change_plan/%s");
    private final String SIMULATE_CHANGE_SUBSCRIPTION_PLAN_URL = IuguConfiguration.url("/subscriptions/%s/change_plan_simulation/%s");
    private final String ADD_CREDITS_URL = IuguConfiguration.url("/subscriptions/%s/add_credits");
    private final String REMOVE_CREDITS_URL = IuguConfiguration.url("/subscriptions/%s/remove_credits");
    private final String FIND_ALL_URL = IuguConfiguration.url("/subscriptions");
    private final String FIND_PARAMS_URL = IuguConfiguration.url("/subscriptions?%s");

    public SubscriptionService(IuguConfiguration iuguConfiguration) {
        super(iuguConfiguration);
    }

    public SubscriptionResponse create(Subscription subscription) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(CREATE_URL).request().post(Entity.entity(subscription, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(SubscriptionResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error creating subscription!", ResponseStatus, ResponseText);
        }
    }

    public SubscriptionResponse find(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_URL, id)).request().get();

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(SubscriptionResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error finding subscription!", ResponseStatus, ResponseText);
        }
    }

    public SubscriptionResponse change(String id, Subscription subscription) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(CHANGE_URL, id)).request().put(Entity.entity(subscription, MediaType.APPLICATION_JSON));
            int status = response.getStatus();
            String text = null;

            if (status == 200) {
                return response.readEntity(SubscriptionResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                text = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error changing subscription!", status, text);
        }
    }

    public SubscriptionResponse remove(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(REMOVE_URL, id)).request().delete();

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(SubscriptionResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error removing subscription!", ResponseStatus, ResponseText);
        }
    }

    public SubscriptionResponse suspend(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(SUSPEND_URL, id)).request().post(null);

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(SubscriptionResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error suspending subscription!", ResponseStatus, ResponseText);
        }
    }

    public SubscriptionResponse activate(String id) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(ACTIVATE_URL, id)).request().post(null);

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(SubscriptionResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error activating subscription!", ResponseStatus, ResponseText);
        }
    }

    public SubscriptionResponse changePlan(String id, String planIdentifier) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(CHANGE_SUBSCRIPTION_PLAN_URL, id, planIdentifier)).request().post(null);

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(SubscriptionResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error changing subscription plan!", ResponseStatus, ResponseText);
        }
    }

    public SimulateChangePlanResponse simulateChangePlan(String id, String planIdentifier) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(SIMULATE_CHANGE_SUBSCRIPTION_PLAN_URL, id, planIdentifier)).request().get();

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(SimulateChangePlanResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error changing subscription plan!", ResponseStatus, ResponseText);
        }
    }

    public SubscriptionResponse addCredits(String id, Credit credit) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(ADD_CREDITS_URL, id)).request().put(Entity.entity(credit, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(SubscriptionResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error adding credits to subscription!", ResponseStatus, ResponseText);
        }
    }

    public SubscriptionResponse removeCredits(String id, Credit credit) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(REMOVE_CREDITS_URL, id)).request().put(Entity.entity(credit, MediaType.APPLICATION_JSON));

            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(SubscriptionResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error removing credits from subscription!", ResponseStatus, ResponseText);
        }
    }

    public SubscriptionsResponse findByParams(String params) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            Response response = client.target(String.format(FIND_PARAMS_URL, params)).request().get();
            int ResponseStatus = response.getStatus();
            String ResponseText = null;

            if (ResponseStatus == 200) {
                return response.readEntity(SubscriptionsResponse.class);
            }

            // Error Happened
            if (response.hasEntity()) {
                ResponseText = response.readEntity(String.class);
            }

            response.close();

            throw new IuguException("Error finding subscriptions!", ResponseStatus, ResponseText);
        }
    }

}
