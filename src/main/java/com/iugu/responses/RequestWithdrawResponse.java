package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestWithdrawResponse {

    private String id;
    private String status;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonIgnore
    private String reference;
    private String feedback;
    private String amount;
    @JsonProperty("account_name")
    private String accountName;
    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("bank_address")
    private BankAddressResponse bankAddressResponse;
    @JsonProperty("custom_variables")
    private List<CustomVariableResponse> customVariables;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BankAddressResponse getBankAddressResponse() {
        return bankAddressResponse;
    }

    public void setBankAddressResponse(BankAddressResponse bankAddressResponse) {
        this.bankAddressResponse = bankAddressResponse;
    }

    public List<CustomVariableResponse> getCustomVariables() {
        return customVariables;
    }

    public void setCustomVariables(List<CustomVariableResponse> customVariables) {
        this.customVariables = customVariables;
    }

    @Override
    public String toString() {
        return "RequestWithdrawResponse{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", feedback='" + feedback + '\'' +
                ", amount='" + amount + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountId='" + accountId + '\'' +
                ", bankAddressResponse=" + bankAddressResponse +
                ", customVariables=" + customVariables +
                '}';
    }

}
