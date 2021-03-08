package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigurationResponse {

    @JsonProperty("commission_percent")
    private Integer commissionPercent;
    @JsonProperty("bank_slip")
    private ConfigurationBankSlipResponse bankSlip;
    @JsonProperty("credit_card")
    private ConfigurationCreditCard creditCard;
    @JsonProperty("pix")
    private ConfigurationPix pix;
    @JsonProperty("early_payment_discount")
    private Boolean earlyPaymentDiscount;

    public Integer getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(Integer commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public ConfigurationBankSlipResponse getBankSlip() {
        return bankSlip;
    }

    public void setBankSlip(ConfigurationBankSlipResponse bankSlip) {
        this.bankSlip = bankSlip;
    }

    public ConfigurationCreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(ConfigurationCreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Boolean getEarlyPaymentDiscount() {
        return earlyPaymentDiscount;
    }

    public void setEarlyPaymentDiscount(Boolean earlyPaymentDiscount) {
        this.earlyPaymentDiscount = earlyPaymentDiscount;
    }

    public ConfigurationPix getPix() {
        return pix;
    }

    public ConfigurationResponse setPix(ConfigurationPix pix) {
        this.pix = pix;
        return this;
    }

    @Override
    public String toString() {
        return "ConfigurationResponse{" +
                "commissionPercent=" + commissionPercent +
                ", bankSlip=" + bankSlip +
                ", creditCard=" + creditCard +
                ", pix=" + pix +
                '}';
    }
}
