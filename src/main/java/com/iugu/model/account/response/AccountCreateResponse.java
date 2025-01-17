package com.iugu.model.account.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class AccountCreateResponse {

    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("live_api_token")
    private String liveApiToken;
    @JsonProperty("test_api_token")
    private String testApiToken;
    @JsonProperty("user_token")
    private String userToken;

}
