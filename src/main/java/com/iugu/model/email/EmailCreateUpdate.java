package com.iugu.model.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class EmailCreateUpdate {
    private String identifier;
    private String template;
    private String subject;
    @Builder.Default
    private Boolean active = Boolean.TRUE;
}
