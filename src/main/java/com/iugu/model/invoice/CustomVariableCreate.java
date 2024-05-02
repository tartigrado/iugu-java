package com.iugu.model.invoice;

import com.iugu.interfaces.invoice.CustomVariable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomVariableCreate implements CustomVariable {
    protected String name;
    protected String value;
}
