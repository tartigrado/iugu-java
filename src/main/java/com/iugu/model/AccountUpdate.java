package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountUpdate {

    private String id;
    private String name;
    @JsonProperty("reply_to")
    private String replyTo;
    private Boolean fines;
    @JsonProperty("per_day_interest")
    private Boolean perDayInterest;
    @JsonProperty("late_payment_fine")
    private Integer latePaymentFine;
    @JsonProperty("subscriptions_billing_days")
    private Integer subscriptionsBillingDays;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public Boolean getFines() {
        return fines;
    }

    public void setFines(Boolean fines) {
        this.fines = fines;
    }

    public Boolean getPerDayInterest() {
        return perDayInterest;
    }

    public void setPerDayInterest(Boolean perDayInterest) {
        this.perDayInterest = perDayInterest;
    }

    public Integer getLatePaymentFine() {
        return latePaymentFine;
    }

    public void setLatePaymentFine(Integer latePaymentFine) {
        this.latePaymentFine = latePaymentFine;
    }

    public Integer getSubscriptionsBillingDays() {
        return subscriptionsBillingDays;
    }

    public void setSubscriptionsBillingDays(Integer subscriptionsBillingDays) {
        this.subscriptionsBillingDays = subscriptionsBillingDays;
    }

}
