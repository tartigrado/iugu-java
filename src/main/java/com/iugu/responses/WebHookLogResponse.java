package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebHookLogResponse {

    protected String id;
    @JsonProperty("web_hook_id")
    protected String webHookId;
    protected WebHookLogDataResponse data;
    protected String status;
    protected String error;
    @JsonProperty("loggable_id")
    protected String loggableId;
    @JsonProperty("loggable_type")
    protected String loggableType;

}
