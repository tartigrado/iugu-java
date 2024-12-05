package com.iugu.model.token.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.card.CardDataResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class PaymentTokenResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("method")
    private String method;

    @JsonProperty("test")
    private Boolean test;

    @JsonProperty("extra_info")
    private CardDataResponse extraInfo;
}
