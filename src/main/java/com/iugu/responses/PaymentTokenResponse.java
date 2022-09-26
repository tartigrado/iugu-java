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
public class PaymentTokenResponse {

    @JsonProperty("id")
    protected String id;

    @JsonProperty("method")
    protected String method;

    @JsonProperty("test")
    protected Boolean isTest;

    @JsonProperty("extra_info")
    protected ExtraInfoResponse extraInfo;
}
