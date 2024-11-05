/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;

/**
 * OrganizationDomainStatus - Status of the verification. It can be `unverified` or `verified`
 */
public enum OrganizationDomainStatus {
    UNVERIFIED("unverified"),
    VERIFIED("verified");

    @JsonValue
    private final String value;

    private OrganizationDomainStatus(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
}