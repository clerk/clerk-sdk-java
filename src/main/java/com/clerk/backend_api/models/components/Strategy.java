/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;

public enum Strategy {
    PHONE_CODE("phone_code"),
    EMAIL_CODE("email_code"),
    RESET_PASSWORD_EMAIL_CODE("reset_password_email_code"),
    FROM_OAUTH_GOOGLE("from_oauth_google");

    @JsonValue
    private final String value;

    private Strategy(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
}
