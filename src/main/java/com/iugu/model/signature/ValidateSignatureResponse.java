package com.iugu.model.signature;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class ValidateSignatureResponse {
    private String message;
    @JsonProperty("request_body")
    private Object requestBody;
}
