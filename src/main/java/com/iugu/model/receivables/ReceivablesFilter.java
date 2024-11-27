package com.iugu.model.receivables;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class ReceivablesFilter {
    @QueryParam("limit")
    private Integer limit;
    @QueryParam("start")
    private Integer start;
    @QueryParam("status_filter")
    private String statusFilter;
    @QueryParam("since[year]")
    private Integer sinceYear;
    @QueryParam("since[month]")
    private Integer sinceMonth;
    @QueryParam("since[day]")
    private Integer sinceDay;
    @QueryParam("to[year]")
    private Integer toYear;
    @QueryParam("to[month]")
    private Integer toMonth;
    @QueryParam("to[day]")
    private Integer toDay;
}
