package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.interfaces.WithApiToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAddress implements WithApiToken {

    protected String agency;
    protected String account;
    @JsonProperty("account_type")
    protected String accountType;
    protected String bank;
    @JsonProperty("automatic_validation")
    protected Boolean automaticValidation;
    protected File document;
    @JsonProperty("RAW_BODY")
    private String rawBody;
    @JsonProperty("api_token")
    protected String apiToken;

}
