package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.PayableWith;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {

    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_DRAFT = "draft";

    protected static final long serialVersionUID = 1719931730355279382L;
    protected String id;
    protected String email;
    @JsonProperty("cc_emails")
    protected String ccEmails;
    @JsonProperty("due_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date dueDate;
    @Builder.Default
    protected List<Item> items = new ArrayList<>();
    @JsonProperty("return_url")
    protected String returnUrl;
    @JsonProperty("expired_url")
    protected String expiredUrl;
    @JsonProperty("notification_url")
    protected String notificationUrl;
    protected Boolean fines;
    @JsonProperty("late_payment_fine")
    protected Double latePaymentFine;
    @JsonProperty("per_day_interest")
    protected Double perDayInterest;
    @JsonProperty("discount_cents")
    protected Integer discountCents;
    @JsonProperty("customer_id")
    protected String customerId;
    @JsonProperty("ignore_due_email")
    protected Boolean ignoreDueEmail;
    @JsonProperty("subscription_id")
    protected String subscriptionId;
    @JsonProperty("payable_with")
    protected List<PayableWith> payableWith;
    @JsonProperty("credits")
    protected Integer credits;
    protected List<Logs> logs;
    @JsonProperty("custom_variables")
    protected List<CustomVariable> customVariables;
    protected Payer payer;
    @JsonProperty("early_payment_discount")
    protected Boolean earlyPaymentDiscount;
    @JsonProperty("early_payment_discount_days")
    protected Integer earlyPaymentDiscountDays;
    @JsonProperty("early_payment_discount_percent")
    protected Integer earlyPaymentDiscountPercent;
    @JsonProperty("payment_method")
    protected Integer paymentMethod;
    @JsonProperty("fines_on_occurrence_day")
    protected String finesOnOccurrenceDay;
    @JsonProperty("order_id")
    protected String orderId;
    @JsonProperty("fines_on_occurrence_day_cents")
    protected Integer finesOnOcurrenceDayCents;
    @JsonProperty("per_day_interest_value")
    protected Integer perDayInterestValue;
    @JsonProperty("max_installments_value")
    protected Integer maxInstallmentsValue;
    protected String status;

    public Invoice(String email, Date dueDate, Item... items) {
        this.email = email;
        this.dueDate = dueDate;

        if (Objects.nonNull(items)) {
            getItems().addAll(Arrays.asList(items));
        }
    }


    public List<Item> getItems() {
        if (Objects.isNull(items)) setItems(new ArrayList<>());
        return items;
    }
}