package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WithdrawConciliationsResponse {

    @JsonProperty("total_items")
    private String totalItems;
    @JsonProperty("withdraw_requests")
    private List<WithdrawRequestsItemResponse> withdrawRequests;

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public List<WithdrawRequestsItemResponse> getWithdrawRequests() {
        return withdrawRequests;
    }

    public void setWithdrawRequests(List<WithdrawRequestsItemResponse> withdrawRequests) {
        this.withdrawRequests = withdrawRequests;
    }

    @Override
    public String toString() {
        return "WithdrawConciliationsResponse{" +
                "totalItems='" + totalItems + '\'' +
                ", withdrawRequests=" + withdrawRequests +
                '}';
    }

}
