package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    private String id;
    private String description;
    private Integer quantity;
    @JsonProperty("price_cents")
    private Integer priceCents;
    @JsonProperty("_destroy")
    private boolean _destroy;

    public Item() {
    }

    public Item(String description, Integer quantity, Integer priceCents) {
        this.description = description;
        this.quantity = quantity;
        this.priceCents = priceCents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPriceCents() {
        return priceCents;
    }

    public void setPriceCents(Integer priceCents) {
        this.priceCents = priceCents;
    }

    public boolean isDestroy() {
        return _destroy;
    }

    public void setDestroy(boolean _destroy) {
        this._destroy = _destroy;
    }
    
}
