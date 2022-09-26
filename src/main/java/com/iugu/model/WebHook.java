package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebHook implements Serializable {

    @JsonProperty(value = "event")
    private String event;

    @JsonProperty("data[id]")
    private String id;

    @JsonProperty("data[account_id]")
    private String accountId;

    @JsonProperty("data[status]")
    private String status;

    @JsonProperty("data[subscription_id]")
    private String subscriptionId;

}