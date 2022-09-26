package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.model.CustomVariable;
import com.iugu.model.Receiver;
import com.iugu.model.Sender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferResponse {

    @JsonProperty("id")
    protected String id;
    @JsonProperty("created_at")
    protected Date createdAt;
    @JsonProperty("amount_cents")
    protected String amountCents;
    @JsonProperty("amount_localized")
    protected String amountLocalized;
    @JsonProperty("receiver")
    protected Receiver receiver;
    @JsonProperty("sender")
    protected Sender sender;
    @JsonProperty("custom_variables")
    protected List<CustomVariable> customVariables;

}
