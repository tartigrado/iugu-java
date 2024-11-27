package com.iugu.model.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public final class InvoiceExternalPaid {
    @JsonProperty("external_payment_id")
    private String externalPaymentId;
    @JsonProperty("external_payment_description")
    private String externalPaymentDescription;
}
