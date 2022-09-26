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

    @JsonProperty("bin")
    protected Object bin;

    @JsonProperty("month")
    protected Integer month;

    @JsonProperty("year")
    protected Integer year;

}
