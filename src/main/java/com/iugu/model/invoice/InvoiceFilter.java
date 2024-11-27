package com.iugu.model.invoice;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class InvoiceFilter {
    @QueryParam("limit")
    private Integer limit;
    @QueryParam("start")
    private Integer start;
    @QueryParam("created_at_from")
    private String createdAtFrom;
    @QueryParam("created_at_to")
    private String createdAtTo;
    @QueryParam("paid_at_from")
    private String paidAtFrom;
    @QueryParam("paid_at_to")
    private String paidAtTo;
    @QueryParam("due_date")
    private String dueDate;
    @QueryParam("query")
    private String query;
    @QueryParam("updated_since")
    private String updatedSince;
    @QueryParam("customer_id")
    private String customerId;
    @QueryParam("status_filter")
    private String statusFilter;
}
