package com.iugu.model.withdraw;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class WithdrawFilter {
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_PROCESSING = "processing";
    public static final String STATUS_ACCEPTED = "accepted";
    public static final String STATUS_REJECTED = "rejected";
    public static final String STATUS_INCONSISTENT = "inconsistent";
    public static final String STATUS_REFUNDED = "refunded";
    public static final String STATUS_PARTIALLY_REFUNDED = "partially_refunded";
    public static final String STATUS_REPROCESSING = "reprocessing";

    @JsonProperty("custom_variables_name")
    private String customVariablesName;
    @JsonProperty("custom_variables_value")
    private String customVariablesValue;
    private String status;

}
