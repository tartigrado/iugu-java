package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer implements Serializable {

    protected String email;
    protected String name;
    protected String notes;
    @JsonProperty("cpf_cnpj")
    protected String cpfCnpj;
    @JsonProperty("cc_emails")
    protected String ccEmails;
    @JsonProperty("zip_code")
    protected String zipCode;
    protected String number;
    protected String street;
    protected String city;
    protected String state;
    protected String district;
    protected String complement;
    @JsonProperty("custom_variables")
    protected List<CustomVariable> customVariables;
    protected Integer phone;
    @JsonProperty("phone_prefix")
    protected Integer phonePrefix;

    public Customer(String email, String name) {
        this.email = email;
        this.name = name;
    }

}
