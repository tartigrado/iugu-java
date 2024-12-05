package com.iugu.services.subscription;

import com.iugu.model.subscription.*;
import com.iugu.model.subscription.response.SimulateChangePlanResponse;
import com.iugu.model.subscription.response.SubscriptionResponse;
import com.iugu.model.subscription.response.SubscriptionsResponse;

public interface SubscriptionService {
    SubscriptionsResponse listSubscriptions(SubscriptionFilter subscriptionFilter);

    SubscriptionResponse createSubscription(SubscriptionCreate subscription);

    SubscriptionResponse activateSubscription(String id);

    SubscriptionResponse suspendSubscription(String id);

    SimulateChangePlanResponse simulateChangePlan(String id, String planIdentifier);

    SubscriptionResponse changePlan(String id, String planIdentifier, ChangePlan changePlan);

    SubscriptionResponse addCredits(String id, AddRemoveCredit addCredit);

    SubscriptionResponse removeCredits(String id, AddRemoveCredit addRemoveCredit);

    SubscriptionResponse getSubscription(String id);

    SubscriptionResponse updateSubscription(String id, SubscriptionUpdate subscription);

    SubscriptionResponse deleteSubscription(String id);
}
