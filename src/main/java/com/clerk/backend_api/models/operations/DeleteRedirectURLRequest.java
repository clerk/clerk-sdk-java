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


public class DeleteRedirectURLRequest {
    /**
     * The ID of the redirect URL
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=id")
    private String id;

    @JsonCreator
    public DeleteRedirectURLRequest(
            String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
    }

    /**
     * The ID of the redirect URL
     */
    @JsonIgnore
    public String id() {
        return id;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The ID of the redirect URL
     */
    public DeleteRedirectURLRequest withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
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
        DeleteRedirectURLRequest other = (DeleteRedirectURLRequest) o;
        return 
            Utils.enhancedDeepEquals(this.id, other.id);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            id);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DeleteRedirectURLRequest.class,
                "id", id);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String id;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The ID of the redirect URL
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }

        public DeleteRedirectURLRequest build() {

            return new DeleteRedirectURLRequest(
                id);
        }

    }
}
