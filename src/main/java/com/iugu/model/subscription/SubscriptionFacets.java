package com.iugu.model.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class SubscriptionFacets {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static final class TypeCount {
        @JsonProperty("_type")
        private String type;
        private Integer count;
    }

    private TypeCount due;
    private TypeCount active;
    private TypeCount suspended;
}
