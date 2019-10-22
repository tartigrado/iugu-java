package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebHookLogResponse {

    private String id;
    @JsonProperty("web_hook_id")
    private String webHookId;
    private WebHookLogDataResponse data;
    private String status;
    private String error;
    @JsonProperty("loggable_id")
    private String loggableId;
    @JsonProperty("loggable_type")
    private String loggableType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebHookId() {
        return webHookId;
    }

    public void setWebHookId(String webHookId) {
        this.webHookId = webHookId;
    }

    public WebHookLogDataResponse getData() {
        return data;
    }

    public void setData(WebHookLogDataResponse data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getLoggableId() {
        return loggableId;
    }

    public void setLoggableId(String loggableId) {
        this.loggableId = loggableId;
    }

    public String getLoggableType() {
        return loggableType;
    }

    public void setLoggableType(String loggableType) {
        this.loggableType = loggableType;
    }

}
