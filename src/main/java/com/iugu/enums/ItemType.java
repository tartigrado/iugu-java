package com.iugu.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ItemType {

    CREDIT_CARD("credit_card");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

}
