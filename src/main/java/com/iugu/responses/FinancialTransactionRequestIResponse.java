package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FinancialTransactionRequestIResponse {

    private Integer totalItems;
    private List<FinancialTransactionRequestItemResponse> items;

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<FinancialTransactionRequestItemResponse> getItems() {
        return items;
    }

    public void setItems(List<FinancialTransactionRequestItemResponse> items) {
        this.items = items;
    }

}
