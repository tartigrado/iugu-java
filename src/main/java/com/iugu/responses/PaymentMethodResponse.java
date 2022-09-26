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
public class PaymentMethodResponse {

    @JsonProperty("id")
    protected String id;
    @JsonProperty("description")
    protected String description;
    @JsonProperty("item_type")
    protected String itemType;
    @JsonProperty("data")
    protected ExtraInfoResponse data;

}
