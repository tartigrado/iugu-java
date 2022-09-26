package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Splits {

    protected Integer cents;
    protected Float percent;
    @JsonProperty("credit_card_cents")
    protected Integer creditCardCents;
    @JsonProperty("credit_card_percent")
    protected Float creditCardPercent;
    @JsonProperty("bank_slip_cents")
    protected Integer bankSlipCents;
    @JsonProperty("bank_slip_percent")
    protected Float bankSlipPercent;
    @JsonProperty("permit_aggregated")
    protected Boolean permitAggregated;
    @JsonProperty("recipient_account_id")
    protected String recipientAccountId;
    @JsonProperty("pix_cents")
    protected Integer pixCents;
    @JsonProperty("pix_percent")
    protected Float pixPercent;

}
