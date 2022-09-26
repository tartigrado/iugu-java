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
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Pix {
    @JsonProperty("qrcode")
    protected String qrCode;

    @JsonProperty("qrcode_text")
    protected String qrCodeText;

    protected String status;

}
