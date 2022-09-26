package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountVerificationResponse {

    protected String id;
    protected DataResponse data;
    @JsonProperty("account_id")
    protected String accountId;
    @JsonProperty("created_at")
    protected Date createdAt;
}
