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
public class LastWithdrawResponse {

    @JsonProperty("account_id")
    protected String accountId;
    @JsonProperty("account_type")
    protected String accountType;
    protected String amount;
    protected String bank;
    @JsonProperty("bank_ag")
    protected String bankAg;
    @JsonProperty("bank_cc")
    protected String bankCc;
    @JsonProperty("created_at")
    protected Date created_at;
    protected String feedback;
    protected String id;
    protected String reference;
    protected String status;
    @JsonProperty("updated_at")
    protected Date updatedAt;

}
