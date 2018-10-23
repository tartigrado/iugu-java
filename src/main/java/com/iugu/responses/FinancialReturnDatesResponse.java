package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinancialReturnDatesResponse {

    private String installment;
    @JsonProperty("return_date")
    private String returnDate;
    private String status;
    private String amount;

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
