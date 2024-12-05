package com.iugu.model.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CustomerCreate {

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class CustomVariable {
        private String name;
        private String value;
    }

    private String email;
    private String name;
    private String notes;
    @JsonProperty("cpf_cnpj")
    private String cpfCnpj;
    @JsonProperty("cc_emails")
    private String ccEmails;
    @JsonProperty("zip_code")
    private String zipCode;
    private String number;
    private String street;
    private String city;
    private String state;
    private String district;
    private String complement;
    private Integer phone;
    @JsonProperty("phone_prefix")
    private Integer phonePrefix;
    @JsonProperty("custom_variables")
    private List<CustomVariable> customVariables;
}
