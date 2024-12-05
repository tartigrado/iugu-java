package com.iugu.model.customer.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CustomerPaymentMethodsResponse {
    private List<CustomerPaymentMethodResponse> data;

    public CustomerPaymentMethodResponse findById(String id) {
        return getData().stream().filter(method -> method.getId().equals(id)).findFirst().orElse(null);
    }

    public CustomerPaymentMethodResponse first() {
        return getData().stream().findFirst().orElse(null);
    }

}
