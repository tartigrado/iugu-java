package com.iugu.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidatePaymentRequestResponse implements Serializable {

    protected String message;
    protected List<String> errors;
}
