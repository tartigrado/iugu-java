package com.iugu.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.iugu.model.BankSlip;
import com.iugu.model.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountConfigurationInfo {

    protected Boolean autoWithdraw;
    protected Boolean disabledWithdraw;
    protected Boolean paymentEmailNotification;
    protected String paymentEmailNotificationReceiver;
    protected Boolean autoAdvance;
    protected String autoAdvanceType;
    protected Integer autoAdvanceOption;
    protected BigDecimal commissionPercent;
    protected String ownerEmailsToNotify;
    protected Boolean fines;
    protected String latePaymentFine;
    protected Boolean perDayInterest;
    protected BankSlip bankSlip;
    protected CreditCard creditCard;
    protected Pix pix;
    protected Boolean earlyPaymentDiscount;
    protected Integer earlyPaymentDiscountDays;
    protected BigDecimal earlyPaymentDiscountPercent;

}
