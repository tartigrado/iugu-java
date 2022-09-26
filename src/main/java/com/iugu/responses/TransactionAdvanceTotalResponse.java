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
public class TransactionAdvanceTotalResponse {

    @JsonProperty("advanced_value")
    protected String advancedValue;
    @JsonProperty("advance_fee")
    protected String advanceFee;
    @JsonProperty("received_value")
    protected String receivedValue;

}
