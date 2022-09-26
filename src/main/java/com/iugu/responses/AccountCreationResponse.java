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
public class AccountCreationResponse {

    @JsonProperty("account_id")
    protected String accountId;
    @JsonProperty("name")
    protected String name;
    @JsonProperty("live_api_token")
    protected String liveApiToken;
    @JsonProperty("test_api_token")
    protected String testApiToken;
    @JsonProperty("user_token")
    protected String userToken;

}
