package com.iugu.model.subscription;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class SubscriptionFilter {
    private Integer limit;
    private Integer start;
    @QueryParam("created_at_from")
    private String createdAtFrom;
    @QueryParam("created_at_to")
    private String createdAtTo;
    private String query;
    @QueryParam("updated_since")
    private String updatedSince;
    @QueryParam("customer_id")
    private String customerId;
    @QueryParam("status_filter")
    private String statusFilter;
    @QueryParam("plan_identifier")
    private String planIdentifier;
}
