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
public class PriceResponse {

    protected String id;
    protected String currency;
    @JsonProperty("plan_id")
    protected String planId;
    @JsonProperty("value_cents")
    protected Integer valueCents;

}
