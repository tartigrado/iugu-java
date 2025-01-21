package com.iugu.services.plan;

import com.iugu.Mocks;
import com.iugu.model.plan.PlanCreate;
import com.iugu.model.plan.PlanIntervalType;
import com.iugu.model.plan.PlanUpdate;
import com.iugu.model.plan.response.PlanResponse;
import com.iugu.model.plan.response.PlansResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PlanServiceImplTest {

    PlanService planService = new PlanServiceImpl(Mocks.mockConfiguration());

    @Test
    @DisplayName("PlanService: should list all plans")
    void testListPlans() {
        PlansResponse plansResponse = planService.listPlans(null);
        Assertions.assertNotNull(plansResponse);
        Assertions.assertNotNull(plansResponse.getTotalItems());
        Assertions.assertNotNull(plansResponse.getItems());
        Assertions.assertFalse(plansResponse.getItems().isEmpty());

        Assertions.assertNotNull(plansResponse.first());
        Assertions.assertNotNull(plansResponse.findPlanById("9AAD62E84AD249809CF03CFD8B65FD41"));
        Assertions.assertNotNull(plansResponse.findPlanByIdentifier("teste"));
        Assertions.assertNotNull(plansResponse.findPlanByName("Teste"));
        Assertions.assertNotNull(plansResponse.findPlanWithAllFeatures(List.of("teste")));
    }

    @Test
    @DisplayName("PlanService: should get a plan by id")
    void testGetPlan() {
        PlanResponse response = planService.getPlan("9AAD62E84AD249809CF03CFD8B65FD41");
        Assertions.assertNotNull(response.getId());
        Assertions.assertNull(response.getAny());
        response.getFeatures().forEach(it -> Assertions.assertNull(it.getAny()));
        response.getPrices().forEach(it -> Assertions.assertNull(it.getAny()));
    }

    @Test
    @DisplayName("PlanService: should get a plan by identifier")
    void testGetPlanByIdentifier() {
        PlanResponse response = planService.getPlanByIdentifier("teste");
        Assertions.assertNotNull(response.getId());
        Assertions.assertNull(response.getAny());
        response.getFeatures().forEach(it -> Assertions.assertNull(it.getAny()));
        response.getPrices().forEach(it -> Assertions.assertNull(it.getAny()));
    }

    @Test
    @DisplayName("PlanService: should create, update and delete a plan")
    void testCreateUpdateDeletePlan() {
        PlanResponse createResponse = planService.createPlan(PlanCreate
                .builder()
                .name("Teste 2")
                .identifier("teste2")
                .interval(1)
                .intervalType(PlanIntervalType.MONTHS)
                .valueCents(1000)
                .features(List.of(
                        PlanCreate.Feature
                                .builder()
                                .name("Feature 1")
                                .identifier("feature1")
                                .value(500)
                                .build(),
                        PlanCreate.Feature
                                .builder()
                                .name("Feature 2")
                                .identifier("feature2")
                                .value(500)
                                .build()
                ))
                .build());
        Assertions.assertNotNull(createResponse.getId());
        Assertions.assertNull(createResponse.getAny());
        Assertions.assertEquals("Teste 2", createResponse.getName());
        createResponse.getFeatures().forEach(it -> Assertions.assertNull(it.getAny()));
        createResponse.getPrices().forEach(it -> Assertions.assertNull(it.getAny()));

        PlanResponse updateResponse = planService.updatePlan(createResponse.getId(), PlanUpdate
                .builder()
                .name("Teste 2 edit")
                .features(List.of(
                        PlanUpdate.Feature
                                .builder()
                                .id(createResponse.getFeatureByIdentifier("feature1").getId())
                                .name("Feature 1 edit")
                                .build()
                ))
                .build());
        Assertions.assertNotNull(updateResponse.getId());
        Assertions.assertNull(updateResponse.getAny());
        Assertions.assertEquals("Teste 2 edit", updateResponse.getName());
        Assertions.assertEquals("Feature 1 edit", updateResponse.getFeatureByIdentifier("feature1").getName());

        Assertions.assertFalse(updateResponse.payableWiths().isEmpty());
        updateResponse.getFeatures().forEach(it -> Assertions.assertNull(it.getAny()));
        updateResponse.getPrices().forEach(it -> Assertions.assertNull(it.getAny()));

        PlanResponse deleteResponse = planService.deletePlan(updateResponse.getId());
        Assertions.assertNotNull(deleteResponse.getId());
        Assertions.assertNull(deleteResponse.getAny());
        deleteResponse.getFeatures().forEach(it -> Assertions.assertNull(it.getAny()));
        deleteResponse.getPrices().forEach(it -> Assertions.assertNull(it.getAny()));
    }

}