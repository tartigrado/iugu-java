package com.iugu.model;

import com.fasterxml.jackson.annotation.*;
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
public class DuplicateInvoice {

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
    }

    @JsonIgnore
    private String id;

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

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

}
