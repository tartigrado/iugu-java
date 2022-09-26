package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.Currency;
import com.iugu.enums.IntervalType;
import com.iugu.enums.PayableWith;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plan {

    protected String name;

    protected String identifier;

    protected String interval;

    @JsonProperty("interval_type")
    protected IntervalType intervalType;

    protected Currency currency;

    @JsonProperty("value_cents")
    protected int valueCents;

    @JsonProperty("payable_with")
    protected List<PayableWith> payableWith;

    protected List<Price> prices;

    protected List<Feature> features;

    public Plan(String name, String identifier, String interval, IntervalType intervalType, Currency currency,
                int valueCents) {
        this.name = name;
        this.identifier = identifier;
        this.interval = interval;
        this.intervalType = intervalType;
        this.currency = currency;
        this.valueCents = valueCents;
    }

}
