package com.iugu.model.dunning;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class ChangeDunningStep {

    private List<DunningStep> steps;

}
