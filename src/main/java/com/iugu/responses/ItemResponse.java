package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse {

    protected String id;
    protected String description;
    protected Integer quantity;
    @JsonProperty("price_cents")
    protected Integer priceCents;
    @JsonProperty("created_at")
    protected String createdAt;
    @JsonProperty("updated_at")
    protected Date updatedAt;
    protected String price;


}
