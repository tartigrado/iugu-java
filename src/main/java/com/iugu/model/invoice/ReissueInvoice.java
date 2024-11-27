package com.iugu.model.invoice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.PayableWith;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class ReissueInvoice {

    @JsonProperty("due_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dueDate;
    @JsonProperty("items")
    private List<Item> items;
    @JsonProperty("ignore_due_email")
    private Boolean ignoreDueEmail;
    @JsonProperty("ignore_canceled_email")
    private Boolean ignoreCanceledEmail;
    @JsonProperty("current_fines_option")
    private Boolean currentFinesOption;
    @JsonProperty("keep_early_payment_discount")
    private Boolean keepEarlyPaymentDiscount;
    @JsonProperty("payable_with")
    private List<PayableWith> payableWith;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Item {
        @JsonProperty("id")
        private String id;
        @JsonProperty("_destroy")
        private Boolean destroy;
        @JsonProperty("description")
        private String description;
        @JsonProperty("quantity")
        private Integer quantity;
        @JsonProperty("price_cents")
        private Integer priceCents;
    }

}
