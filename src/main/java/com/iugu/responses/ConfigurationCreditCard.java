package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigurationCreditCard {

    protected Boolean active;
    @JsonProperty("soft_descriptor")
    protected String softDescriptor;
    protected Boolean installments;
    @JsonProperty("installments_pass_interest")
    protected Boolean installmentsPassInterest;
    @JsonProperty("max_installments")
    protected String maxInstallments;
    @JsonProperty("max_installments_without_interest")
    protected String maxInstallmentsWithoutInterest;
    @JsonProperty("two_step_transaction")
    protected Boolean twoStepTransaction;

}
