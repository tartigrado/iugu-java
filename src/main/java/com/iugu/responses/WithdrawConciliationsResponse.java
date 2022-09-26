package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WithdrawConciliationsResponse {

    @JsonProperty("total_items")
    protected String totalItems;
    @JsonProperty("withdraw_requests")
    protected List<WithdrawRequestsItemResponse> withdrawRequests;

}
