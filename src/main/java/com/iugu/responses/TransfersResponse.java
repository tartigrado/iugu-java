package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransfersResponse {

    @JsonProperty("sent")
    protected List<TransferResponse> sent;
    @JsonProperty("received")
    protected List<TransferResponse> received;
    protected TotalTransfersResponse totals;

}
