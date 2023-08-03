package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LastWithdrawResponse {
    protected String id;
    protected BigDecimal amount;
    protected String accountId;
    protected Date createdAt;
    protected Date updatedAt;
    protected Date acceptedAt;
    protected Date rejectedAt;
    protected String status;
    protected String bank;
    protected String bankCc;
    protected String bankAg;
    protected String accountType;
    protected String reference;
    protected String feedback;
    protected String automatic;
    protected String agreementEffect;
    protected String payee;
    protected String cpfCnpj;
    protected String compe;
    protected String source;
    protected String securityHash;

}
