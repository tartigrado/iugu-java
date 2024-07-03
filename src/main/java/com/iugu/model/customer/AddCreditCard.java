package com.iugu.model.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.CardData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class AddCreditCard {
    @JsonProperty("card_data")
    private CardData cardData;
    @JsonProperty("customer_id")
    private String customerId;
    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("set_as_default")
    private Boolean asDefault;
    @JsonProperty("is_test")
    private Boolean asTest;
    @JsonProperty("description")
    private String description;
}
