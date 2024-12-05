package com.iugu.services.plan;

import com.iugu.model.plan.PlanCreate;
import com.iugu.model.plan.PlanFilter;
import com.iugu.model.plan.PlanUpdate;
import com.iugu.model.plan.response.PlanResponse;
import com.iugu.model.plan.response.PlansResponse;

public interface PlanService {
    PlansResponse listPlans(PlanFilter filter);

    PlanResponse getPlan(String id);

    PlanResponse getPlanByIdentifier(String identifier);

    PlanResponse createPlan(PlanCreate plan);

    PlanResponse updatePlan(String id, PlanUpdate plan);

    PlanResponse deletePlan(String id);
}
