package com.iugu.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalTransfersResponse {

    protected Integer sent;
    protected Integer received;

}
