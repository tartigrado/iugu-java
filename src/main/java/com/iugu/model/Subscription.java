package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.iugu.enums.PayableWith;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

    public Subscription() {
    }

    public Subscription(String customerId) {
        this.customerId = customerId;

    }

    @JsonProperty("customer_id")
    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    @JsonProperty("plan_identifier")
    public String planIdentifier;

    @JsonProperty("expires_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date expiresAt;

    @JsonProperty("only_on_charge_sucess")
    public String onlyOnChargeSucess;

    @JsonProperty("payable_with")
    public List<PayableWith> payableWith;

    @JsonProperty("credits_based")
    public boolean creditsBased;

    @JsonProperty("price_cents")
    public int priceCents;

    @JsonProperty("credits_cycle")
    public int creditsCycle;

    @JsonProperty("credits_min")
    public int creditsMin;

    @JsonProperty("custom_variables")
    public List<CustomVariable> customVariables;

    @JsonProperty("subitems")
    public List<SubItem> subItems;

    @JsonProperty("skip_charge")
    public boolean skipCharge;

    public String getPlanIdentifier() {
        return planIdentifier;
    }

    public void setPlanIdentifier(String planIdentifier) {
        this.planIdentifier = planIdentifier;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getOnlyOnChargeSucess() {
        return onlyOnChargeSucess;
    }

    public void setOnlyOnChargeSucess(String onlyOnChargeSucess) {
        this.onlyOnChargeSucess = onlyOnChargeSucess;
    }

    public List<PayableWith> getPayableWith() {
        return payableWith;
    }

    public void setPayableWith(List<PayableWith> payableWith) {
        this.payableWith = payableWith;
    }

    public boolean isCreditsBased() {
        return creditsBased;
    }

    public void setCreditsBased(boolean creditsBased) {
        this.creditsBased = creditsBased;
    }

    public int getPriceCents() {
        return priceCents;
    }

    public void setPriceCents(int priceCents) {
        this.priceCents = priceCents;
    }

    public int getCreditsCycle() {
        return creditsCycle;
    }

    public void setCreditsCycle(int creditsCycle) {
        this.creditsCycle = creditsCycle;
    }

    public int getCreditsMin() {
        return creditsMin;
    }

    public void setCreditsMin(int creditsMin) {
        this.creditsMin = creditsMin;
    }

    public List<CustomVariable> getCustomVariables() {
        return customVariables;
    }

    public void setCustomVariables(List<CustomVariable> customVariables) {
        this.customVariables = customVariables;
    }

    public List<SubItem> getSubItems() {
        return subItems;
    }

    public void setSubItems(List<SubItem> subItems) {
        this.subItems = subItems;
    }

    public boolean isSkipCharge() {
        return skipCharge;
    }

    public void setSkipCharge(boolean skipCharge) {
        this.skipCharge = skipCharge;
    }
}
