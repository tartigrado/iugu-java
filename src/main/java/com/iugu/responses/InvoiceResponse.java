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
    protected Long userId;
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
    @JsonProperty("fines_on_occurrence_day_cents")
    protected Integer finesOnOcurrenceDayCents;
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
}