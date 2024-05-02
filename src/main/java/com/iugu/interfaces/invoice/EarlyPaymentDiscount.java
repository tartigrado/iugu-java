package com.iugu.interfaces.invoice;

import java.math.BigDecimal;

public interface EarlyPaymentDiscount {
    Integer getDays();

    BigDecimal getPercent();

    Integer getValueCents();
}
