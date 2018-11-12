package com.iugu.responses;

import java.util.List;

public class WithdrawConciliationsResponse {

    private String totalItems;
    private List<WithdrawRequestsItemResponse> withdraw_requests;

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public List<WithdrawRequestsItemResponse> getWithdraw_requests() {
        return withdraw_requests;
    }

    public void setWithdraw_requests(List<WithdrawRequestsItemResponse> withdraw_requests) {
        this.withdraw_requests = withdraw_requests;
    }

    @Override
    public String toString() {
        return "WithdrawConciliationsResponse{" +
                "totalItems='" + totalItems + '\'' +
                ", withdraw_requests=" + withdraw_requests +
                '}';
    }

}
