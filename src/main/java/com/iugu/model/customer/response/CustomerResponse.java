package com.iugu.model.customer.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CustomerResponse {


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class CustomVariableResponse {

        private String name;
        private String value;

    }

    private String id;
    private String email;
    private String name;
    private String notes;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("custom_variables")
    private List<CustomVariableResponse> customVariables;
    @JsonProperty("cpf_cnpj")
    private String cpfCnpj;
    @JsonProperty("zip_code")
    private String zipCode;
    private String number;
    private String street;
    private String district;
    private String complement;
    private String city;
    private String state;
    private String phone_prefix;
    private String phone;
    private String cc_emails;
    @JsonProperty("payment_methods")
    private List<CustomerPaymentMethodResponse> paymentMethods;
    @JsonProperty("default_payment_method_id")
    private String defaultPaymentMethodId;
    @JsonProperty("proxy_payments_from_customer_id")
    private Object proxyPaymentsFromCustomerId;
    @JsonAnySetter
    private Map<String, Object> any;
}
