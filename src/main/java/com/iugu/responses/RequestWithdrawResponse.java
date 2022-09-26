package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestWithdrawResponse {

    protected String id;
    protected String status;
    @JsonProperty("created_at")
    protected Date createdAt;
    @JsonProperty("updated_at")
    protected Date updatedAt;
    @JsonIgnore
    protected String reference;
    protected String feedback;
    protected String amount;
    @JsonProperty("account_name")
    protected String accountName;
    @JsonProperty("account_id")
    protected String accountId;
    @JsonProperty("bank_address")
    protected BankAddressResponse bankAddressResponse;
    @JsonProperty("custom_variables")
    protected List<CustomVariableResponse> customVariables;

}
