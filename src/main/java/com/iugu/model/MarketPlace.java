package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.interfaces.WithApiToken;
import com.iugu.model.splits.Splits;
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
public class MarketPlace implements WithApiToken {

    protected String name;
    protected List<Splits> splits;
    @JsonProperty("api_token")
    protected String apiToken;

}
