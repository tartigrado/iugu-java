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
public class Feature {

    protected String id;
    protected String name;
    protected String identifier;
    protected Integer value;
    @JsonProperty("_destroy")
    protected Boolean destroy;

    public Feature(String name, String identifier, int value) {
        this.name = name;
        this.identifier = identifier;
        this.value = value;
    }

}
