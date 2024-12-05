package com.iugu.model.card;


import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CardDataResponse {
    @JsonProperty("brand")
    private Object brand;
    @JsonProperty("holder_name")
    private Object holderName;
    @JsonProperty("display_number")
    private Object displayNumber;
    @JsonProperty("last_digits")
    private Object lastDigits;
    @JsonProperty("first_digits")
    private Object firstDigits;
    @JsonProperty("masked_number")
    private Object maskedNumber;
    @JsonProperty("bin")
    private Object bin;
    @JsonProperty("fingerprint")
    private Object fingerprint;
    @JsonProperty("billing_address")
    private Object billingAddress;
    @JsonProperty("issuer")
    private String issuer;
    @JsonProperty("issuer_code")
    private String issuerCode;
    @JsonProperty("card_type")
    private String cardType;
    @JsonProperty("foreign_card")
    private String foreignCard;
    @JsonProperty("remote_ip")
    private Object remoteIp;
    @JsonProperty("month")
    private Integer month;
    @JsonProperty("year")
    private Integer year;
    @JsonAnySetter
    private Map<String, Object> any;
}
