package com.iugu.model.withdraw;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.interfaces.WithApiToken;
import com.iugu.model.CustomVariable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class RequestWithdraw implements WithApiToken {
    private BigDecimal amount;
    @JsonProperty("custom_variables")
    private List<CustomVariable> customVariables;
    @JsonProperty("api_token")
    private String apiToken;
}
