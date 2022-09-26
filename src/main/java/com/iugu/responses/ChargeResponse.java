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
public class ChargeResponse {

    @JsonProperty("message")
    protected String message;
    @JsonProperty("success")
    protected Boolean success;
    @JsonProperty("url")
    protected String url;
    @JsonProperty("pdf")
    protected String pdf;
    @JsonProperty("invoice_id")
    protected String invoiceId;
    @JsonProperty("LR")
    protected String lr;
}
