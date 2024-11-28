package com.iugu.model.email.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class EmailResponse {

    private String id;
    private String identifier;
    private String template;
    private String subject;
    private Boolean active;

}
