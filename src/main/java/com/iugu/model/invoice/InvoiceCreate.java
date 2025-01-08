package com.iugu.model.invoice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.IuguConstants;
import com.iugu.enums.PayableWith;
import com.iugu.model.Commissions;
import com.iugu.model.Payer;
import com.iugu.model.Splits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class InvoiceCreate {
    private String email;
    private String status;
    @JsonProperty("cc_emails")
    private String ccEmails;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "America/Sao_Paulo")
    @JsonProperty("due_date")
    private Date dueDate;
    @JsonProperty("ensure_workday_due_date")
    private Boolean ensureWorkdayDueDate;
    @JsonProperty("expires_in")
    private String expiresIn;
    @JsonProperty("bank_slip_extra_due")
    private String bankSlipExtraDue;
    private List<InvoiceItem> items;
    @JsonProperty("return_url")
    private String returnUrl;
    @JsonProperty("expired_url")
    private String expiredUrl;
    @JsonProperty("notification_url")
    private String notificationUrl;
    @JsonProperty("ignore_canceled_email")
    private Boolean ignoreCanceledEmail;
    private Boolean fines;
    @JsonProperty("late_payment_fine")
    private Integer latePaymentFine;
    @JsonProperty("late_payment_fine_cents")
    private Integer latePaymentFineCents;
    @JsonProperty("per_day_interest")
    private Boolean perDayInterest;
    @JsonProperty("per_day_interest_value")
    private Integer perDayInterestValue;
    @JsonProperty("per_day_interest_cents")
    private Integer perDayInterestCents;
    @JsonProperty("discount_cents")
    private Integer discountCents;
    @JsonProperty("customer_id")
    private String customerId;
    @JsonProperty("ignore_due_email")
    private Boolean ignoreDueEmail;
    @JsonProperty("subscription_id")
    private String subscriptionId;
    @JsonProperty("payable_with")
    private List<PayableWith> payableWith;
    private Integer credits;
    @JsonProperty("custom_variables")
    private List<CustomVariable> customVariables;
    @JsonProperty("early_payment_discount")
    private Boolean earlyPaymentDiscount;
    @JsonProperty("early_payment_discounts")
    private List<EarlyPaymentDiscount> earlyPaymentDiscounts;
    private Payer payer;
    @JsonProperty("splits")
    private List<Splits> splits;
    @JsonProperty("order_id")
    private String orderId;
    private Commissions commissions;
    @JsonProperty("external_reference")
    private String externalReference;
    @JsonProperty("max_installments_value")
    private Integer maxInstallmentsValue;
    @JsonProperty("soft_descriptor_light")
    private String softDescriptorLight;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = IuguConstants.TIME_ZONE)
    @JsonProperty("pix_qr_code_expires_at")
    private Date pixQrCodeExpiresAt;
    @JsonProperty("pix_remittance_info")
    private String pixRemittanceInfo;
    @JsonProperty("pix_additional_info")
    private List<PixAdditionalInfo> pixAdditionalInfo;
    @JsonProperty("RAW_BODY")
    private String rawBody;
    private String password;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class InvoiceItem {
        private String description;
        private Integer quantity;
        @JsonProperty("price_cents")
        private Integer priceCents;
    }


    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class EarlyPaymentDiscount {
        private Integer days;
        private BigDecimal percent;
        @JsonProperty("value_cents")
        private Integer valueCents;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class PixAdditionalInfo {
        private String name;
        private String value;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class CustomVariable {
        private String name;
        private String value;
    }
}