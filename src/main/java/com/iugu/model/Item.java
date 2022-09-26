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
public class Item {

    protected String id;
    protected String description;
    protected Integer quantity;
    @JsonProperty("price_cents")
    protected Integer priceCents;
    @JsonProperty("_destroy")
    protected Boolean destroy;

    public Item(String description, Integer quantity, Integer priceCents) {
        this.description = description;
        this.quantity = quantity;
        this.priceCents = priceCents;
    }

}
