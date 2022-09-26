package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountConfigurationResponse {

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
    @JsonProperty("change_plan_type")
    protected Integer changePlanType;
    @JsonProperty("subscriptions_trial_period")
    protected Integer subscriptionsTrialPeriod;
    @JsonProperty("disable_emails")
    protected Boolean disableEmails;
    @JsonProperty("total_subscriptions")
    protected Integer totalSubscriptions;
    @JsonProperty("webapp_on_test_mode")
    protected Boolean webappOnTestMode;
    protected Boolean marketplace;
    @JsonProperty("default_return_url")
    protected String defaultReturnUrl;
    @JsonProperty("auto_withdraw")
    protected Boolean autoWithdraw;
    protected String balance;
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
    protected List<InfoResponse> informations;
    protected ConfigurationResponse configuration;
}
