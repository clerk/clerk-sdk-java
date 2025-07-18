/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * EnrollmentMode
 * 
 * <p>Mode of enrollment for the domain
 */
public enum EnrollmentMode {
    MANUAL_INVITATION("manual_invitation"),
    AUTOMATIC_INVITATION("automatic_invitation"),
    AUTOMATIC_SUGGESTION("automatic_suggestion");

    @JsonValue
    private final String value;

    EnrollmentMode(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<EnrollmentMode> fromValue(String value) {
        for (EnrollmentMode o: EnrollmentMode.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

