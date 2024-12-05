package com.iugu.model.plan.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class PlansResponse {

    private Integer totalItems;
    private List<PlanResponse> items;

    @JsonIgnore
    public PlanResponse first() {
        return items.get(0);
    }

    @JsonIgnore
    public PlanResponse findPlanWithAllFeatures(Collection<String> featuresIdentifier) {
        return items.stream()
                .filter(plan -> plan.getFeatures().stream().allMatch(feature -> featuresIdentifier.contains(feature.getIdentifier())))
                .findFirst()
                .orElse(null);
    }

    @JsonIgnore
    public PlanResponse findPlanById(String planId) {
        return items.stream()
                .filter(plan -> planId.equals(plan.getId()))
                .findFirst()
                .orElse(null);
    }

    @JsonIgnore
    public PlanResponse findPlanByIdentifier(String planIdentifier) {
        return items.stream()
                .filter(plan -> planIdentifier.equals(plan.getIdentifier()))
                .findFirst()
                .orElse(null);
    }

    @JsonIgnore
    public PlanResponse findPlanByName(String planName) {
        return items.stream()
                .filter(plan -> planName.equals(plan.getName()))
                .findFirst()
                .orElse(null);
    }

}
