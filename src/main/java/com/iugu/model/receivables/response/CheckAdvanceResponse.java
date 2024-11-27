package com.iugu.model.receivables.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CheckAdvanceResponse {

    private String progressPercent;
    private Long currentAmountCents;
    private Long currentAdvanceFeeCents;
    private String status;
    private String advancementRequestDate;
    private Map<String, Object> transactionIds;
}
