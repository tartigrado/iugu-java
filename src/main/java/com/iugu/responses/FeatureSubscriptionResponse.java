package com.iugu.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureSubscriptionResponse {
    protected String identifier;
    protected String name;

}
