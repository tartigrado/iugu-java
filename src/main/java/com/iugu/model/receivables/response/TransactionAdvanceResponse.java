package com.iugu.model.receivables.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
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
@Builder
public final class TransactionAdvanceResponse {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class Transaction {
        private Long id;
        @JsonProperty("advanced_value")
        private String advancedValue;
        @JsonProperty("advance_fee")
        private String advanceFee;
        @JsonProperty("received_value")
        private String receivedValue;
        @JsonAnySetter
        private Map<String, Object> any;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class Total {
        @JsonProperty("advanced_value")
        private String advancedValue;
        @JsonProperty("advance_fee")
        private String advanceFee;
        @JsonProperty("received_value")
        private String receivedValue;
        @JsonAnySetter
        private Map<String, Object> any;
    }

    private List<Transaction> transactions;
    private Total total;
    @JsonAnySetter
    private Map<String, Object> any;

}
