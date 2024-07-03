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
public class ExtraInfoResponse {
    @JsonProperty("brand")
    protected Object brand;
    @JsonProperty("holder_name")
    protected Object holderName;
    @JsonProperty("display_number")
    protected Object displayNumber;
    @JsonProperty("last_digits")
    protected Object lastDigits;
    @JsonProperty("first_digits")
    protected Object firstDigits;
    @JsonProperty("masked_number")
    protected Object maskedNumber;
    @JsonProperty("bin")
    protected Object bin;
    @JsonProperty("fingerprint")
    protected Object fingerprint;
    @JsonProperty("billing_address")
    protected Object billingAddress;
    @JsonProperty("issuer")
    protected String issuer;
    @JsonProperty("issuer_code")
    protected String issuerCode;
    @JsonProperty("card_type")
    protected String cardType;
    @JsonProperty("foreign_card")
    protected String foreignCard;
    @JsonProperty("remote_ip")
    protected Object remoteIp;
    @JsonProperty("month")
    protected Integer month;
    @JsonProperty("year")
    protected Integer year;
}
