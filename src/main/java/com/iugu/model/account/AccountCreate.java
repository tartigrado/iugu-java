package com.iugu.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iugu.interfaces.WithApiToken;
import com.iugu.model.splits.Splits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class AccountCreate implements WithApiToken {
    private String name;
    private List<Splits> splits;
    @JsonProperty("api_token")
    private String apiToken;
}
