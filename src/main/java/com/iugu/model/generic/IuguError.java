package com.iugu.model.generic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public final class IuguError {
    private Object errors;

    @JsonIgnore
    public String getMainMessage() {
        if (errors instanceof String) {
            return (String) errors;
        } else if (errors instanceof Map<?, ?> map) {
            final List<String> allErrors = new ArrayList<>();
            map.forEach((k, v) -> allErrors.add(k + " " + v));
            return String.join(", ", allErrors);
        } else {
            return errors.toString();
        }
    }
}
