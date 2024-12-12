package com.iugu.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public final class Jackson {
    public static ObjectMapper getInstance() {
        return Holder.INSTANCE;
    }

    public static final class Holder {
        private static final ObjectMapper INSTANCE = JsonMapper
                .builder()
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .build();
    }
}
