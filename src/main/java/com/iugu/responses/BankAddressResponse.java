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
public class BankAddressResponse {

    protected String bank;
    @JsonProperty("bank_cc")
    protected String bankCc;
    @JsonProperty("bank_ag")
    protected String bankAg;
    @JsonProperty("account_type")
    protected String accountType;
}
