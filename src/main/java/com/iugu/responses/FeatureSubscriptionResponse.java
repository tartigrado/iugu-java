package com.iugu.responses;

public class FeatureSubscriptionResponse {
    private String identifier;
    private String name;

    public FeatureSubscriptionResponse() {

    }

    public FeatureSubscriptionResponse(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
