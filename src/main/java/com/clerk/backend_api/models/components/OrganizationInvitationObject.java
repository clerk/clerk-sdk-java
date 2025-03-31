/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * OrganizationInvitationObject
 * 
 * <p>String representing the object's type. Objects of the same type share the same value.
 */
public enum OrganizationInvitationObject {
    ORGANIZATION_INVITATION("organization_invitation");

    @JsonValue
    private final String value;

    private OrganizationInvitationObject(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<OrganizationInvitationObject> fromValue(String value) {
        for (OrganizationInvitationObject o: OrganizationInvitationObject.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

