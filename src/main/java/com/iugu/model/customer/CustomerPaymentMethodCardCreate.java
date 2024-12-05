package com.iugu.model.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.card.CardData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CustomerPaymentMethodCardCreate {

    public static final String CREDIT_CARD = "credit_card";

    private String description;
    @JsonProperty("data")
    private CardData cardData;
    @Builder.Default
    @JsonProperty("item_type")
    private String itemType = CustomerPaymentMethodCardCreate.CREDIT_CARD;
    @JsonProperty("set_as_default")
    private Boolean asDefault;
    @JsonProperty("test")
    private Boolean test;
}
