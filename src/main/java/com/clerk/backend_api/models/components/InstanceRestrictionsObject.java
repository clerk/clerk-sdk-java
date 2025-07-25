/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * InstanceRestrictionsObject
 * 
 * <p>String representing the object's type. Objects of the same type share the same value.
 */
public enum InstanceRestrictionsObject {
    INSTANCE_RESTRICTIONS("instance_restrictions");

    @JsonValue
    private final String value;

    InstanceRestrictionsObject(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<InstanceRestrictionsObject> fromValue(String value) {
        for (InstanceRestrictionsObject o: InstanceRestrictionsObject.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

