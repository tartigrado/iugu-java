package com.iugu.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum PayableWith {

    CREDIT_CARD("credit_card"), ALL("all"), BANK_SLIP("bank_slip"), PIX("pix");

    private String value;

    PayableWith(String value) {
        this.value = value;
    }

    public static PayableWith getPayableWithByValue(String value) {
        return Arrays.stream(values()).filter(it -> it.getValue().equals(value)).findFirst().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
