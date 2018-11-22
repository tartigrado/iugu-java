package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionAdvanceTotalResponse {

    @JsonProperty("advanced_value")
    private String advancedValue;
    @JsonProperty("advance_fee")
    private String advanceFee;
    @JsonProperty("received_value")
    private String receivedValue;

    public String getAdvancedValue() {
        return advancedValue;
    }

    public void setAdvancedValue(String advancedValue) {
        this.advancedValue = advancedValue;
    }

    public String getAdvanceFee() {
        return advanceFee;
    }

    public void setAdvanceFee(String advanceFee) {
        this.advanceFee = advanceFee;
    }

    public String getReceivedValue() {
        return receivedValue;
    }

    public void setReceivedValue(String receivedValue) {
        this.receivedValue = receivedValue;
    }

}
