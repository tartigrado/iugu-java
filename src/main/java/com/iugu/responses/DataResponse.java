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
public class DataResponse {

    @JsonProperty("price_range")
    protected String priceRange;
    @JsonProperty("physical_products")
    protected String physicalProducts;
    @JsonProperty("business_type")
    protected String business_type;
    @JsonProperty("person_type")
    protected String person_type;
    @JsonProperty("automatic_transfer")
    protected String automatic_transfer;
    protected String cpf;
    protected String cnpj;
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
    protected Integer documentId;
    @JsonProperty("document_cpf")
    protected Integer documentCpf;
    @JsonProperty("document_activity")
    protected Integer documentActivity;
}
