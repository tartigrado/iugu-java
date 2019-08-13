package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacetsResponse {

    private PendingResponse pending;

    public PendingResponse getPending() {
        return pending;
    }

    public void setPending(PendingResponse pending) {
        this.pending = pending;
    }

}
