package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Commissions {

    private Integer cents;
    private Float percent;
    @JsonProperty("credit_card_cents")
    private Integer creditCardCents;
    @JsonProperty("credit_card_percent")
    private Float creditCardPercent;
    @JsonProperty("bank_slip_cents")
    private Integer bankSlipCents;
    @JsonProperty("bank_slip_percent")
    private Float bankSlipPercent;

    public Integer getCents() {
        return cents;
    }

    public void setCents(Integer cents) {
        this.cents = cents;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }

    public Integer getCreditCardCents() {
        return creditCardCents;
    }

    public void setCreditCardCents(Integer creditCardCents) {
        this.creditCardCents = creditCardCents;
    }

    public Float getCreditCardPercent() {
        return creditCardPercent;
    }

    public void setCreditCardPercent(Float creditCardPercent) {
        this.creditCardPercent = creditCardPercent;
    }

    public Integer getBankSlipCents() {
        return bankSlipCents;
    }

    public void setBankSlipCents(Integer bankSlipCents) {
        this.bankSlipCents = bankSlipCents;
    }

    public Float getBankSlipPercent() {
        return bankSlipPercent;
    }

    public void setBankSlipPercent(Float bankSlipPercent) {
        this.bankSlipPercent = bankSlipPercent;
    }

    @Override
    public String toString() {
        return "Commissions{" +
                "cents=" + cents +
                ", percent=" + percent +
                ", creditCardCents=" + creditCardCents +
                ", creditCardPercent=" + creditCardPercent +
                ", bankSlipCents=" + bankSlipCents +
                ", bankSlipPercent=" + bankSlipPercent +
                '}';
    }

}
