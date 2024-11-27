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
public class FinancialTransactionRequestItemResponse {

    protected Long id;
    protected String description;
    @JsonProperty("scheduled_date")
    protected String scheduledDate;
    @JsonProperty("transaction_code")
    protected String transactionCode;
    @JsonProperty("invoice_id")
    protected String invoiceId;
    @JsonProperty("customer_ref")
    protected String customerRef;
    @JsonProperty("order_id")
    protected String orderId;
    protected String total;
    protected String taxes;
    @JsonProperty("client_share")
    protected String clientShare;
    @JsonProperty("advance_fee")
    protected String advanceFee;
    protected String commission;
    @JsonProperty("total_cents")
    protected Long totalCents;
    @JsonProperty("taxes_cents")
    protected Long taxesCents;
    @JsonProperty("client_share_cents")
    protected Long clientShareCents;
    @JsonProperty("number_of_installments")
    protected Integer numberOfInstallments;
    protected Integer installment;

}
