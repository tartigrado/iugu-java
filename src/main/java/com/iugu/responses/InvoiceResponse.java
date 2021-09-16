package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.EarlyPaymentDiscount;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceResponse implements Serializable {

    private static final long serialVersionUID = -4229186497940178039L;

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
    private Long userId;
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
    private Integer transactionNumber;
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
    @JsonProperty("fines_on_occurrence_day_cents")
    private Integer finesOnOcurrenceDayCents;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getDiscountCents() {
        return discountCents;
    }

    public void setDiscountCents(Integer discountCents) {
        this.discountCents = discountCents;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getItemsTotalCents() {
        return itemsTotalCents;
    }

    public void setItemsTotalCents(Integer itemsTotalCents) {
        this.itemsTotalCents = itemsTotalCents;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTaxCents() {
        return taxCents;
    }

    public void setTaxCents(Integer taxCents) {
        this.taxCents = taxCents;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getTotalCents() {
        return totalCents;
    }

    public void setTotalCents(Integer totalCents) {
        this.totalCents = totalCents;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }

    public String getSecureId() {
        return secureId;
    }

    public void setSecureId(String secureId) {
        this.secureId = secureId;
    }

    public String getSecureUrl() {
        return secureUrl;
    }

    public void setSecureUrl(String secureUrl) {
        this.secureUrl = secureUrl;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTaxesPaid() {
        return taxesPaid;
    }

    public void setTaxesPaid(String taxesPaid) {
        this.taxesPaid = taxesPaid;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public BankSlipResponse getBankSlip() {
        return bankSlip;
    }

    public void setBankSlip(BankSlipResponse bankSlip) {
        this.bankSlip = bankSlip;
    }

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }

    public List<VariableResponse> getVariables() {
        return variables;
    }

    public void setVariables(List<VariableResponse> variables) {
        this.variables = variables;
    }

    public List<CustomVariableResponse> getCustomVariables() {
        return customVariables;
    }

    public void setCustomVariables(List<CustomVariableResponse> customVariables) {
        this.customVariables = customVariables;
    }

    public List<LogResponse> getLogs() {
        return logs;
    }

    public void setLogs(List<LogResponse> logs) {
        this.logs = logs;
    }

    public String getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(String totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getTotalOnOccurrenceDay() {
        return totalOnOccurrenceDay;
    }

    public void setTotalOnOccurrenceDay(String totalOnOccurrenceDay) {
        this.totalOnOccurrenceDay = totalOnOccurrenceDay;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getTotalPaidCents() {
        return totalPaidCents;
    }

    public void setTotalPaidCents(Integer totalPaidCents) {
        this.totalPaidCents = totalPaidCents;
    }

    public Integer getTaxesPaidCents() {
        return taxesPaidCents;
    }

    public void setTaxesPaidCents(Integer taxesPaidCents) {
        this.taxesPaidCents = taxesPaidCents;
    }

    public Integer getPaidCents() {
        return paidCents;
    }

    public void setPaidCents(Integer paidCents) {
        this.paidCents = paidCents;
    }

    public String getCcEmails() {
        return ccEmails;
    }

    public void setCcEmails(String ccEmails) {
        this.ccEmails = ccEmails;
    }

    public Date getFinancialReturnDate() {
        return financialReturnDate;
    }

    public void setFinancialReturnDate(Date financialReturnDate) {
        this.financialReturnDate = financialReturnDate;
    }

    public Object getPayableWith() { return payableWith; }

    public void setPayableWith(Object payableWith) {
        this.payableWith = payableWith;
    }

    public Integer getOverpaidCents() {
        return overpaidCents;
    }

    public void setOverpaidCents(Integer overpaidCents) {
        this.overpaidCents = overpaidCents;
    }

    public Boolean getEarlyPaymentDiscount() {
        return earlyPaymentDiscount;
    }

    public void setEarlyPaymentDiscount(Boolean earlyPaymentDiscount) {
        this.earlyPaymentDiscount = earlyPaymentDiscount;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTotalOverpaid() {
        return totalOverpaid;
    }

    public void setTotalOverpaid(String totalOverpaid) {
        this.totalOverpaid = totalOverpaid;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public Integer getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(Integer transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Date getCreatedAtIso() {
        return createdAtIso;
    }

    public void setCreatedAtIso(Date createdAtIso) {
        this.createdAtIso = createdAtIso;
    }

    public Date getUpdatedAtIso() {
        return updatedAtIso;
    }

    public void setUpdatedAtIso(Date updatedAtIso) {
        this.updatedAtIso = updatedAtIso;
    }

    public List<FinancialReturnDatesResponse> getFinancialReturnDates() {
        return financialReturnDates;
    }

    public void setFinancialReturnDates(List<FinancialReturnDatesResponse> financialReturnDates) {
        this.financialReturnDates = financialReturnDates;
    }

    public Boolean getIgnoreDueEmail() {
        return ignoreDueEmail;
    }

    public void setIgnoreDueEmail(Boolean ignoreDueEmail) {
        this.ignoreDueEmail = ignoreDueEmail;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFinesOnOccurrenceDay() {
        return finesOnOccurrenceDay;
    }

    public void setFinesOnOccurrenceDay(String finesOnOccurrenceDay) {
        this.finesOnOccurrenceDay = finesOnOccurrenceDay;
    }

    public Integer getFinesOnOcurrenceDayCents() {
        return finesOnOcurrenceDayCents;
    }

    public void setFinesOnOcurrenceDayCents(Integer finesOnOcurrenceDayCents) {
        this.finesOnOcurrenceDayCents = finesOnOcurrenceDayCents;
    }

    public Integer getPerDayInterestValue() {
        return perDayInterestValue;
    }

    public void setPerDayInterestValue(Integer perDayInterestValue) {
        this.perDayInterestValue = perDayInterestValue;
    }

    public void setEarlyPaymentDiscounts(List<EarlyPaymentDiscount> earlyPaymentDiscounts) {
        this.earlyPaymentDiscounts = earlyPaymentDiscounts;
    }

    public List<EarlyPaymentDiscount> getEarlyPaymentDiscounts() {
        return earlyPaymentDiscounts;
    }

    public PixResponse getPix() {
        return pix;
    }

    public void setPix(PixResponse pix) {
        this.pix = pix;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getPayerCpfCnpj() {
        return payerCpfCnpj;
    }

    public void setPayerCpfCnpj(String payerCpfCnpj) {
        this.payerCpfCnpj = payerCpfCnpj;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public String getPayerPhonePrefix() {
        return payerPhonePrefix;
    }

    public void setPayerPhonePrefix(String payerPhonePrefix) {
        this.payerPhonePrefix = payerPhonePrefix;
    }

    public String getPayerAddressZipCode() {
        return payerAddressZipCode;
    }

    public void setPayerAddressZipCode(String payerAddressZipCode) {
        this.payerAddressZipCode = payerAddressZipCode;
    }

    public String getPayerAddressStreet() {
        return payerAddressStreet;
    }

    public void setPayerAddressStreet(String payerAddressStreet) {
        this.payerAddressStreet = payerAddressStreet;
    }

    public String getPayerAddressDistrict() {
        return payerAddressDistrict;
    }

    public void setPayerAddressDistrict(String payerAddressDistrict) {
        this.payerAddressDistrict = payerAddressDistrict;
    }

    public String getPayerAddressCity() {
        return payerAddressCity;
    }

    public void setPayerAddressCity(String payerAddressCity) {
        this.payerAddressCity = payerAddressCity;
    }

    public String getPayerAddressState() {
        return payerAddressState;
    }

    public void setPayerAddressState(String payerAddressState) {
        this.payerAddressState = payerAddressState;
    }

    public String getPayerAddressNumber() {
        return payerAddressNumber;
    }

    public void setPayerAddressNumber(String payerAddressNumber) {
        this.payerAddressNumber = payerAddressNumber;
    }

    public String getPayerAddressComplement() {
        return payerAddressComplement;
    }

    public void setPayerAddressComplement(String payerAddressComplement) {
        this.payerAddressComplement = payerAddressComplement;
    }

    public String getPayerAddressCountry() {
        return payerAddressCountry;
    }

    public void setPayerAddressCountry(String payerAddressCountry) {
        this.payerAddressCountry = payerAddressCountry;
    }
}