package com.iugu.model.subscription.response;

import com.iugu.components.Jackson;
import com.iugu.enums.PayableWith;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionResponseTest {

    @Test
    @DisplayName("SubscriptionResponse: Should deserialize payable_with from list")
    void testDeserializationPayableWithFromList() {
        String json = "{\n" +
                "  \"payable_with\": [\n" +
                "    \"all\"\n" +
                "  ]\n" +
                "}";
        SubscriptionResponse subscription = Assertions.assertDoesNotThrow(() -> Jackson.getInstance().readValue(json, SubscriptionResponse.class));
        Assertions.assertNotNull(subscription.getPayableWiths());
        Assertions.assertEquals(1, subscription.getPayableWiths().size());
        Assertions.assertEquals(PayableWith.ALL, subscription.getPayableWiths().get(0));
    }

    @Test
    @DisplayName("SubscriptionResponse: Should deserialize payable_with from string")
    void testDeserializationPayableWithFromString() {
        String json = "{\n" +
                "  \"payable_with\": \"all\"\n" +
                "}";
        SubscriptionResponse subscription = Assertions.assertDoesNotThrow(() -> Jackson.getInstance().readValue(json, SubscriptionResponse.class));
        Assertions.assertNotNull(subscription.getPayableWiths());
        Assertions.assertEquals(1, subscription.getPayableWiths().size());
        Assertions.assertEquals(PayableWith.ALL, subscription.getPayableWiths().get(0));
    }
}