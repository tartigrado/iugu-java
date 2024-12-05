package com.iugu.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum PayableWith {

    CREDIT_CARD("credit_card"), ALL("all"), BANK_SLIP("bank_slip"), PIX("pix");

    private final String value;

    public static PayableWith getPayableWithByValue(String value) {
        return Arrays.stream(values()).filter(it -> it.getValue().equals(value)).findFirst().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
