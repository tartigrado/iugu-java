package com.iugu.model.invoice.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class InvoicesResponse {

    private Integer totalItems;
    private List<InvoiceResponse> items;
    private InvoiceFacets facets;

}
