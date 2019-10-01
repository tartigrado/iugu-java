package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransfersResponse {

    @JsonProperty("sent")
    private List<TransferResponse> sent;
    @JsonProperty("received")
    private List<TransferResponse> received;
    private TotalTransfersResponse totals;

    public List<TransferResponse> getSent() {
        return sent;
    }

    public void setSent(List<TransferResponse> sent) {
        this.sent = sent;
    }

    public List<TransferResponse> getReceived() {
        return received;
    }

    public void setReceived(List<TransferResponse> received) {
        this.received = received;
    }

    public TotalTransfersResponse getTotals() {
        return totals;
    }

    public void setTotals(TotalTransfersResponse totals) {
        this.totals = totals;
    }

    @Override
    public String toString() {
        return "TransfersResponse{" +
                "sent=" + sent +
                ", received=" + received +
                ", totals=" + totals +
                '}';
    }

}
