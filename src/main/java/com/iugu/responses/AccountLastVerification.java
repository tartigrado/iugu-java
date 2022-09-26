package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountLastVerification {

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
    protected String name;
    protected String address;
    protected String cep;
    protected String city;
    protected String state;
    protected String telephone;
    protected String bank;
    @JsonProperty("bank_ag")
    protected String bankAg;
    @JsonProperty("account_type")
    protected String accountType;
    @JsonProperty("bank_cc")
    protected String bankCc;
    @JsonProperty("document_id")
    protected String documentId;
    @JsonProperty("document_cpf")
    protected String documentCpf;
    @JsonProperty("document_activity")
    protected String documentActivity;

}