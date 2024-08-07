/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.Callable;

public class ListInvitationsResponse implements com.clerk.backend_api.utils.Response {

    /**
     * HTTP response content type for this operation
     */
    private String contentType;

    /**
     * HTTP response status code for this operation
     */
    private int statusCode;

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    private HttpResponse<InputStream> rawResponse;

    /**
     * List of invitations
     */
    private Optional<? extends java.util.List<com.clerk.backend_api.models.components.Invitation>> invitationList;

    private Callable<Optional<ListInvitationsResponse>> next = () -> Optional.empty();

    @JsonCreator
    public ListInvitationsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends java.util.List<com.clerk.backend_api.models.components.Invitation>> invitationList) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(invitationList, "invitationList");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.invitationList = invitationList;
    }
    
    public ListInvitationsResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse) {
        this(contentType, statusCode, rawResponse, Optional.empty());
    }

    /**
     * HTTP response content type for this operation
     */
    @JsonIgnore
    public String contentType() {
        return contentType;
    }

    /**
     * HTTP response status code for this operation
     */
    @JsonIgnore
    public int statusCode() {
        return statusCode;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    @JsonIgnore
    public HttpResponse<InputStream> rawResponse() {
        return rawResponse;
    }

    /**
     * List of invitations
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<java.util.List<com.clerk.backend_api.models.components.Invitation>> invitationList() {
        return (Optional<java.util.List<com.clerk.backend_api.models.components.Invitation>>) invitationList;
    }

    public Optional<ListInvitationsResponse> next() throws Exception {
        return this.next.call();
    }
    
    // internal use only
    private ListInvitationsResponse withNext(Callable<Optional<ListInvitationsResponse>> next) {
        this.next = next;
        return this;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * HTTP response content type for this operation
     */
    public ListInvitationsResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public ListInvitationsResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public ListInvitationsResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * List of invitations
     */
    public ListInvitationsResponse withInvitationList(java.util.List<com.clerk.backend_api.models.components.Invitation> invitationList) {
        Utils.checkNotNull(invitationList, "invitationList");
        this.invitationList = Optional.ofNullable(invitationList);
        return this;
    }

    /**
     * List of invitations
     */
    public ListInvitationsResponse withInvitationList(Optional<? extends java.util.List<com.clerk.backend_api.models.components.Invitation>> invitationList) {
        Utils.checkNotNull(invitationList, "invitationList");
        this.invitationList = invitationList;
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
        ListInvitationsResponse other = (ListInvitationsResponse) o;
        return 
            java.util.Objects.deepEquals(this.contentType, other.contentType) &&
            java.util.Objects.deepEquals(this.statusCode, other.statusCode) &&
            java.util.Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            java.util.Objects.deepEquals(this.invitationList, other.invitationList);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            invitationList);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListInvitationsResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "invitationList", invitationList);
    }
    
    public final static class Builder {
        private Callable<Optional<ListInvitationsResponse>> next;
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends java.util.List<com.clerk.backend_api.models.components.Invitation>> invitationList = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * HTTP response content type for this operation
         */
        public Builder contentType(String contentType) {
            Utils.checkNotNull(contentType, "contentType");
            this.contentType = contentType;
            return this;
        }

        /**
         * HTTP response status code for this operation
         */
        public Builder statusCode(int statusCode) {
            Utils.checkNotNull(statusCode, "statusCode");
            this.statusCode = statusCode;
            return this;
        }

        /**
         * Raw HTTP response; suitable for custom response parsing
         */
        public Builder rawResponse(HttpResponse<InputStream> rawResponse) {
            Utils.checkNotNull(rawResponse, "rawResponse");
            this.rawResponse = rawResponse;
            return this;
        }

        /**
         * List of invitations
         */
        public Builder invitationList(java.util.List<com.clerk.backend_api.models.components.Invitation> invitationList) {
            Utils.checkNotNull(invitationList, "invitationList");
            this.invitationList = Optional.ofNullable(invitationList);
            return this;
        }

        /**
         * List of invitations
         */
        public Builder invitationList(Optional<? extends java.util.List<com.clerk.backend_api.models.components.Invitation>> invitationList) {
            Utils.checkNotNull(invitationList, "invitationList");
            this.invitationList = invitationList;
            return this;
        }

        /**
         * Internal API. Not for public use. Sets the provider of the next page.
         *
         * @deprecated not part of the public API, may be removed without notice
         */
        @Deprecated
        public Builder next(Callable<Optional<ListInvitationsResponse>> next) {
            Utils.checkNotNull(next, "next");
            this.next = next;
            return this;
        }
        
        public ListInvitationsResponse build() {
            return new ListInvitationsResponse(
                contentType,
                statusCode,
                rawResponse,
                invitationList)
                .withNext(next);
        }
    }
}

