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
public class InitialBalanceResponse {

    protected String amount;
    @JsonProperty("amount_cents")
    protected String amountCents;
    @JsonProperty("entry_date")
    protected String entryDate;

}
