package com.iugu.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.iugu.interfaces.WithApiToken;
import com.iugu.model.EarlyPaymentDiscount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EarlyPaymentConfig implements WithApiToken {
    protected Boolean earlyPaymentDiscount;
    protected List<EarlyPaymentDiscount> earlyPaymentDiscounts;
    @JsonProperty("api_token")
    protected String apiToken;
}
