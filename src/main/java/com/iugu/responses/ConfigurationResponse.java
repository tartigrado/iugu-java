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
public class ConfigurationResponse {

    @JsonProperty("commission_percent")
    protected Integer commissionPercent;
    @JsonProperty("bank_slip")
    protected ConfigurationBankSlipResponse bankSlip;
    @JsonProperty("credit_card")
    protected ConfigurationCreditCard creditCard;
    @JsonProperty("pix")
    protected ConfigurationPix pix;
    @JsonProperty("early_payment_discount")
    protected Boolean earlyPaymentDiscount;

}
