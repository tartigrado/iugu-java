package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public final class CreditCard {

    private Boolean active;
    private String softDescriptor;
    private Boolean installments;
    private Integer maxInstallments;
    private String maxInstallmentsWithoutInterest;
    private Boolean twoStepTransaction;
    private Boolean installmentsPassInterest;
}
