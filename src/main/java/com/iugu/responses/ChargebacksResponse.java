package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargebacksResponse {

    private FacetsResponse facets;
    private List<ChargebackResponse> items;

    public FacetsResponse getFacets() {
        return facets;
    }

    public void setFacets(FacetsResponse facets) {
        this.facets = facets;
    }

    public List<ChargebackResponse> getItems() {
        return items;
    }

    public void setItems(List<ChargebackResponse> items) {
        this.items = items;
    }

}
