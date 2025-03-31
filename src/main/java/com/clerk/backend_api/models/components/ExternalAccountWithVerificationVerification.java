/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.OneOfDeserializer;
import com.clerk.backend_api.utils.TypedObject;
import com.clerk.backend_api.utils.Utils.JsonShape;
import com.clerk.backend_api.utils.Utils.TypeReferenceWithShape;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;

@JsonDeserialize(using = ExternalAccountWithVerificationVerification._Deserializer.class)
public class ExternalAccountWithVerificationVerification {

    @JsonValue
    private TypedObject value;
    
    private ExternalAccountWithVerificationVerification(TypedObject value) {
        this.value = value;
    }

    public static ExternalAccountWithVerificationVerification of(Oauth value) {
        Utils.checkNotNull(value, "value");
        return new ExternalAccountWithVerificationVerification(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<Oauth>(){}));
    }

    public static ExternalAccountWithVerificationVerification of(GoogleOneTap value) {
        Utils.checkNotNull(value, "value");
        return new ExternalAccountWithVerificationVerification(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<GoogleOneTap>(){}));
    }
    
    /**
     * Returns an instance of one of these types:
     * <ul>
     * <li>{@code com.clerk.backend_api.models.components.Oauth}</li>
     * <li>{@code com.clerk.backend_api.models.components.GoogleOneTap}</li>
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
        ExternalAccountWithVerificationVerification other = (ExternalAccountWithVerificationVerification) o;
        return Objects.deepEquals(this.value.value(), other.value.value()); 
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value.value());
    }
    
    @SuppressWarnings("serial")
    public static final class _Deserializer extends OneOfDeserializer<ExternalAccountWithVerificationVerification> {

        public _Deserializer() {
            super(ExternalAccountWithVerificationVerification.class, false,
                  TypeReferenceWithShape.of(new TypeReference<Oauth>() {}, JsonShape.DEFAULT),
                  TypeReferenceWithShape.of(new TypeReference<GoogleOneTap>() {}, JsonShape.DEFAULT));
        }
    }
    
    @Override
    public String toString() {
        return Utils.toString(ExternalAccountWithVerificationVerification.class,
                "value", value);
    }
 
}

