package com.iugu.services.subscription;

import com.iugu.Mocks;
import com.iugu.model.subscription.SubscriptionCreate;
import com.iugu.model.subscription.SubscriptionUpdate;
import com.iugu.model.subscription.response.SubscriptionResponse;
import com.iugu.model.subscription.response.SubscriptionsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class SubscriptionServiceImplTest {

    SubscriptionService service = new SubscriptionServiceImpl(Mocks.mockConfiguration());

    @Test
    @DisplayName("SubscriptionService: should list subscriptions")
    void testListSubscriptions() {
        SubscriptionsResponse response = service.listSubscriptions(null);
        Assertions.assertNull(response.getAny());
        Assertions.assertNotNull(response.getTotalItems());
        Assertions.assertNotNull(response.getItems());
        Assertions.assertFalse(response.getItems().isEmpty());

        response.getItems().forEach(it -> {
            Assertions.assertNull(it.getAny());
        });
    }

    @Test
    @DisplayName("SubscriptionService: should create, update and delete subscription")
    void testCreateUpdateDeleteSubscription() {
        SubscriptionResponse response = service.createSubscription(SubscriptionCreate
                .builder()
                .customerId("9C2964F52DE747C384261DC7D236B1EC")
                .planIdentifier("teste")
                .subitems(List.of(
                        SubscriptionCreate.SubItem
                                .builder()
                                .description("Teste 1")
                                .quantity(1)
                                .priceCents(33)
                                .build(),
                        SubscriptionCreate.SubItem
                                .builder()
                                .description("Teste 2")
                                .quantity(1)
                                .priceCents(33)
                                .build(),
                        SubscriptionCreate.SubItem
                                .builder()
                                .description("Teste 3")
                                .quantity(1)
                                .priceCents(34)
                                .build()
                ))
                .build());

        Assertions.assertNotNull(response);
        Assertions.assertNull(response.getAny());
        Assertions.assertEquals(3, response.getSubitems().size());

        response = service.updateSubscription(response.getId(), SubscriptionUpdate
                .builder()
                .customerId("9C2964F52DE747C384261DC7D236B1EC")
                .subitems(List.of(
                        SubscriptionUpdate.SubItem
                                .builder()
                                .id(response.getSubItemByDescription("Teste 1").getId())
                                .priceCents(100)
                                .build(),
                        SubscriptionUpdate.SubItem
                                .builder()
                                .id(response.getSubItemByDescription("Teste 2").getId())
                                .destroy(true)
                                .build(),
                        SubscriptionUpdate.SubItem
                                .builder()
                                .id(response.getSubItemByDescription("Teste 3").getId())
                                .description("Teste 3")
                                .destroy(true)
                                .build()
                ))
                .build());

        Assertions.assertNotNull(response);
        Assertions.assertNull(response.getAny());
        Assertions.assertEquals(1, response.getSubitems().size());

        service.deleteSubscription(response.getId());
    }


}