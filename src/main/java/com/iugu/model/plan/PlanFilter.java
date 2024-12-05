package com.iugu.model.plan;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class PlanFilter {
    @QueryParam("start")
    private Integer start;
    @QueryParam("limit")
    private Integer limit;
    @QueryParam("query")
    private String query;
    @QueryParam("updated_at_since")
    private String updatedAtSince;
}
