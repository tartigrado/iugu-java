package com.iugu.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.iugu.interfaces.WithApiToken;
import com.iugu.model.BankSlip;
import com.iugu.model.CreditCard;
import com.iugu.model.EarlyPaymentDiscount;
import com.iugu.model.splits.Splits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public final class AccountConfiguration implements WithApiToken {
    @JsonProperty("api_token")
    private String apiToken;
    private List<Splits> splits;
    @JsonProperty("auto_withdraw")
    private Boolean autoWithdraw;
    @JsonProperty("per_day_interest")
    private Boolean perDayInterest;
    @JsonProperty("finnic")
    private Boolean finnic;
    @JsonProperty("late_payment_fine")
    private Integer latePaymentFine;
    @JsonProperty("auto_advance")
    private Boolean autoAdvance;
    @JsonProperty("auto_advance_type")
    private String autoAdvanceType;
    @JsonProperty("auto_advance_option")
    private Integer autoAdvanceOption;
    @JsonProperty("bank_slip")
    private BankSlip bankSlip;
    @JsonProperty("credit_card")
    private CreditCard creditCard;
    @JsonProperty("payment_email_notification")
    private Boolean paymentEmailNotification;
    @JsonProperty("payment_email_notification_receiver")
    private String paymentEmailNotificationReceiver;
    @JsonProperty("early_payment_discount")
    private Boolean earlyPaymentDiscount;
    @JsonProperty("early_payment_discounts")
    private List<EarlyPaymentDiscount> earlyPaymentDiscounts;
    @JsonProperty("disabled_withdraw")
    private Boolean disabledWithdraw;
    @JsonProperty("customer_minimum_balance_cents")
    private String customerMinimumBalanceCents;

}
