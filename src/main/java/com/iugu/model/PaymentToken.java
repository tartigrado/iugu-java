package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.PayableWith;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentToken {

    @JsonProperty("account_id")
    protected String accountId;

    @JsonProperty("method")
    protected PayableWith payableWith;

    @JsonProperty("test")
    protected Boolean isTest;

    @JsonProperty("data")
    protected Data data;

}
