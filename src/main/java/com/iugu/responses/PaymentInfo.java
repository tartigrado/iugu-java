package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentInfo implements Serializable {
    private String barcode;
    @JsonProperty("amount_cents")
    private Integer amountCents;
    @JsonProperty("fine_cents")
    private Integer fineCents;
    @JsonProperty("interest_cents")
    private Integer interestCents;
    @JsonProperty("discount_cents")
    private Integer discountCents;
    @JsonProperty("total_amount_cents")
    private Integer totalAmountCents;
    @JsonProperty("recipient_name")
    private String recipientName;
    @JsonProperty("recipient_cnpj_cpf")
    private String recipientCnpjCpf;
    @JsonProperty("payer_name")
    private String payerName;
    @JsonProperty("payer_cnpj_cpf")
    private String payerCnpjCpf;
    @JsonProperty("allow_amount_change")
    private Boolean allowAmountChange;
    @JsonProperty("allow_partial_payment")
    private Boolean allowPartialPayment;
    @JsonProperty("due_date")
    // UNKNOWN FORMAT
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dueDate;
    @JsonProperty("maximum_payment_date")
    // UNKNOWN FORMAT
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date maximumPaymentDate;
    private String details;
    private String emitter;
    @JsonProperty("payee_cnpj_cpf")
    private String payeeCnpjCpf;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getAmountCents() {
        return amountCents;
    }

    public void setAmountCents(Integer amountCents) {
        this.amountCents = amountCents;
    }

    public Integer getFineCents() {
        return fineCents;
    }

    public void setFineCents(Integer fineCents) {
        this.fineCents = fineCents;
    }

    public Integer getInterestCents() {
        return interestCents;
    }

    public void setInterestCents(Integer interestCents) {
        this.interestCents = interestCents;
    }

    public Integer getDiscountCents() {
        return discountCents;
    }

    public void setDiscountCents(Integer discountCents) {
        this.discountCents = discountCents;
    }

    public Integer getTotalAmountCents() {
        return totalAmountCents;
    }

    public void setTotalAmountCents(Integer totalAmountCents) {
        this.totalAmountCents = totalAmountCents;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientCnpjCpf() {
        return recipientCnpjCpf;
    }

    public void setRecipientCnpjCpf(String recipientCnpjCpf) {
        this.recipientCnpjCpf = recipientCnpjCpf;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerCnpjCpf() {
        return payerCnpjCpf;
    }

    public void setPayerCnpjCpf(String payerCnpjCpf) {
        this.payerCnpjCpf = payerCnpjCpf;
    }

    public Boolean getAllowAmountChange() {
        return allowAmountChange;
    }

    public void setAllowAmountChange(Boolean allowAmountChange) {
        this.allowAmountChange = allowAmountChange;
    }

    public Boolean getAllowPartialPayment() {
        return allowPartialPayment;
    }

    public void setAllowPartialPayment(Boolean allowPartialPayment) {
        this.allowPartialPayment = allowPartialPayment;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getMaximumPaymentDate() {
        return maximumPaymentDate;
    }

    public void setMaximumPaymentDate(Date maximumPaymentDate) {
        this.maximumPaymentDate = maximumPaymentDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEmitter() {
        return emitter;
    }

    public void setEmitter(String emitter) {
        this.emitter = emitter;
    }

    public String getPayeeCnpjCpf() {
        return payeeCnpjCpf;
    }

    public void setPayeeCnpjCpf(String payeeCnpjCpf) {
        this.payeeCnpjCpf = payeeCnpjCpf;
    }
}