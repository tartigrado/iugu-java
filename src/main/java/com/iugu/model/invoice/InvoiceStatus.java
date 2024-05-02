package com.iugu.model.invoice;

public final class InvoiceStatus {
    private InvoiceStatus() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static final String PENDING = "pending";
    public static final String PAID = "paid";
    public static final String CANCELED = "canceled";
    public static final String PARTIALLY_PAID = "partially_paid";
    public static final String EXTERNALLY_PAID = "externally_paid";
    public static final String REFUNDED = "refunded";
    public static final String EXPIRED = "expired";
    public static final String AUTHORIZED = "authorized";
}
