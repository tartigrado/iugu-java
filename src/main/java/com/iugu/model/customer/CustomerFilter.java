package com.iugu.model.customer;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class CustomerFilter {
    @QueryParam("limit")
    private Integer limit;
    @QueryParam("start")
    private Integer start;
    @QueryParam("created_at_from")
    private String createdAtFrom;
    @QueryParam("created_at_to")
    private String createdAtTo;
    @QueryParam("query")
    private String query;
    @QueryParam("updated_since")
    private String updatedSince;
}
