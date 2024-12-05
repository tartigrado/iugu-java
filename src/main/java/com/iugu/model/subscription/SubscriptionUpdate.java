package com.iugu.model.subscription;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.iugu.IuguConstants;
import com.iugu.enums.PayableWith;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class SubscriptionUpdate {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static final class CustomVariable {
        private String name;
        private String value;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static final class SubItem {
        private String id;
        private String description;
        private Integer priceCents;
        private Integer quantity;
        private Boolean recurrent;
        @JsonProperty("_destroy")
        private Boolean destroy;
    }

    @JsonProperty("plan_identifier")
    private String planIdentifier;
    @JsonProperty("customer_id")
    private String customerId;
    @JsonProperty("expires_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = IuguConstants.DATE_FORMAT, locale = "pt-BR", timezone = IuguConstants.TIME_ZONE)
    private Date expiresAt;
    @JsonProperty("ignore_due_email")
    private Boolean ignoreDueEmail;
    @JsonProperty("payable_with")
    private List<PayableWith> payableWith;
    @JsonProperty("credits_based")
    private Boolean creditsBased;
    @JsonProperty("price_cents")
    private Integer priceCents;
    @JsonProperty("credits_cycle")
    private Integer creditsCycle;
    @JsonProperty("credits_min")
    private Integer creditsMin;
    private List<SubItem> subitems;
    @JsonProperty("custom_variables")
    private List<CustomVariable> customVariables;
    @JsonProperty("two_step")
    private Boolean twoStep;
    private Boolean suspended;
    @JsonProperty("skip_charge")
    private Boolean skipCharge;
    @JsonProperty("suspend_on_invoice_expired")
    private Boolean suspendOnInvoiceExpired;
    @JsonProperty("soft_descriptor_light")
    private String softDescriptorLight;

}
