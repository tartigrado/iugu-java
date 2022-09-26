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
public class ConfigurationBankSlipResponse {

    protected Boolean active;
    @JsonProperty("extra_due")
    protected String extraDue;
    @JsonProperty("reprint_extra_due")
    protected String reprintExtraDue;

}
