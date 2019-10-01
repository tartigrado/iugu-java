package com.iugu.responses;

public class TotalTransfersResponse {

    private Integer sent;
    private Integer received;

    public Integer getSent() {
        return sent;
    }

    public void setSent(Integer sent) {
        this.sent = sent;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }

    @Override
    public String toString() {
        return "TotalTransfersResponse{" +
                "sent=" + sent +
                ", received=" + received +
                '}';
    }

}
