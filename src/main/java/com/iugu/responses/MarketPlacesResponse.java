package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.MarketPlace;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketPlacesResponse {

    private Integer totalItems;
    private List<MarketPlaceResponse> items;

    public Integer getTotalItems() { return totalItems; }

    public void setTotalItems(Integer totalItems) { this.totalItems = totalItems; }

    public List<MarketPlaceResponse> getItems() { return items; }

    public void setItems(List<MarketPlaceResponse> items) { this.items = items; }

    @Override
    public String toString() {
        return "MarketPlacesResponse{" + "totalItems=" + totalItems + ", items=" + items + '}';
    }
}
