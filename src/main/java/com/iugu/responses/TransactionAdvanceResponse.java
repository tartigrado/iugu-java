package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionAdvanceResponse {

    private List<TransactionAdvanceTransactionsResponse> transactions;
    private TransactionAdvanceTotalResponse total;

    public List<TransactionAdvanceTransactionsResponse> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionAdvanceTransactionsResponse> transactions) {
        this.transactions = transactions;
    }

    public TransactionAdvanceTotalResponse getTotal() {
        return total;
    }

    public void setTotal(TransactionAdvanceTotalResponse total) {
        this.total = total;
    }

}
