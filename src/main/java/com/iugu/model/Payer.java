package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payer {
    @JsonProperty("cpf_cnpj")
    protected String cpfCnpj;

    protected String name;

    @JsonProperty("phone_prefix")
    protected String phonePrefix;

    protected String phone;

    protected String email;

    protected Address address;

}
