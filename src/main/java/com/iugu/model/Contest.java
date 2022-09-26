package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contest {

    @JsonProperty("file_1")
    protected File file1;
    @JsonProperty("file_2")
    protected File file2;
    @JsonProperty("file_3")
    protected File file3;
    @JsonProperty("file_4")
    protected File file4;
    @JsonProperty("file_5")
    protected File file5;

}
