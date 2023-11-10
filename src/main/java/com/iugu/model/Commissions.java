package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Commissions {
    private String id;
    private String splitId;
    private String recipientAccountId;
    private Integer cents;
    private BigDecimal percent;
    private Integer creditCardCents;
    private BigDecimal creditCardPercent;
    private Integer bankSlipCents;
    private BigDecimal bankSlipPercent;
    private Integer pixCents;
    private BigDecimal pixPercent;
    private Boolean permitAggregated;
    private Date createdAt;
    private Date updatedAt;
    private Integer creditCard1xCents;
    private Integer creditCard2xCents;
    private Integer creditCard3xCents;
    private Integer creditCard4xCents;
    private Integer creditCard5xCents;
    private Integer creditCard6xCents;
    private Integer creditCard7xCents;
    private Integer creditCard8xCents;
    private Integer creditCard9xCents;
    private Integer creditCard10xCents;
    private Integer creditCard11xCents;
    private Integer creditCard12xCents;
    private BigDecimal creditCard1xPercent;
    private BigDecimal creditCard2xPercent;
    private BigDecimal creditCard3xPercent;
    private BigDecimal creditCard4xPercent;
    private BigDecimal creditCard5xPercent;
    private BigDecimal creditCard6xPercent;
    private BigDecimal creditCard7xPercent;
    private BigDecimal creditCard8xPercent;
    private BigDecimal creditCard9xPercent;
    private BigDecimal creditCard10xPercent;
    private BigDecimal creditCard11xPercent;
    private BigDecimal creditCard12xPercent;

}
