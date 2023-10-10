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
    private String digitableLine;
    @JsonProperty("barcode_data")
    private String barcodeData;
    @JsonProperty("barcode")
    private String barcode;
    @JsonProperty("bank_slip_bank")
    private int bankSlipBank;
    @JsonProperty("bank_slip_status")
    private String bankSlipStatus;
    @JsonProperty("bank_slip_error_code")
    private String bankSlipErrorCode;
    @JsonProperty("bank_slip_error_message")
    private String bankSlipErrorMessage;
    @JsonProperty("recipient_cpf_cnpj")
    private String recipientCpfCnpj;

}