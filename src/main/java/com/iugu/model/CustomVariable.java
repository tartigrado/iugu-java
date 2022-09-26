package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomVariable {

    protected String name;
    protected String value;
    @JsonProperty("_destroy")
    protected Boolean destroy;
    public CustomVariable(String name, String value) {
        this.name = name;
        this.value = value;
    }


}
