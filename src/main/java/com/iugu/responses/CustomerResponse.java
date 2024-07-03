package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.responses.customer.PaymentMethodResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerResponse {

    protected String id;
    protected String email;
    protected String name;
    protected String notes;
    @JsonProperty("created_at")
    protected Date createdAt;
    @JsonProperty("updated_at")
    protected Date updatedAt;
    @JsonProperty("custom_variables")
    protected List<CustomVariableResponse> customVariables;
    @JsonProperty("cpf_cnpj")
    protected String cpfCnpj;
    @JsonProperty("zip_code")
    protected String zipCode;
    protected String number;
    protected String street;
    protected String district;
    protected String complement;
    protected String city;
    protected String state;
    protected String phone_prefix;
    protected String phone;
    protected String cc_emails;
    @JsonProperty("payment_methods")
    protected List<PaymentMethodResponse> paymentMethods;

}
