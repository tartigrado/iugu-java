package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class EarlyPaymentDiscount {

    private Integer days;
    @JsonProperty("value_cents")
    private Integer valueCents;
    private BigDecimal percent;

    public void setPercent(BigDecimal percent) {
        this.percent = Optional.ofNullable(percent).map(it -> it.setScale(2, RoundingMode.HALF_EVEN)).orElse(percent);
    }
}
