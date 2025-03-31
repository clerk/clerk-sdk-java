/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public enum WaitlistEntryInvitationStatus {
    PENDING("pending"),
    ACCEPTED("accepted"),
    REVOKED("revoked"),
    EXPIRED("expired");

    @JsonValue
    private final String value;

    private WaitlistEntryInvitationStatus(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<WaitlistEntryInvitationStatus> fromValue(String value) {
        for (WaitlistEntryInvitationStatus o: WaitlistEntryInvitationStatus.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

