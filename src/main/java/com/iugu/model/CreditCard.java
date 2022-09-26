package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCard {

    protected Boolean active;
    @JsonProperty("soft_descriptor")
    protected String softDescriptor;
    protected Boolean installments;
    @JsonProperty("max_installments")
    protected Integer maxInstallments;
    @JsonProperty("max_installments_without_interest")
    protected String maxInstallmentsWithoutInterest;
    @JsonProperty("two_step_transaction")
    protected Boolean twoStepTransaction;
    @JsonProperty("installments_pass_interest")
    protected Boolean installmentsPassInterest;

}
