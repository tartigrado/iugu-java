package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SplitsResponse {

    private String id;
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
    @JsonProperty("pix_cents")
    private Float pixCents;
    @JsonProperty("pix_percent")
    private Float pixPercent;
    @JsonProperty("permit_aggregated")
    private Boolean permitAggregated;
    @JsonProperty("recipient_account_id")
    private String recipientAccountId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Float getPixCents() {
        return pixCents;
    }

    public void setPixCents(Float pixCents) {
        this.pixCents = pixCents;
    }

    public Float getPixPercent() {
        return pixPercent;
    }

    public void setPixPercent(Float pixPercent) {
        this.pixPercent = pixPercent;
    }

    public Boolean getPermitAggregated() {
        return permitAggregated;
    }

    public void setPermitAggregated(Boolean permitAggregated) {
        this.permitAggregated = permitAggregated;
    }

    public String getRecipientAccountId() {
        return recipientAccountId;
    }

    public void setRecipientAccountId(String recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }
}
