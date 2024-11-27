package com.iugu.model.receivables.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public final class ReceivableResponse {
    private Long id;
    private String description;
    @JsonProperty("scheduled_date")
    private String scheduledDate;
    @JsonProperty("transaction_code")
    private String transactionCode;
    @JsonProperty("invoice_id")
    private String invoiceId;
    @JsonProperty("customer_ref")
    private String customerRef;
    @JsonProperty("order_id")
    private String orderId;
    private String total;
    private String taxes;
    @JsonProperty("client_share")
    private String clientShare;
    @JsonProperty("advance_fee")
    private String advanceFee;
    private String commission;
    @JsonProperty("total_cents")
    private Long totalCents;
    @JsonProperty("taxes_cents")
    private Long taxesCents;
    @JsonProperty("client_share_cents")
    private Long clientShareCents;
    @JsonProperty("number_of_installments")
    private Integer numberOfInstallments;
    private Integer installment;
}
