package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PixResponse {
    @JsonProperty("qrcode")
    private String qrCode;

    @JsonProperty("qrcode_text")
    private String qrCodeText;

    private String status;

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrCodeText() {
        return qrCodeText;
    }

    public void setQrCodeText(String qrCodeText) {
        this.qrCodeText = qrCodeText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
