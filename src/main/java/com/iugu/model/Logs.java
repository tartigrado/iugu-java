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
public class Logs {

    protected String description;
    protected String notes;
    @JsonProperty("_destroy")
    protected Boolean destroy;

    public Logs(String description, String notes) {
        this.description = description;
        this.notes = notes;
    }

}
