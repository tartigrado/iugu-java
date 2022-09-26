package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestVerification {

    @JsonProperty("account_id")
    protected String accountId;
    @JsonProperty("automatic_validation")
    protected Boolean automaticValidation;
    protected DataRequestVerification data;

    public RequestVerification(String accountId, DataRequestVerification data) {
        this.accountId = accountId;
        this.data = data;
    }
}