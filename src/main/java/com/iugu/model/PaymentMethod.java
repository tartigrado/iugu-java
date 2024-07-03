package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethod {

    protected String description;
    protected CardData cardData;
    @JsonProperty("item_type")
    protected ItemType itemType;
    protected String token;
    @JsonProperty("set_as_default")
    protected Boolean isDefault;

    public PaymentMethod(String description, String token, Boolean isDefault) {
        this.description = description;
        this.token = token;
        this.isDefault = isDefault;
    }

    public PaymentMethod(String description, CardData cardData, Boolean isDefault) {
        this.description = description;
        this.cardData = cardData;
        this.isDefault = isDefault;
    }

    public Boolean getDefault() {
        return getIsDefault();
    }
}
