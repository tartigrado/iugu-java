package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionAdvanceResponse {

    protected List<TransactionAdvanceTransactionsResponse> transactions;
    protected TransactionAdvanceTotalResponse total;


}
