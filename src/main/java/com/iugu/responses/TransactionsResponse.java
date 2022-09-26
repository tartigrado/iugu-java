package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionsResponse {

    protected List<TransactionResponse> transactions;
    @JsonProperty("initial_balance")
    protected InitialBalanceResponse initialBalance;
    @JsonProperty("initial_date")
    protected Date initialDate;
    @JsonProperty("final_date")
    protected Date finalDate;
    @JsonProperty("transactions_total")
    protected Integer transactionsTotal;

}
