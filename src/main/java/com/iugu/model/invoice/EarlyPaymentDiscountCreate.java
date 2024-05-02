package com.iugu.model.invoice;

import com.iugu.interfaces.invoice.CustomVariable;
import com.iugu.interfaces.invoice.EarlyPaymentDiscount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EarlyPaymentDiscountCreate implements EarlyPaymentDiscount {
    private Integer days;
    private BigDecimal percent;
    private Integer valueCents;
}
