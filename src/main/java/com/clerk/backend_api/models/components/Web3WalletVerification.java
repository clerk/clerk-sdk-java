/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;

import java.time.OffsetDateTime;
import java.time.LocalDate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.clerk.backend_api.utils.TypedObject;
import com.clerk.backend_api.utils.Utils.JsonShape;


@JsonDeserialize(using = Web3WalletVerification._Deserializer.class)
public class Web3WalletVerification {

    @com.fasterxml.jackson.annotation.JsonValue
    private TypedObject value;
    
    private Web3WalletVerification(TypedObject value) {
        this.value = value;
    }

    public static Web3WalletVerification of(Web3Signature value) {
        Utils.checkNotNull(value, "value");
        return new Web3WalletVerification(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<Web3Signature>(){}));
    }

    public static Web3WalletVerification of(Web3WalletVerificationAdmin value) {
        Utils.checkNotNull(value, "value");
        return new Web3WalletVerification(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<Web3WalletVerificationAdmin>(){}));
    }
    
    /**
     * Returns an instance of one of these types:
     * <ul>
     * <li>{@code Web3Signature}</li>
     * <li>{@code Web3WalletVerificationAdmin}</li>
     * </ul>
     * 
     * <p>Use {@code instanceof} to determine what type is returned. For example:
     * 
     * <pre>
     * if (obj.value() instanceof String) {
     *     String answer = (String) obj.value();
     *     System.out.println("answer=" + answer);
     * }
     * </pre>
     * 
     * @return value of oneOf type
     **/ 
    public java.lang.Object value() {
        return value.value();
    }    
    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Web3WalletVerification other = (Web3WalletVerification) o;
        return java.util.Objects.deepEquals(this.value.value(), other.value.value()); 
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(value.value());
    }
    
    @SuppressWarnings("serial")
    public static final class _Deserializer extends com.clerk.backend_api.utils.OneOfDeserializer<Web3WalletVerification> {

        public _Deserializer() {
            super(Web3WalletVerification.class,
                  Utils.TypeReferenceWithShape.of(new TypeReference<Web3Signature>() {}, Utils.JsonShape.DEFAULT),
                  Utils.TypeReferenceWithShape.of(new TypeReference<Web3WalletVerificationAdmin>() {}, Utils.JsonShape.DEFAULT));
        }
    }
    
    @Override
    public String toString() {
        return Utils.toString(Web3WalletVerification.class,
                "value", value);
    }
 
}
