package com.iugu.model.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class InvoiceRefund {
    @JsonProperty("partial_value_refund_cents")
    private Integer partialValueRefundCents;
}
