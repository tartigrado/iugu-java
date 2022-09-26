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
public class WithdrawRequestResponse {

    protected String id;
    protected String status;
    @JsonProperty("created_at")
    protected String createdAt;
    @JsonProperty("updated_at")
    protected String updatedAt;
    protected String amount;
    @JsonProperty("account_name")
    protected String accountName;
    @JsonProperty("account_id")
    protected String accountId;
    @JsonProperty("bank_address")
    protected BankAddressResponse bankAddress;

}
