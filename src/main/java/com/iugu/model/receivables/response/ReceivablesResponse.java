package com.iugu.model.receivables.response;

import com.iugu.responses.FinancialTransactionRequestItemResponse;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public final class ReceivablesResponse {
    private Integer totalItems;
    private List<FinancialTransactionRequestItemResponse> items;
}
