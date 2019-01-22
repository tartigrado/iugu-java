package com.iugu.responses;

import java.util.List;

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
