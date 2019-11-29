package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iugu.model.MarketPlace;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketPlaceResponse {

    private String id;
    private String name;
    private boolean verified;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean isVerified() { return verified; }

    public void setVerified(boolean verified) { this.verified = verified; }

    @Override
    public String toString() {
        return "MarketPlaceresponse{" + "id=" + id + ", name=" + name + ", verified=" + verified +"}" ;

    }
}
