package com.iugu.model.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.enums.PayableWith;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class ChangePlan {
    @JsonProperty("payable_with")
    private List<PayableWith> payableWith;
}
