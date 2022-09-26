package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtractInvoiceResponse {

    protected String id;
    @JsonProperty("created_at")
    protected Date createdAt;
    @JsonProperty("due_date")
    protected Date dueDate;
    @JsonProperty("paid_at")
    protected Date paidAt;
    @JsonProperty("pending_value")
    protected String pendingValue;
    @JsonProperty("paid_value")
    protected String paidValue;
    @JsonProperty("taxes_paid")
    protected String taxesPaid;
    @JsonProperty("payment_method")
    protected String paymentMethod;
    protected String installments;
    @JsonProperty("customer_id")
    protected String customerId;
    @JsonProperty("customer_email")
    protected String customerEmail;
    @JsonProperty("customer_name")
    protected String customerName;

}
