package com.iugu.model.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.PayableWith;
import com.iugu.model.card.CardData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class PaymentTokenCreate {

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
