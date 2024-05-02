package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponse {
    protected String amount;
    @JsonProperty("amount_cents")
    protected String amountCents;
    protected String type;
    protected String description;
    @JsonProperty("entry_date")
    protected String entryDate;
    protected String reference;
    @JsonProperty("reference_type")
    protected String referenceType;
    @JsonProperty("invoice_email")
    protected String invoiceEmail;
    @JsonProperty("customer_name")
    protected String customerName;
    @JsonProperty("customer_ref")
    protected String customerRef;
    @JsonProperty("account_id")
    protected String accountId;
    @JsonProperty("transaction_type")
    protected String transactionType;
    protected String balance;
    @JsonProperty("balance_cents")
    protected String balanceCents;
    @JsonProperty("payer_name")
    protected String payerName;
    protected String swing;
}
