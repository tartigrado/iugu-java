package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountUpdate {

    protected String id;
    protected String name;
    @JsonProperty("reply_to")
    protected String replyTo;
    protected Boolean fines;
    @JsonProperty("per_day_interest")
    protected Boolean perDayInterest;
    @JsonProperty("late_payment_fine")
    protected Integer latePaymentFine;
    @JsonProperty("subscriptions_billing_days")
    protected Integer subscriptionsBillingDays;

}
