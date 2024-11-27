package com.iugu.model.invoice.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.EarlyPaymentDiscount;
import com.iugu.responses.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class InvoiceResponse {

    private String id;
    @JsonProperty("due_date")
    private String dueDate;
    private String currency;
    @JsonProperty("discount_cents")
    private Integer discountCents;
    private String email;
    @JsonProperty("items_total_cents")
    private Integer itemsTotalCents;
    @JsonProperty("notification_url")
    private String notificationUrl;
    @JsonProperty("return_url")
    private String returnUrl;
    private String status;
    @JsonProperty("tax_cents")
    private Integer taxCents;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("total_cents")
    private Integer totalCents;
    @JsonProperty("total_paid_cents")
    private Integer totalPaidCents;
    @JsonProperty("paid_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date paidAt;
    @JsonProperty("taxes_paid_cents")
    private Integer taxesPaidCents;
    @JsonProperty("paid_cents")
    private Integer paidCents;
    @JsonProperty("cc_emails")
    private String ccEmails;
    @JsonProperty("financial_return_date")
    private Date financialReturnDate;
    @JsonProperty("payable_with")
    private Object payableWith;
    @JsonProperty("overpaid_cents")
    private Integer overpaidCents;
    @JsonProperty("early_payment_discount")
    private Boolean earlyPaymentDiscount;
    @JsonProperty("secure_id")
    private String secureId;
    @JsonProperty("secure_url")
    private String secureUrl;
    @JsonProperty("customer_id")
    private String customerId;
    @JsonProperty("customer_ref")
    private String customerRef;
    @JsonProperty("customer_name")
    private String customerName;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("total")
    private String total;
    @JsonProperty("total_paid")
    private String totalPaid;
    @JsonProperty("total_on_occurrence_day")
    private String totalOnOccurrenceDay;
    @JsonProperty("taxes_paid")
    private String taxesPaid;
    @JsonProperty("total_overpaid")
    private String totalOverpaid;
    private String commission;
    private String paid;
    private String interest;
    private String discount;
    private Boolean refundable;
    private String installments;
    @JsonProperty("transaction_number")
    private String transactionNumber;
    @JsonProperty("created_at_iso")
    private Date createdAtIso;
    @JsonProperty("updated_at_iso")
    private Date updatedAtIso;
    @JsonProperty("bank_slip")
    private BankSlipResponse bankSlip;
    @JsonProperty("pix")
    private PixResponse pix;
    private List<ItemResponse> items;
    private List<VariableResponse> variables;
    @JsonProperty("custom_variables")
    private List<CustomVariableResponse> customVariables;
    private List<LogResponse> logs;
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("financial_return_dates")
    private List<FinancialReturnDatesResponse> financialReturnDates;
    @JsonProperty("ignore_due_email")
    private Boolean ignoreDueEmail;
    @JsonProperty("fines_on_occurrence_day")
    private String finesOnOccurrenceDay;
    @JsonProperty("fine_cents")
    private Integer fineCents;
    @JsonProperty("per_day_interest_value")
    private Integer perDayInterestValue;
    @JsonProperty("early_payment_discounts")
    private List<EarlyPaymentDiscount> earlyPaymentDiscounts;
    @JsonProperty("payer_name")
    private String payerName;
    @JsonProperty("payer_email")
    private String payerEmail;
    @JsonProperty("payer_cpf_cnpj")
    private String payerCpfCnpj;
    @JsonProperty("payer_phone")
    private String payerPhone;
    @JsonProperty("payer_phone_prefix")
    private String payerPhonePrefix;
    @JsonProperty("payer_address_zip_code")
    private String payerAddressZipCode;
    @JsonProperty("payer_address_street")
    private String payerAddressStreet;
    @JsonProperty("payer_address_district")
    private String payerAddressDistrict;
    @JsonProperty("payer_address_city")
    private String payerAddressCity;
    @JsonProperty("payer_address_state")
    private String payerAddressState;
    @JsonProperty("payer_address_number")
    private String payerAddressNumber;
    @JsonProperty("payer_address_complement")
    private String payerAddressComplement;
    @JsonProperty("payer_address_country")
    private String payerAddressCountry;
    @JsonProperty("ignore_canceled_email")
    private String ignoreCanceledEmail;
    @JsonProperty("advance_fee_cents")
    private String advanceFeeCents;
    @JsonProperty("commission_cents")
    private String commissionCents;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("credit_card_brand")
    private String creditCardBrand;
    @JsonProperty("credit_card_bin")
    private String creditCardBin;
    @JsonProperty("credit_card_last_4")
    private String creditCardLast4;
    @JsonProperty("credit_card_captured_at")
    private String creditCardCapturedAt;
    @JsonProperty("credit_card_tid")
    private String creditCardTid;
    @JsonProperty("external_reference")
    private String externalReference;
    @JsonProperty("max_installments_value")
    private String maxInstallmentsValue;
    @JsonProperty("late_payment_fine")
    private Integer latePaymentFine;
    @JsonProperty("late_payment_fine_cents")
    private String latePaymentFineCents;
    @JsonProperty("split_id")
    private String splitId;
    @JsonProperty("external_payment_id")
    private String externalPaymentId;
    @JsonProperty("external_payment_description")
    private String externalPaymentDescription;
    @JsonProperty("payment_booklet_id")
    private String paymentBookletId;
    @JsonProperty("subscription_id")
    private String subscriptionId;
    @JsonProperty("credit_card_transaction")
    private Object creditCardTransaction;
    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("bank_account_branch")
    private String bankAccountBranch;
    @JsonProperty("bank_account_number")
    private String bankAccountNumber;
    @JsonProperty("account_name")
    private String accountName;
    @JsonProperty("total_refunded")
    private String totalRefunded;
    @JsonProperty("fines_on_occurrence_day_cents")
    private Integer finesOnOccurrenceDayCents;
    @JsonProperty("total_on_occurrence_day_cents")
    private Integer totalOnOccurrenceDayCents;
    @JsonProperty("refunded_cents")
    private Integer refundedCents;
    @JsonProperty("remaining_captured_cents")
    private Integer remainingCapturedCents;
    @JsonProperty("advance_fee")
    private String advanceFee;
    @JsonProperty("estimated_advance_fee")
    private String estimatedAdvanceFee;
    @JsonProperty("original_payment_id")
    private String originalPaymentId;
    @JsonProperty("double_payment_id")
    private String doublePaymentId;
    @JsonProperty("per_day_interest")
    private boolean perDayInterest;
    @JsonProperty("per_day_interest_cents")
    private Integer perDayInterestCents;
    @JsonProperty("duplicated_invoice_id")
    private String duplicatedInvoiceId;
    @JsonProperty("bank_slip_extra_due")
    private Integer bankSlipExtraDue;
    @JsonProperty("authorized_at")
    private String authorizedAt;
    @JsonProperty("authorized_at_iso")
    private String authorizedAtIso;
    @JsonProperty("expired_at")
    private String expiredAt;
    @JsonProperty("expired_at_iso")
    private String expiredAtIso;
    @JsonProperty("refunded_at")
    private String refundedAt;
    @JsonProperty("refunded_at_iso")
    private String refundedAtIso;
    @JsonProperty("canceled_at")
    private String canceledAt;
    @JsonProperty("canceled_at_iso")
    private String canceledAtIso;
    @JsonProperty("protested_at")
    private String protestedAt;
    @JsonProperty("protested_at_iso")
    private String protestedAtIso;
    @JsonProperty("chargeback_at")
    private String chargebackAt;
    @JsonProperty("chargeback_at_iso")
    private String chargebackAtIso;
    @JsonProperty("occurrence_date")
    private String occurrenceDate;
    @JsonProperty("split_rules")
    private Object splitRules;
    @JsonAnySetter
    private Map<String, Object> any;
}