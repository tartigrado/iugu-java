package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogResponse {

    protected String id;
    protected String description;
    protected String notes;
    @JsonProperty("subscription_changes")
    protected String subscriptionChanges;
    @JsonProperty("created_at")
    protected String createdAt;
}