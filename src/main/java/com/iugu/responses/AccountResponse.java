package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.EarlyPaymentDiscount;
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
public class AccountResponse {

    protected String id;
    protected String name;
    @JsonProperty("created_at")
    protected Date createdAt;
    @JsonProperty("updated_at")
    protected Date updatedAt;
    @JsonProperty("can_receive")
    protected Boolean canReceive;
    @JsonProperty("is_verified")
    protected Boolean isVerified;
    @JsonProperty("last_verification_request_status")
    protected String lastVerificationRequestStatus;
    @JsonProperty("last_verification_request_data")
    protected AccountLastVerification accountLastVerification;
    @JsonProperty("last_verification_request_feedback")
    protected String lastVerificationRequestFeedback;
    @JsonProperty("change_plan_type")
    protected Integer changePlanType;
    @JsonProperty("subscriptions_trial_period")
    protected Integer subscriptionsTrialPeriod;
    @JsonProperty("subscriptions_billing_days")
    protected Integer subscriptionsBillingDays;
    @JsonProperty("disable_emails")
    protected Boolean disableEmails;
    @JsonProperty("last_withdraw")
    protected LastWithdrawResponse lastWithdraw;
    @JsonProperty("total_subscriptions")
    protected Integer totalSubscriptions;
    @JsonProperty("total_active_subscriptions")
    protected Integer totalActiveSubscriptions;
    @JsonProperty("reply_to")
    protected String replyTo;
    @JsonProperty("webapp_on_test_mode")
    protected Boolean webappOnTestMode;
    protected Boolean marketplace;
    @JsonProperty("auto_withdraw")
    protected Boolean autoWithdraw;
    protected String balance;
    @JsonProperty("balance_available_for_withdraw")
    protected String balanceAvailableForWithdraw;
    @JsonProperty("balance_in_protest")
    protected String balanceInProtest;
    @JsonProperty("protected_balance")
    protected String protectedBalance;
    @JsonProperty("payable_balance")
    protected String payableBalance;
    @JsonProperty("receivable_balance")
    protected String receivableBalance;
    @JsonProperty("commission_balance")
    protected String commissionBalance;
    @JsonProperty("volume_last_month")
    protected String volumeLastMonth;
    @JsonProperty("volume_this_month")
    protected String volumeThisMonth;
    @JsonProperty("taxes_paid_last_month")
    protected String taxesPaidLastMonth;
    @JsonProperty("taxes_paid_this_month")
    protected String taxesPaidThisMonth;
    @JsonProperty("custom_logo_url")
    protected String customLogoUrl;
    @JsonProperty("custom_logo_small_url")
    protected String customLogoSmallUrl;
    protected List<InfoResponse> informations;
    protected Boolean fines;
    @JsonProperty("per_day_interest")
    protected Boolean perDayInterest;
    @JsonProperty("late_payment_fine")
    protected Integer latePaymentFine;
    protected ConfigurationResponse configuration;
    protected CommissionsResponse commissions;
    @JsonProperty("payment_email_notification")
    protected Boolean paymentEmailNotification;
    @JsonProperty("payment_email_notification_receiver")
    protected String paymentEmailNotificationReceiver;
    @JsonProperty("early_payment_discount")
    protected Boolean earlyPaymentDiscount;
    @JsonProperty("early_payment_discounts")
    protected List<EarlyPaymentDiscount> earlyPaymentDiscounts;
    protected List<SplitsResponse> splits;
    @JsonProperty("default_return_url")
    protected String defaultReturnUrl;
    @JsonProperty("credit_card_verified")
    protected Boolean creditCardVerified;
    @JsonProperty("old_advancement")
    protected Boolean oldAdvancement;
    @JsonProperty("early_payment_discount_days")
    protected String earlyPaymentDiscountDays;
    @JsonProperty("early_payment_discount_percent")
    protected String earlyPaymentDiscountPercent;
    @JsonProperty("bank_accounts")
    protected List<BankAccount> bankAccounts;
    @JsonProperty("disabled_withdraw")
    protected Boolean disabledWithdraw;
    @JsonProperty("auto_advance")
    protected Boolean autoAdvance;
    @JsonProperty("auto_advance_type")
    protected String autoAdvanceType;
    @JsonProperty("auto_advance_option")
    protected Integer autoAdvanceOption;
    @JsonProperty("has_bank_address?")
    protected Boolean hasBankAddress;
    protected String permissions;
    @JsonProperty("contact_data")
    protected ContactData contactData;

}
