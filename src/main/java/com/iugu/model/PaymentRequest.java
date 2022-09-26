package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRequest {

    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_PROCESSING = "processing";
    public static final String STATUS_REJECTED = "rejected";
    public static final String STATUS_DONE = "done";

    protected String id;
    @JsonProperty("account_id")
    protected String accountId;
    protected String barcode;
    protected String status;
    @JsonProperty("document_amount_cents")
    protected Integer documentAmountCents;
    @JsonProperty("amount_cents")
    protected Integer amountCents;
    protected String description;
    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    protected Date createdAt;
    @JsonProperty("updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    protected Date updatedAt;

    public PaymentRequest(String barcode, Integer amountCents, Integer documentAmountCents) {
        this.barcode = barcode;
        this.amountCents = amountCents;
        this.documentAmountCents = documentAmountCents;
    }

}
