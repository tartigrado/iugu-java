package com.iugu.model.payment_token;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.PayableWith;
import com.iugu.model.CardData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CreatePaymentToken {

    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("method")
    @Builder.Default
    private PayableWith payableWith = PayableWith.CREDIT_CARD;

    @JsonProperty("test")
    private Boolean test;

    @JsonProperty("data")
    private CardData cardData;

}
