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
public class PaymentRequestResponse implements Serializable {
    protected final String MY_TIME_ZONE = "America/Fortaleza";

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = MY_TIME_ZONE)
    protected Date createdAt;
    @JsonProperty("updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = MY_TIME_ZONE)
    protected Date updatedAt;
    @JsonProperty("payment_info")
    protected PaymentInfo paymentInfo;

}
