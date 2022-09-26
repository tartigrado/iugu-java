package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanResponse {

    protected String id;
    protected String name;
    protected String identifier;
    protected String interval;
    @JsonProperty("interval_type")
    protected String intervalType;
    protected List<PriceResponse> prices;
    protected List<FeatureResponse> features;
    @JsonProperty("payable_with")
    protected Object payableWith;
}
