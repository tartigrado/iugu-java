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
public final class CustomerResponse {

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
    private List<PaymentMethodResponse> paymentMethods;
    @JsonProperty("default_payment_method_id")
    private String defaultPaymentMethodId;
    @JsonProperty("proxy_payments_from_customer_id")
    private Object proxyPaymentsFromCustomerId;
}
