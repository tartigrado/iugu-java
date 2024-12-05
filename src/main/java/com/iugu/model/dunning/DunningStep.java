package com.iugu.model.dunning;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class DunningStep {

    public static final String EXPIRE_ACTION = "expire";
    public static final String CHARGE_ACTION = "charge";

    private Integer day;
    private String action;

}
