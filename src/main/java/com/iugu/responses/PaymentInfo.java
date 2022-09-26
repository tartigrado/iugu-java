package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentInfo implements Serializable {
    protected String barcode;
    @JsonProperty("amount_cents")
    protected Integer amountCents;
    @JsonProperty("fine_cents")
    protected Integer fineCents;
    @JsonProperty("interest_cents")
    protected Integer interestCents;
    @JsonProperty("discount_cents")
    protected Integer discountCents;
    @JsonProperty("total_amount_cents")
    protected Integer totalAmountCents;
    @JsonProperty("recipient_name")
    protected String recipientName;
    @JsonProperty("recipient_cnpj_cpf")
    protected String recipientCnpjCpf;
    @JsonProperty("payer_name")
    protected String payerName;
    @JsonProperty("payer_cnpj_cpf")
    protected String payerCnpjCpf;
    @JsonProperty("allow_amount_change")
    protected Boolean allowAmountChange;
    @JsonProperty("allow_partial_payment")
    protected Boolean allowPartialPayment;
    @JsonProperty("due_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date dueDate;
    @JsonProperty("maximum_payment_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date maximumPaymentDate;
    protected String details;
    protected String emitter;
    @JsonProperty("payee_cnpj_cpf")
    protected String payeeCnpjCpf;
}