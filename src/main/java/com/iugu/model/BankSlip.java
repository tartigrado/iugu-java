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
public class BankSlip {

    protected Boolean active;
    @JsonProperty("extra_due")
    protected Integer extraDue;
    @JsonProperty("reprint_extra_due")
    protected Integer reprintExtraDue;

}
