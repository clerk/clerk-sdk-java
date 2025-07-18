/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public enum ActorTokenObject {
    ACTOR_TOKEN("actor_token");

    @JsonValue
    private final String value;

    ActorTokenObject(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<ActorTokenObject> fromValue(String value) {
        for (ActorTokenObject o: ActorTokenObject.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

