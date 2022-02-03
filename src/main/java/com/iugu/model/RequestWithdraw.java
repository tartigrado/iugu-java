package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestWithdraw {

    private Integer amount;
    @JsonProperty("custom_variables")
    private List<CustomVariable> customVariables;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<CustomVariable> getCustomVariables() {
        return customVariables;
    }

    public void setCustomVariables(List<CustomVariable> customVariables) {
        this.customVariables = customVariables;
    }

    @Override
    public String toString() {
        return "RequestWithdraw{" +
                "amount=" + amount +
                ", customVariables=" + customVariables +
                '}';
    }
}
