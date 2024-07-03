package com.iugu.responses.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodListResponse {
    private List<PaymentMethodResponse> data;

    public PaymentMethodResponse findById(String id) {
        return getData().stream().filter(method -> method.getId().equals(id)).findFirst().orElse(null);
    }

    public PaymentMethodResponse first() {
        return getData().stream().findFirst().orElse(null);
    }

}
