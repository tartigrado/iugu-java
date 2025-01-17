package com.iugu.model.account.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.EarlyPaymentDiscount;
import com.iugu.model.account.BankAccount;
import com.iugu.model.account.ContactData;
import com.iugu.responses.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class AccountResponse {

    private String id;
    private String name;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("can_receive")
    private Boolean canReceive;
    @JsonProperty("is_verified")
    private Boolean isVerified;
    @JsonProperty("last_verification_request_status")
    private String lastVerificationRequestStatus;
    @JsonProperty("last_verification_request_data")
    private AccountLastVerification accountLastVerification;
    @JsonProperty("last_verification_request_feedback")
    private String lastVerificationRequestFeedback;
    @JsonProperty("change_plan_type")
    private Integer changePlanType;
    @JsonProperty("subscriptions_trial_period")
    private Integer subscriptionsTrialPeriod;
    @JsonProperty("subscriptions_billing_days")
    private Integer subscriptionsBillingDays;
    @JsonProperty("disable_emails")
    private Boolean disableEmails;
    @JsonProperty("last_withdraw")
    private LastWithdrawResponse lastWithdraw;
    @JsonProperty("total_subscriptions")
    private Integer totalSubscriptions;
    @JsonProperty("total_active_subscriptions")
    private Integer totalActiveSubscriptions;
    @JsonProperty("reply_to")
    private String replyTo;
    @JsonProperty("webapp_on_test_mode")
    private Boolean webappOnTestMode;
    private Boolean marketplace;
    @JsonProperty("auto_withdraw")
    private Boolean autoWithdraw;
    private String balance;
    @JsonProperty("balance_available_for_withdraw")
    private String balanceAvailableForWithdraw;
    @JsonProperty("balance_in_protest")
    private String balanceInProtest;
    @JsonProperty("private_balance")
    private String privateBalance;
    @JsonProperty("payable_balance")
    private String payableBalance;
    @JsonProperty("receivable_balance")
    private String receivableBalance;
    @JsonProperty("commission_balance")
    private String commissionBalance;
    @JsonProperty("volume_last_month")
    private String volumeLastMonth;
    @JsonProperty("volume_this_month")
    private String volumeThisMonth;
    @JsonProperty("taxes_paid_last_month")
    private String taxesPaidLastMonth;
    @JsonProperty("taxes_paid_this_month")
    private String taxesPaidThisMonth;
    @JsonProperty("custom_logo_url")
    private String customLogoUrl;
    @JsonProperty("custom_logo_small_url")
    private String customLogoSmallUrl;
    private List<InfoResponse> informations;
    private Boolean fines;
    @JsonProperty("per_day_interest")
    private Boolean perDayInterest;
    @JsonProperty("late_payment_fine")
    private Integer latePaymentFine;
    private ConfigurationResponse configuration;
    private CommissionsResponse commissions;
    @JsonProperty("payment_email_notification")
    private Boolean paymentEmailNotification;
    @JsonProperty("payment_email_notification_receiver")
    private String paymentEmailNotificationReceiver;
    @JsonProperty("early_payment_discount")
    private Boolean earlyPaymentDiscount;
    @JsonProperty("early_payment_discounts")
    private List<EarlyPaymentDiscount> earlyPaymentDiscounts;
    private List<SplitsResponse> splits;
    @JsonProperty("default_return_url")
    private String defaultReturnUrl;
    @JsonProperty("credit_card_verified")
    private Boolean creditCardVerified;
    @JsonProperty("old_advancement")
    private Boolean oldAdvancement;
    @JsonProperty("early_payment_discount_days")
    private String earlyPaymentDiscountDays;
    @JsonProperty("early_payment_discount_percent")
    private String earlyPaymentDiscountPercent;
    @JsonProperty("bank_accounts")
    private List<BankAccount> bankAccounts;
    @JsonProperty("disabled_withdraw")
    private Boolean disabledWithdraw;
    @JsonProperty("auto_advance")
    private Boolean autoAdvance;
    @JsonProperty("auto_advance_type")
    private String autoAdvanceType;
    @JsonProperty("auto_advance_option")
    private Integer autoAdvanceOption;
    @JsonProperty("has_bank_address?")
    private Boolean hasBankAddress;
    private String permissions;
    @JsonProperty("contact_data")
    private ContactData contactData;

}
