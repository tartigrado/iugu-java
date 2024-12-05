package com.iugu.model.customer.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.card.CardDataResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CustomerPaymentMethodResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("customer_id")
    private String customerId;
    @JsonProperty("test")
    private Boolean test;
    @JsonProperty("item_type")
    private String itemType;
    @JsonProperty("data")
    private CardDataResponse data;
    @JsonAnySetter
    private Map<String, Object> any;

}
