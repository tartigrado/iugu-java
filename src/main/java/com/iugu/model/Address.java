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
public class Address {

    @JsonProperty("zip_code")
    protected String zipCode;
    protected String street;
    protected String number;
    protected String district;
    protected String city;
    protected String state;
    protected String country;
    protected String complement;

}
