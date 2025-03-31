/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public enum OAuthApplicationWithSecretObject {
    OAUTH_APPLICATION("oauth_application");

    @JsonValue
    private final String value;

    private OAuthApplicationWithSecretObject(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<OAuthApplicationWithSecretObject> fromValue(String value) {
        for (OAuthApplicationWithSecretObject o: OAuthApplicationWithSecretObject.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

