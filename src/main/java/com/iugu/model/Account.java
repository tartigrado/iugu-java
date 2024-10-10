package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.interfaces.WithApiToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account implements WithApiToken {

    protected String id;
    protected String name;
    @JsonProperty("reply_to")
    protected String replyTo;
    @JsonProperty("commission_percent")
    protected String commissionPercent;
    @JsonProperty("auto_withdraw")
    protected Boolean auto_withdraw;
    protected Boolean fines;
    @JsonProperty("per_day_interest")
    protected Boolean perDayInterest;
    @JsonProperty("late_payment_fine")
    protected Integer latePaymentFine;
    @JsonProperty("auto_advance")
    protected Boolean autoAdvance;
    @JsonProperty("auto_advance_type")
    protected String autoAdvanceType;
    @JsonProperty("auto_advance_option")
    protected String autoAdvanceOption;
    @JsonProperty("bank_slip")
    protected BankSlip bankSlip;
    @JsonProperty("credit_card")
    protected CreditCard creditCard;
    @JsonProperty("payment_email_notification")
    protected Boolean paymentEmailNotification;
    @JsonProperty("payment_email_notification_receiver")
    protected String paymentEmailNotificationReceiver;
    @JsonProperty("early_payment_discount")
    protected Boolean earlyPaymentDiscount;
    @JsonProperty("early_payment_discounts")
    protected List<EarlyPaymentDiscount> earlyPaymentDiscounts;
    protected Commissions commissions;
    protected List<Splits> splits;
    @JsonProperty("api_token")
    protected String apiToken;
}
