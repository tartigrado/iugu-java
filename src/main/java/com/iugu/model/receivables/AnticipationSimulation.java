package com.iugu.model.receivables;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class AnticipationSimulation {
    @JsonProperty("requested_advancement_cents")
    private Long requestedAdvancementCents;
}
