/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;


import com.clerk.backend_api.utils.SpeakeasyMetadata;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;


public class GetPhoneNumberRequest {

    /**
     * The ID of the phone number to retrieve
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=phone_number_id")
    private String phoneNumberId;

    @JsonCreator
    public GetPhoneNumberRequest(
            String phoneNumberId) {
        Utils.checkNotNull(phoneNumberId, "phoneNumberId");
        this.phoneNumberId = phoneNumberId;
    }

    /**
     * The ID of the phone number to retrieve
     */
    @JsonIgnore
    public String phoneNumberId() {
        return phoneNumberId;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * The ID of the phone number to retrieve
     */
    public GetPhoneNumberRequest withPhoneNumberId(String phoneNumberId) {
        Utils.checkNotNull(phoneNumberId, "phoneNumberId");
        this.phoneNumberId = phoneNumberId;
        return this;
    }
    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetPhoneNumberRequest other = (GetPhoneNumberRequest) o;
        return 
            Objects.deepEquals(this.phoneNumberId, other.phoneNumberId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            phoneNumberId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetPhoneNumberRequest.class,
                "phoneNumberId", phoneNumberId);
    }
    
    public final static class Builder {
 
        private String phoneNumberId;  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The ID of the phone number to retrieve
         */
        public Builder phoneNumberId(String phoneNumberId) {
            Utils.checkNotNull(phoneNumberId, "phoneNumberId");
            this.phoneNumberId = phoneNumberId;
            return this;
        }
        
        public GetPhoneNumberRequest build() {
            return new GetPhoneNumberRequest(
                phoneNumberId);
        }
    }
}

