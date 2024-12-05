package com.iugu.model.subscription.response;

import com.fasterxml.jackson.annotation.*;
import com.iugu.enums.PayableWith;
import com.iugu.model.invoice.response.InvoiceResponse;
import com.iugu.responses.SubItemResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class SubscriptionResponse {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class FeatureResponse {
        private String name;
        private Integer value;
        @JsonAnySetter
        private Map<String, Object> any;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class FeatureSubscriptionResponse {
        private String identifier;
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public final static class LogResponse {
        private String id;
        private String description;
        private String notes;
        @JsonProperty("subscription_changes")
        private String subscriptionChanges;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonAnySetter
        private Map<String, Object> any;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class CustomVariableResponse {
        private String name;
        private String value;
    }

    private String id;
    @JsonProperty("credits_cycle")
    private Integer creditsCycle;
    private Boolean suspended;
    @JsonProperty("plan_identifier")
    private String planIdentifier;
    @JsonProperty("price_cents")
    private Integer priceCents;
    private String currency;
    @JsonProperty("payable_with")
    private List<PayableWith> payableWiths;
    //TODO Features
    @JsonProperty("expires_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "America/Sao_Paulo")
    private Date expiresAt;
    @JsonProperty("customer_name")
    private String customerName;
    @JsonProperty("customer_email")
    private String customerEmail;
    @JsonProperty("cycled_at")
    private Date cycledAt;
    @JsonProperty("credits_min")
    private Integer creditsMin;
    //TODO Credits Cycle
    @JsonProperty("customer_id")
    private String customerId;
    @JsonProperty("plan_name")
    private String planName;
    @JsonProperty("customer_ref")
    private String customerRef;
    @JsonProperty("plan_ref")
    private String planRef;
    private Boolean active;
    @JsonProperty("in_trial")
    private Boolean inTrial;
    @JsonProperty("return_url")
    private String returnUrl;
    @JsonProperty("split_id")
    private String splitId;
    private Integer credits;
    @JsonProperty("ignore_due_email")
    private Boolean ignoreDueEmail;
    @JsonProperty("max_cycles")
    private Integer maxCycles;
    @JsonProperty("cycles_count")
    private Integer cyclesCount;
    @JsonProperty("two_step")
    private Boolean twoStep;
    @JsonProperty("suspend_on_invoice_expired")
    private Boolean suspendOnInvoiceExpired;
    @JsonProperty("credits_based")
    private Boolean creditsBased;
    @JsonProperty("recent_invoices")
    private List<InvoiceResponse> recentInvoices;
    @JsonProperty("features")
    private Map<String, FeatureResponse> features;
    @JsonProperty("features_revgas")
    private List<FeatureSubscriptionResponse> featuresRevgas;
    private List<SubItemResponse> subitems;
    private List<LogResponse> logs;
    @JsonProperty("custom_variables")
    private List<CustomVariableResponse> customVariables;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonAnySetter
    private Map<String, Object> any;

    public void setFeatures(Map<String, FeatureResponse> features) {
        this.features = features;
        Optional.ofNullable(features)
                .ifPresent(it -> setFeaturesRevgas(it.keySet().stream().map(feat -> new FeatureSubscriptionResponse(feat, features.get(feat).getName())).toList()));
    }

    @JsonIgnore
    public SubItemResponse getSubItemById(String id) {
        return subitems.stream().filter(it -> Objects.equals(id, it.getId())).findFirst().orElse(null);
    }

    @JsonIgnore
    public SubItemResponse getSubItemByDescription(String description) {
        return subitems.stream().filter(it -> Objects.equals(description, it.getDescription())).findFirst().orElse(null);
    }
}
