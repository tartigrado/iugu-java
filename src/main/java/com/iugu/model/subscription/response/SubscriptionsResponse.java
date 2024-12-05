package com.iugu.model.subscription.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.iugu.model.subscription.SubscriptionFacets;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class SubscriptionsResponse {

    private Integer totalItems;
    private SubscriptionFacets facets;
    private List<SubscriptionResponse> items;
    @JsonAnySetter
    private Map<String, Object> any;
}
