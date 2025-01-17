package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.iugu.model.Commissions;
import com.iugu.model.EarlyPaymentDiscount;
import com.iugu.model.splits.Splits;
import com.iugu.model.account.AccountConfiguration;
import com.iugu.model.account.BankAccount;
import com.iugu.model.account.ContactData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountConfigurationResponse {
    protected String id;
    protected String name;
    protected Date createdAt;
    protected Date updatedAt;
    @JsonProperty("can_receive?")
    protected Boolean canReceive;
    @JsonProperty("is_verified?")
    protected Boolean isVerified;
    protected String lastVerificationRequestStatus;
    protected String lastVerificationRequestData;
    protected String lastVerificationRequestFeedback;
    protected Integer changePlanType;
    protected Integer subscriptionsTrialPeriod;
    protected Integer subscriptionsBillingDays;
    protected Boolean disableEmails;
    protected LastWithdrawResponse lastWithdraw;
    protected String replyTo;
    protected Boolean webappOnTestMode;
    protected Boolean marketplace;
    protected String defaultReturnUrl;
    protected Boolean creditCardVerified;
    protected Boolean fines;
    protected Boolean latePaymentFine;
    protected Boolean perDayInterest;
    protected Boolean oldAdvancement;
    protected Boolean earlyPaymentDiscount;
    protected String earlyPaymentDiscountDays;
    protected String earlyPaymentDiscountPercent;
    protected Boolean autoWithdraw;
    protected Boolean disabledWithdraw;
    protected Boolean paymentEmailNotification;
    protected String paymentEmailNotificationReceiver;
    protected Boolean autoAdvance;
    protected String autoAdvanceType;
    protected Integer autoAdvanceOption;
    protected String balance;
    protected String balanceInProtest;
    protected String balanceAvailableForWithdraw;
    protected String protectedBalance;
    protected String payableBalance;
    protected String receivableBalance;
    protected String commissionBalance;
    protected String volumeLastMonth;
    protected String volumeThisMonth;
    protected Integer totalSubscriptions;
    protected Integer totalActiveSubscriptions;
    protected String taxesPaidLastMonth;
    protected String taxesPaidThisMonth;
    @JsonProperty("has_bank_address?")
    protected Boolean hasBankAddress;
    protected String permissions;
    protected String customLogoUrl;
    protected String customLogoSmallUrl;
    protected List<EarlyPaymentDiscount> earlyPaymentDiscounts;
    protected Commissions commissions;
    protected List<Splits> splits;
    protected ContactData contactData;
    protected String informations;
    protected AccountConfiguration configuration;
    protected List<BankAccount> bankAccounts;
}
