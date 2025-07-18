/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * ToggleTemplateDeliveryPathParamTemplateType
 * 
 * <p>The type of template to toggle delivery for
 */
public enum ToggleTemplateDeliveryPathParamTemplateType {
    EMAIL("email"),
    SMS("sms");

    @JsonValue
    private final String value;

    ToggleTemplateDeliveryPathParamTemplateType(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<ToggleTemplateDeliveryPathParamTemplateType> fromValue(String value) {
        for (ToggleTemplateDeliveryPathParamTemplateType o: ToggleTemplateDeliveryPathParamTemplateType.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

