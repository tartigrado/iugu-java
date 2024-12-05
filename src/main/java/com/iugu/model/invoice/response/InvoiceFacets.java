package com.iugu.model.invoice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class InvoiceFacets {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static final class Late {
        @JsonProperty("_type")
        private String type;
        private Integer count;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static final class Status {

        @JsonProperty("_type")
        private String type;
        private Integer missing;
        private Integer other;
        private List<Term> terms;
        private Integer total;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        private static final class Term {
            private String term;
            private Integer count;
        }

    }

    private Late late;
    private Status status;
}
