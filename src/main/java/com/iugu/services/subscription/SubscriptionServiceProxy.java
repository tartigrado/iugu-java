package com.iugu.services.subscription;

import com.iugu.model.subscription.*;
import com.iugu.model.subscription.response.SimulateChangePlanResponse;
import com.iugu.model.subscription.response.SubscriptionResponse;
import com.iugu.model.subscription.response.SubscriptionsResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("")
public interface SubscriptionServiceProxy extends SubscriptionService {

    @Override
    @GET
    @Path("/subscriptions")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SubscriptionsResponse listSubscriptions(@BeanParam SubscriptionFilter subscriptionFilter);

    @Override
    @POST
    @Path("/subscriptions")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SubscriptionResponse createSubscription(SubscriptionCreate subscription);

    @Override
    @GET
    @Path("/subscriptions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SubscriptionResponse getSubscription(@PathParam("id") String id);

    @Override
    @PUT
    @Path("/subscriptions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SubscriptionResponse updateSubscription(@PathParam("id") String id, SubscriptionUpdate subscription);

    @Override
    @DELETE
    @Path("/subscriptions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SubscriptionResponse deleteSubscription(@PathParam("id") String id);

    @Override
    @POST
    @Path("/subscriptions/{id}/activate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SubscriptionResponse activateSubscription(@PathParam("id") String id);

    @Override
    @POST
    @Path("/subscriptions/{id}/suspend")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SubscriptionResponse suspendSubscription(@PathParam("id") String id);

    @Override
    @POST
    @Path("/subscriptions/{id}/change_plan/{planIdentifier}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SubscriptionResponse changePlan(@PathParam("id") String id, @PathParam("planIdentifier") String planIdentifier, ChangePlan changePlan);

    @Override
    @GET
    @Path("/subscriptions/{id}/simulate_change_plan/{planIdentifier}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SimulateChangePlanResponse simulateChangePlan(@PathParam("id") String id, @PathParam("planIdentifier") String planIdentifier);

    @Override
    @PUT
    @Path("/subscriptions/{id}/add_credits")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SubscriptionResponse addCredits(@PathParam("id") String id, AddRemoveCredit addCredit);

    @Override
    @PUT
    @Path("/subscriptions/{id}/remove_credits")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SubscriptionResponse removeCredits(@PathParam("id") String id, AddRemoveCredit addRemoveCredit);
}
