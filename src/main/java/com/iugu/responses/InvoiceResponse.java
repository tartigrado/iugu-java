package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.EarlyPaymentDiscount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceResponse {

    protected String id;
    @JsonProperty("due_date")
    protected String dueDate;
    protected String currency;
    @JsonProperty("discount_cents")
    protected Integer discountCents;
    protected String email;
    @JsonProperty("items_total_cents")
    protected Integer itemsTotalCents;
    @JsonProperty("notification_url")
    protected String notificationUrl;
    @JsonProperty("return_url")
    protected String returnUrl;
    protected String status;
    @JsonProperty("tax_cents")
    protected Integer taxCents;
    @JsonProperty("created_at")
    protected String createdAt;
    @JsonProperty("updated_at")
    protected Date updatedAt;
    @JsonProperty("total_cents")
    protected Integer totalCents;
    @JsonProperty("total_paid_cents")
    protected Integer totalPaidCents;
    @JsonProperty("paid_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    protected Date paidAt;
    @JsonProperty("taxes_paid_cents")
    protected Integer taxesPaidCents;
    @JsonProperty("paid_cents")
    protected Integer paidCents;
    @JsonProperty("cc_emails")
    protected String ccEmails;
    @JsonProperty("financial_return_date")
    protected Date financialReturnDate;
    @JsonProperty("payable_with")
    protected Object payableWith;
    @JsonProperty("overpaid_cents")
    protected Integer overpaidCents;
    @JsonProperty("early_payment_discount")
    protected Boolean earlyPaymentDiscount;
    @JsonProperty("secure_id")
    protected String secureId;
    @JsonProperty("secure_url")
    protected String secureUrl;
    @JsonProperty("customer_id")
    protected String customerId;
    @JsonProperty("customer_ref")
    protected String customerRef;
    @JsonProperty("customer_name")
    protected String customerName;
    @JsonProperty("user_id")
    protected String userId;
    @JsonProperty("total")
    protected String total;
    @JsonProperty("total_paid")
    protected String totalPaid;
    @JsonProperty("total_on_occurrence_day")
    protected String totalOnOccurrenceDay;
    @JsonProperty("taxes_paid")
    protected String taxesPaid;
    @JsonProperty("total_overpaid")
    protected String totalOverpaid;
    protected String commission;
    protected String paid;
    protected String interest;
    protected String discount;
    protected Boolean refundable;
    protected String installments;
    @JsonProperty("transaction_number")
    protected Integer transactionNumber;
    @JsonProperty("created_at_iso")
    protected Date createdAtIso;
    @JsonProperty("updated_at_iso")
    protected Date updatedAtIso;
    @JsonProperty("bank_slip")
    protected BankSlipResponse bankSlip;
    @JsonProperty("pix")
    protected PixResponse pix;
    protected List<ItemResponse> items;
    protected List<VariableResponse> variables;
    @JsonProperty("custom_variables")
    protected List<CustomVariableResponse> customVariables;
    protected List<LogResponse> logs;
    @JsonProperty("payment_method")
    protected String paymentMethod;
    @JsonProperty("financial_return_dates")
    protected List<FinancialReturnDatesResponse> financialReturnDates;
    @JsonProperty("ignore_due_email")
    protected Boolean ignoreDueEmail;
    @JsonProperty("fines_on_occurrence_day")
    protected String finesOnOccurrenceDay;
    @JsonProperty("per_day_interest_value")
    protected Integer perDayInterestValue;
    @JsonProperty("early_payment_discounts")
    protected List<EarlyPaymentDiscount> earlyPaymentDiscounts;
    @JsonProperty("payer_name")
    protected String payerName;
    @JsonProperty("payer_email")
    protected String payerEmail;
    @JsonProperty("payer_cpf_cnpj")
    protected String payerCpfCnpj;
    @JsonProperty("payer_phone")
    protected String payerPhone;
    @JsonProperty("payer_phone_prefix")
    protected String payerPhonePrefix;
    @JsonProperty("payer_address_zip_code")
    protected String payerAddressZipCode;
    @JsonProperty("payer_address_street")
    protected String payerAddressStreet;
    @JsonProperty("payer_address_district")
    protected String payerAddressDistrict;
    @JsonProperty("payer_address_city")
    protected String payerAddressCity;
    @JsonProperty("payer_address_state")
    protected String payerAddressState;
    @JsonProperty("payer_address_number")
    protected String payerAddressNumber;
    @JsonProperty("payer_address_complement")
    protected String payerAddressComplement;
    @JsonProperty("payer_address_country")
    protected String payerAddressCountry;
    @JsonProperty("ignore_canceled_email")
    protected String ignoreCanceledEmail;
    @JsonProperty("advance_fee_cents")
    protected String advanceFeeCents;
    @JsonProperty("commission_cents")
    protected String commissionCents;
    @JsonProperty("order_id")
    protected String orderId;
    @JsonProperty("credit_card_brand")
    protected String creditCardBrand;
    @JsonProperty("credit_card_bin")
    protected String creditCardBin;
    @JsonProperty("credit_card_last_4")
    protected String creditCardLast4;
    @JsonProperty("credit_card_captured_at")
    protected String creditCardCapturedAt;
    @JsonProperty("credit_card_tid")
    protected String creditCardTid;
    @JsonProperty("external_reference")
    protected String externalReference;
    @JsonProperty("max_installments_value")
    protected String maxInstallmentsValue;
    @JsonProperty("late_payment_fine")
    protected Integer latePaymentFine;
    @JsonProperty("late_payment_fine_cents")
    protected String latePaymentFineCents;
    @JsonProperty("split_id")
    protected String splitId;
    @JsonProperty("external_payment_id")
    protected String externalPaymentId;
    @JsonProperty("external_payment_description")
    protected String externalPaymentDescription;
    @JsonProperty("payment_booklet_id")
    protected String paymentBookletId;
    @JsonProperty("subscription_id")
    protected String subscriptionId;
    @JsonProperty("credit_card_transaction")
    protected String creditCardTransaction;
    @JsonProperty("account_id")
    protected String accountId;
    @JsonProperty("bank_account_branch")
    protected String bankAccountBranch;
    @JsonProperty("bank_account_number")
    protected String bankAccountNumber;
    @JsonProperty("account_name")
    protected String accountName;
    @JsonProperty("total_refunded")
    protected String totalRefunded;
    @JsonProperty("fines_on_occurrence_day_cents")
    protected Integer finesOnOccurrenceDayCents;
    @JsonProperty("total_on_occurrence_day_cents")
    protected Integer totalOnOccurrenceDayCents;
    @JsonProperty("refunded_cents")
    protected Integer refundedCents;
    @JsonProperty("remaining_captured_cents")
    protected Integer remainingCapturedCents;
    @JsonProperty("advance_fee")
    protected String advanceFee;
    @JsonProperty("estimated_advance_fee")
    protected String estimatedAdvanceFee;
    @JsonProperty("original_payment_id")
    protected String originalPaymentId;
    @JsonProperty("double_payment_id")
    protected String doublePaymentId;
    @JsonProperty("per_day_interest")
    protected boolean perDayInterest;
    @JsonProperty("per_day_interest_cents")
    protected Integer perDayInterestCents;
    @JsonProperty("duplicated_invoice_id")
    protected String duplicatedInvoiceId;
    @JsonProperty("bank_slip_extra_due")
    protected Integer bankSlipExtraDue;
    @JsonProperty("authorized_at")
    protected String authorizedAt;
    @JsonProperty("authorized_at_iso")
    protected String authorizedAtIso;
    @JsonProperty("expired_at")
    protected String expiredAt;
    @JsonProperty("expired_at_iso")
    protected String expiredAtIso;
    @JsonProperty("refunded_at")
    protected String refundedAt;
    @JsonProperty("refunded_at_iso")
    protected String refundedAtIso;
    @JsonProperty("canceled_at")
    protected String canceledAt;
    @JsonProperty("canceled_at_iso")
    protected String canceledAtIso;
    @JsonProperty("protested_at")
    protected String protestedAt;
    @JsonProperty("protested_at_iso")
    protected String protestedAtIso;
    @JsonProperty("chargeback_at")
    protected String chargebackAt;
    @JsonProperty("chargeback_at_iso")
    protected String chargebackAtIso;
    @JsonProperty("occurrence_date")
    protected String occurrenceDate;
    @JsonProperty("split_rules")
    protected Object splitRules;

}