package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentConfiguration {

    public PaymentConfiguration() { }

    public PaymentConfiguration(Boolean enable) {
        this.enable = enable;
    }

    private Boolean enable;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
