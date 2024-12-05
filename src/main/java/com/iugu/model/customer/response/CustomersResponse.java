package com.iugu.model.customer.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iugu.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CustomersResponse {

    private Integer totalItems;
    private List<CustomerResponse> items;
    @JsonAnySetter
    private Map<String, Object> any;

    @JsonIgnore
    public CustomerResponse first() {
        return items.get(0);
    }

    @JsonIgnore
    public CustomerResponse findById(String id) {
        return items.stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null);
    }

    @JsonIgnore
    public CustomerResponse findByEmail(String email) {
        return items.stream().filter(customer -> Objects.equals(email, customer.getEmail())).findFirst().orElse(null);
    }

    @JsonIgnore
    public CustomerResponse findByCpfCnpj(String cpfCnpj) {
        final String docDigits = StringUtils.onlyDigits(cpfCnpj);
        return items.stream().filter(customer -> Objects.equals(docDigits, StringUtils.onlyDigits(customer.getCpfCnpj()))).findFirst().orElse(null);
    }
}
