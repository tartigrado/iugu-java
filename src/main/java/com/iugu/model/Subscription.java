package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.PayableWith;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

    @JsonProperty("plan_identifier")
    protected String planIdentifier;
    @JsonProperty("expires_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date expiresAt;
    @JsonProperty("only_on_charge_sucess")
    protected String onlyOnChargeSucess;
    @JsonProperty("payable_with")
    protected List<PayableWith> payableWith;
    @JsonProperty("credits_based")
    protected boolean creditsBased;
    @JsonProperty("price_cents")
    protected int priceCents;
    @JsonProperty("credits_cycle")
    protected int creditsCycle;
    @JsonProperty("credits_min")
    protected int creditsMin;
    @JsonProperty("custom_variables")
    protected List<CustomVariable> customVariables;
    @JsonProperty("subitems")
    protected List<SubItem> subItems;
    @JsonProperty("skip_charge")
    protected boolean skipCharge;
    @JsonProperty("customer_id")
    private String customerId;

    public Subscription(String customerId) {
        this.customerId = customerId;
    }

}
