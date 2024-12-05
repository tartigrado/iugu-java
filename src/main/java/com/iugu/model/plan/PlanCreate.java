package com.iugu.model.plan;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.PayableWith;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class PlanCreate {

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class Feature {
        private String name;
        private String identifier;
        private Integer value;
    }

    private String name;
    private String identifier;
    private Integer interval;
    @JsonProperty("interval_type")
    private String intervalType;
    @JsonProperty("value_cents")
    private Integer valueCents;
    @JsonProperty("payable_with")
    private List<PayableWith> payableWith;
    private List<Feature> features;
    @JsonProperty("billing_days")
    private Integer billingDays;
    @JsonProperty("max_cycles")
    private Integer maxCycles;
    @JsonProperty("invoice_max_installments")
    private Integer invoiceMaxInstallments;

}
