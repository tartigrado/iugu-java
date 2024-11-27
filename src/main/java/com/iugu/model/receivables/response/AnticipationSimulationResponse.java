package com.iugu.model.receivables.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class AnticipationSimulationResponse {
    private String errors;
    private String status;
    @JsonProperty("requested_advancement_cents")
    private Long requestedAdvancementCents;
    @JsonProperty("total_advance_fee_cents")
    private Long totalAdvanceFeeCents;
    @JsonProperty("reached_amount_cents")
    private Long reachedAmountCents;
    @JsonProperty("average_days")
    private Integer averageDays;
    @JsonProperty("simulation_expire_seconds")
    private Integer simulationExpireSeconds;
    @JsonProperty("receivables_schedule")
    private List<ReceivableSchedule> receivablesSchedule;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class ReceivableSchedule {
        private String date;
        @JsonProperty("transaction_code")
        private String transactionCode;
        @JsonProperty("amount_cents")
        private Long amountCents;
        @JsonProperty("advance_fee_cents")
        private Long advanceFeeCents;
    }
}
