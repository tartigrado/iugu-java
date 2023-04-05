package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true, allowSetters = true, value = {"featuresIugu"})
public class SubscriptionResponse {

    @JsonProperty("credits_cycle")
    protected Integer creditsCycle;
    protected String id;
    protected Boolean suspended;
    @JsonProperty("plan_identifier")
    protected String planIdentifier;
    @JsonProperty("price_cents")
    protected Integer priceCents;
    protected String currency;
    //TODO Features
    @JsonProperty("expires_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date expiresAt;
    @JsonProperty("customer_name")
    protected String customerName;
    @JsonProperty("customer_email")
    protected String customerEmail;
    @JsonProperty("cycled_at")
    protected Date cycledAt;
    @JsonProperty("credits_min")
    protected Integer creditsMin;
    //TODO Credits Cycle
    @JsonProperty("customer_id")
    protected String customerId;
    @JsonProperty("plan_name")
    protected String planName;
    @JsonProperty("customer_ref")
    protected String customerRef;
    @JsonProperty("plan_ref")
    protected String planRef;
    protected Boolean active;
    @JsonProperty("in_trial")
    protected Boolean inTrial;
    protected Integer credits;
    @JsonProperty("credits_based")
    protected Boolean creditsBased;
    @JsonProperty("recent_invoices")
    protected List<InvoiceResponse> recentInvoices;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected JsonNode features;
    @JsonProperty("features_revgas")
    protected List<FeatureSubscriptionResponse> featuresRevgas;
    protected List<SubItemResponse> subitems;
    protected List<LogResponse> logs;
    @JsonProperty("custom_variables")
    protected List<CustomVariableResponse> customVariables;
    @JsonProperty("created_at")
    protected String createdAt;
    @JsonProperty("updated_at")
    protected String updatedAt;

    public JsonNode getFeatures() {
        return features;
    }

    public void setFeatures(JsonNode featuresIugu) {
        this.features = featuresIugu;

        Iterator<String> fields = featuresIugu.fieldNames();

        while (fields.hasNext()) {
            String field = fields.next();
            String nameFeat = featuresIugu.path(field).path("name").asText();
            getFeaturesRevgas().add(new FeatureSubscriptionResponse(field, nameFeat));
        }
    }

    public List<FeatureSubscriptionResponse> getFeaturesRevgas() {
        if (featuresRevgas == null) setFeaturesRevgas(new ArrayList<>());
        return featuresRevgas;
    }

    public void setFeaturesRevgas(List<FeatureSubscriptionResponse> featuresRevgas) {
        this.featuresRevgas = featuresRevgas;
    }
}
