package com.iugu.model.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.interfaces.invoice.InvoiceItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class InvoiceItemCreate implements InvoiceItem {
    private String description;
    private Integer quantity;
    @JsonProperty("price_cents")
    private Integer priceCents;
}
