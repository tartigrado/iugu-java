package com.iugu.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Currency {

    BRL("BRL");

    private final String value;

    Currency(String value) {
        this.value = value;
    }

    public static Currency getCurrencyByValue(String value) {
        return Arrays.stream(values()).filter(it -> it.getValue().equals(value)).findFirst().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
