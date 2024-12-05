package com.iugu.model.withdraw.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class WithdrawResponse {

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class CustomVariable {
        private String name;
        private String value;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class BankAddress {
        private String bank;
        @JsonProperty("bank_cc")
        private String bankCc;
        @JsonProperty("bank_ag")
        private String bankAg;
        @JsonProperty("account_type")
        private String accountType;
    }

    private String id;
    private String status;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    private String reference;
    private String feedback;
    private String paying_at;
    @JsonProperty("custom_variables")
    private List<CustomVariable> customVariables;
    private String amount;
    @JsonProperty("account_name")
    private String accountName;
    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("receipt_url")
    private String receiptUrl;
    @JsonProperty("agreement_effect")
    private Boolean agreementEffect;
    @JsonProperty("bank_address")
    private BankAddress bankAddress;
    @JsonAnySetter
    private Map<String, Object> any;

}
