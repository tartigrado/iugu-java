package com.iugu.model.withdraw.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class WithdrawsResponse {
    private List<WithdrawResponse> items;
    private Integer totalItems;
}
