package com.iugu.model.plan.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.PayableWith;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class PlanResponse {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public final static class Feature {
        private String id;
        private String identifier;
        private Boolean important;
        private String name;
        @JsonProperty("plan_id")
        private String planId;
        private Integer position;
        private Integer value;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updated_at;
        @JsonAnySetter
        private Map<String, Object> any;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class Price {
        private String id;
        private String currency;
        @JsonProperty("plan_id")
        private String planId;
        @JsonProperty("value_cents")
        private Integer valueCents;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updated_at;
        @JsonAnySetter
        private Map<String, Object> any;
    }

    private String id;
    private String name;
    private String identifier;
    private String interval;
    @JsonProperty("interval_type")
    private String intervalType;
    private List<Price> prices;
    private List<Feature> features;
    @JsonProperty("max_cycles")
    private Integer maxCycles;
    @JsonProperty("invoice_max_installments")
    private Integer invoiceMaxInstallments;
    @JsonProperty("billing_days")
    private Integer billingDays;
    @JsonProperty("payable_with")
    private Object payableWith;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonAnySetter
    private Map<String, Object> any;

    @JsonIgnore
    public Feature getFeatureById(String id) {
        return features.stream().filter(f -> Objects.equals(id, f.getId())).findFirst().orElse(null);
    }

    @JsonIgnore
    public Feature getFeatureByIdentifier(String identifier) {
        return features.stream().filter(f -> Objects.equals(identifier, f.getIdentifier())).findFirst().orElse(null);
    }

    @JsonIgnore
    public List<PayableWith> payableWiths() {
        if (Objects.isNull(getPayableWith())) {
            return Collections.emptyList();
        }
        if (getPayableWith() instanceof String) {
            return List.of(PayableWith.getPayableWithByValue((String) getPayableWith()));
        } else if (getPayableWith() instanceof Collection<?>) {
            List<PayableWith> payableWiths = new ArrayList<>();
            for (Object o : (Collection<?>) getPayableWith()) {
                if (o instanceof String) {
                    payableWiths.add(PayableWith.getPayableWithByValue((String) o));
                }
            }
            return payableWiths;
        }
        return Collections.emptyList();
    }
}
