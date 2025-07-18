/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * TotalCountObject
 * 
 * <p>String representing the object's type. Objects of the same type share the same value.
 */
public enum TotalCountObject {
    TOTAL_COUNT("total_count");

    @JsonValue
    private final String value;

    TotalCountObject(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<TotalCountObject> fromValue(String value) {
        for (TotalCountObject o: TotalCountObject.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

