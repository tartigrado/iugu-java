package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.interfaces.WithApiToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transfer implements WithApiToken {

    @JsonProperty("receiver_id")
    private String receiverId;

    @JsonProperty("amount_cents")
    private int amountCents;

    @JsonProperty("api_token")
    private String apiToken;

}
