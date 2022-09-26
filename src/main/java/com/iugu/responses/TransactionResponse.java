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
    protected String type;
    protected String description;
    @JsonProperty("entry_date")
    protected String entryDate;
    protected String reference;
    @JsonProperty("reference_type")
    protected String referenceType;
    @JsonProperty("account_id")
    protected String accountId;
    @JsonProperty("transaction_type")
    protected String transactionType;
    protected String balance;
    @JsonProperty("payer_name")
    protected String payerName;
}
