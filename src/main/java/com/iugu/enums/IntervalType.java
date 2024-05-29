package com.iugu.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum IntervalType {

    WEEKS("weeks"),
    MONTHS("months");
    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

}
