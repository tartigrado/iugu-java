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
public class BankSlipResponse {

    @JsonProperty("digitable_line")
    protected String digitableLine;
    @JsonProperty("barcode_data")
    protected String barcodeData;
    protected String barcode;

}