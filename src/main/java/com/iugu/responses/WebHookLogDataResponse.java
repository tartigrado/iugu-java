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
public class WebHookLogDataResponse {

    protected String event;
    @JsonProperty("data[id]")
    protected String id;
    @JsonProperty("data[status]")
    protected String status;
    @JsonProperty("data[account_id]")
    protected String accountId;
    @JsonProperty("data[number_of_installments]")
    protected Integer numberOfInstallments;
    @JsonProperty("data[amount]")
    protected String amount;

}
