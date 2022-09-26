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
public class FeatureResponse {

    protected String id;
    protected String identifier;
    protected Boolean important;
    protected String name;
    @JsonProperty("plan_id")
    protected String planId;
    protected Integer position;
    protected Integer value;

}
