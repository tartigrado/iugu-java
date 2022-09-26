package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Charge {

    @JsonProperty("token")
    protected String token;

    @JsonProperty("invoice_id")
    protected String invoiceId;

    @JsonProperty("customer_id")
    protected String customerId;

    @JsonProperty("email")
    protected String email;

    @Builder.Default
    protected List<Item> items = new ArrayList<>();

    @JsonProperty("payer")
    protected Payer payer;

    @JsonProperty("months")
    protected String months;

    public Charge(String token, String invoiceId) {
        this.token = token;
        this.invoiceId = invoiceId;
    }

    public Charge(String token, String invoiceId, String customerId) {
        this.token = token;
        this.invoiceId = invoiceId;
        this.customerId = customerId;
    }

    public Charge(String token, String email, List<Item> items, Payer payer) {
        this.token = token;
        this.email = email;
        this.items = items;
        this.payer = payer;
    }

    public Charge(String token, String email, List<Item> items, Payer payer, String months) {
        this.token = token;
        this.email = email;
        this.items = items;
        this.payer = payer;
        this.months = months;
    }

    public List<Item> getItems() {
        if (Objects.isNull(items)) setItems(new ArrayList<>());
        return items;
    }
}
