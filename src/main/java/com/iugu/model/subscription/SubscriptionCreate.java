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

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class SubscriptionCreate {

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
        private String description;
        private Integer priceCents;
        private Integer quantity;
        private Boolean recurrent;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static final class Split {
        private String recipientAccountId;
        private Integer cents;
        private BigDecimal percent;
        private Integer creditCardCents;
        private BigDecimal creditCardPercent;
        private Integer bankSlipCents;
        private BigDecimal bankSlipPercent;
        private Integer pixCents;
        private BigDecimal pixPercent;
        private Boolean allowAggregated;
        private Date createdAt;
        private Date updatedAt;
        private Integer creditCard1xCents;
        private Integer creditCard2xCents;
        private Integer creditCard3xCents;
        private Integer creditCard4xCents;
        private Integer creditCard5xCents;
        private Integer creditCard6xCents;
        private Integer creditCard7xCents;
        private Integer creditCard8xCents;
        private Integer creditCard9xCents;
        private Integer creditCard10xCents;
        private Integer creditCard11xCents;
        private Integer creditCard12xCents;
        private BigDecimal creditCard1xPercent;
        private BigDecimal creditCard2xPercent;
        private BigDecimal creditCard3xPercent;
        private BigDecimal creditCard4xPercent;
        private BigDecimal creditCard5xPercent;
        private BigDecimal creditCard6xPercent;
        private BigDecimal creditCard7xPercent;
        private BigDecimal creditCard8xPercent;
        private BigDecimal creditCard9xPercent;
        private BigDecimal creditCard10xPercent;
        private BigDecimal creditCard11xPercent;
        private BigDecimal creditCard12xPercent;
    }

    @JsonProperty("plan_identifier")
    private String planIdentifier;
    @JsonProperty("customer_id")
    private String customerId;
    @JsonProperty("expires_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = IuguConstants.DATE_FORMAT, locale = "pt-BR", timezone = IuguConstants.TIME_ZONE)
    private Date expiresAt;
    private List<Split> splits;
    @JsonProperty("only_on_charge_success")
    private Boolean onlyOnChargeSuccess;
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
    @JsonProperty("suspend_on_invoice_expired")
    private Boolean suspendOnInvoiceExpired;
    @JsonProperty("only_charge_on_due_date")
    private Boolean onlyChargeOnDueDate;
    @JsonProperty("soft_descriptor_light")
    private String softDescriptorLight;
    @JsonProperty("return_url")
    private String returnUrl;
}
