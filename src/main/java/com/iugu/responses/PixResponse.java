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
public class PixResponse {
    @JsonProperty("qrcode")
    private String qrcode;
    @JsonProperty("qrcode_text")
    private String qrcodeText;
    private String status;
    @JsonProperty("payer_cpf_cnpj")
    private String payerCpfCnpj;
    @JsonProperty("payer_name")
    private String payerName;
    @JsonProperty("end_to_end_id")
    private String endToEndId;
    @JsonProperty("end_to_end_refund_id")
    private String endToEndRefundId;
    @JsonProperty("account_number_last_digits")
    private String accountNumberLastDigits;
}
