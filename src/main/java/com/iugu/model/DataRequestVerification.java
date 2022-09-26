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
public class DataRequestVerification {

    @JsonProperty("price_range")
    protected String priceRange;
    @JsonProperty("physical_products")
    protected Boolean physicalProducts;
    @JsonProperty("business_type")
    protected String businessType;
    @JsonProperty("person_type")
    protected String personType;
    @JsonProperty("automatic_transfer")
    protected Boolean automaticTransfer;
    protected String cpf;
    protected String cnpj;
    @JsonProperty("company_name")
    protected String companyName;
    protected String name;
    protected String address;
    protected String cep;
    protected String city;
    protected String state;
    protected String telephone;
    @JsonProperty("resp_name")
    protected String respName;
    @JsonProperty("resp_cpf")
    protected String respCpf;
    protected String bank;
    @JsonProperty("bank_ag")
    protected String bankAg;
    @JsonProperty("account_type")
    protected String accountType;
    @JsonProperty("bank_cc")
    protected String bankCc;

}
