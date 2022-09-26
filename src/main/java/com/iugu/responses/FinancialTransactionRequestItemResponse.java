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
    @JsonProperty("invoice_id")
    protected String invoiceId;
    @JsonProperty("customer_ref")
    protected String customerRef;
    protected String total;
    protected String taxes;
    @JsonProperty("client_share")
    protected String clientShare;
    protected String commission;
    @JsonProperty("number_of_installments")
    protected Integer numberOfInstallments;
    protected Integer installment;

}
