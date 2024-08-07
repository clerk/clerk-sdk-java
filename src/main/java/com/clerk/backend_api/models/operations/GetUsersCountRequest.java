/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.SpeakeasyMetadata;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.lang.Deprecated;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public class GetUsersCountRequest {

    /**
     * Counts users with the specified email addresses.
     * Accepts up to 100 email addresses.
     * Any email addresses not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=email_address")
    private Optional<? extends java.util.List<String>> emailAddress;

    /**
     * Counts users with the specified phone numbers.
     * Accepts up to 100 phone numbers.
     * Any phone numbers not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=phone_number")
    private Optional<? extends java.util.List<String>> phoneNumber;

    /**
     * Counts users with the specified external ids.
     * Accepts up to 100 external ids.
     * Any external ids not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=external_id")
    private Optional<? extends java.util.List<String>> externalId;

    /**
     * Counts users with the specified usernames.
     * Accepts up to 100 usernames.
     * Any usernames not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=username")
    private Optional<? extends java.util.List<String>> username;

    /**
     * Counts users with the specified web3 wallet addresses.
     * Accepts up to 100 web3 wallet addresses.
     * Any web3 wallet addressed not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=web3_wallet")
    private Optional<? extends java.util.List<String>> web3Wallet;

    /**
     * Counts users with the user ids specified.
     * Accepts up to 100 user ids.
     * Any user ids not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=user_id")
    private Optional<? extends java.util.List<String>> userId;

    /**
     * Counts users that match the given query.
     * For possible matches, we check the email addresses, phone numbers, usernames, web3 wallets, user ids, first and last names.
     * The query value doesn't need to match the exact value you are looking for, it is capable of partial matches as well.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=query")
    private Optional<? extends String> query;

    @JsonCreator
    public GetUsersCountRequest(
            Optional<? extends java.util.List<String>> emailAddress,
            Optional<? extends java.util.List<String>> phoneNumber,
            Optional<? extends java.util.List<String>> externalId,
            Optional<? extends java.util.List<String>> username,
            Optional<? extends java.util.List<String>> web3Wallet,
            Optional<? extends java.util.List<String>> userId,
            Optional<? extends String> query) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        Utils.checkNotNull(phoneNumber, "phoneNumber");
        Utils.checkNotNull(externalId, "externalId");
        Utils.checkNotNull(username, "username");
        Utils.checkNotNull(web3Wallet, "web3Wallet");
        Utils.checkNotNull(userId, "userId");
        Utils.checkNotNull(query, "query");
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.externalId = externalId;
        this.username = username;
        this.web3Wallet = web3Wallet;
        this.userId = userId;
        this.query = query;
    }
    
    public GetUsersCountRequest() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * Counts users with the specified email addresses.
     * Accepts up to 100 email addresses.
     * Any email addresses not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<java.util.List<String>> emailAddress() {
        return (Optional<java.util.List<String>>) emailAddress;
    }

    /**
     * Counts users with the specified phone numbers.
     * Accepts up to 100 phone numbers.
     * Any phone numbers not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<java.util.List<String>> phoneNumber() {
        return (Optional<java.util.List<String>>) phoneNumber;
    }

    /**
     * Counts users with the specified external ids.
     * Accepts up to 100 external ids.
     * Any external ids not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<java.util.List<String>> externalId() {
        return (Optional<java.util.List<String>>) externalId;
    }

    /**
     * Counts users with the specified usernames.
     * Accepts up to 100 usernames.
     * Any usernames not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<java.util.List<String>> username() {
        return (Optional<java.util.List<String>>) username;
    }

    /**
     * Counts users with the specified web3 wallet addresses.
     * Accepts up to 100 web3 wallet addresses.
     * Any web3 wallet addressed not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<java.util.List<String>> web3Wallet() {
        return (Optional<java.util.List<String>>) web3Wallet;
    }

    /**
     * Counts users with the user ids specified.
     * Accepts up to 100 user ids.
     * Any user ids not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<java.util.List<String>> userId() {
        return (Optional<java.util.List<String>>) userId;
    }

    /**
     * Counts users that match the given query.
     * For possible matches, we check the email addresses, phone numbers, usernames, web3 wallets, user ids, first and last names.
     * The query value doesn't need to match the exact value you are looking for, it is capable of partial matches as well.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<String> query() {
        return (Optional<String>) query;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * Counts users with the specified email addresses.
     * Accepts up to 100 email addresses.
     * Any email addresses not found are ignored.
     */
    public GetUsersCountRequest withEmailAddress(java.util.List<String> emailAddress) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        this.emailAddress = Optional.ofNullable(emailAddress);
        return this;
    }

    /**
     * Counts users with the specified email addresses.
     * Accepts up to 100 email addresses.
     * Any email addresses not found are ignored.
     */
    public GetUsersCountRequest withEmailAddress(Optional<? extends java.util.List<String>> emailAddress) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Counts users with the specified phone numbers.
     * Accepts up to 100 phone numbers.
     * Any phone numbers not found are ignored.
     */
    public GetUsersCountRequest withPhoneNumber(java.util.List<String> phoneNumber) {
        Utils.checkNotNull(phoneNumber, "phoneNumber");
        this.phoneNumber = Optional.ofNullable(phoneNumber);
        return this;
    }

    /**
     * Counts users with the specified phone numbers.
     * Accepts up to 100 phone numbers.
     * Any phone numbers not found are ignored.
     */
    public GetUsersCountRequest withPhoneNumber(Optional<? extends java.util.List<String>> phoneNumber) {
        Utils.checkNotNull(phoneNumber, "phoneNumber");
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Counts users with the specified external ids.
     * Accepts up to 100 external ids.
     * Any external ids not found are ignored.
     */
    public GetUsersCountRequest withExternalId(java.util.List<String> externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = Optional.ofNullable(externalId);
        return this;
    }

    /**
     * Counts users with the specified external ids.
     * Accepts up to 100 external ids.
     * Any external ids not found are ignored.
     */
    public GetUsersCountRequest withExternalId(Optional<? extends java.util.List<String>> externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = externalId;
        return this;
    }

    /**
     * Counts users with the specified usernames.
     * Accepts up to 100 usernames.
     * Any usernames not found are ignored.
     */
    public GetUsersCountRequest withUsername(java.util.List<String> username) {
        Utils.checkNotNull(username, "username");
        this.username = Optional.ofNullable(username);
        return this;
    }

    /**
     * Counts users with the specified usernames.
     * Accepts up to 100 usernames.
     * Any usernames not found are ignored.
     */
    public GetUsersCountRequest withUsername(Optional<? extends java.util.List<String>> username) {
        Utils.checkNotNull(username, "username");
        this.username = username;
        return this;
    }

    /**
     * Counts users with the specified web3 wallet addresses.
     * Accepts up to 100 web3 wallet addresses.
     * Any web3 wallet addressed not found are ignored.
     */
    public GetUsersCountRequest withWeb3Wallet(java.util.List<String> web3Wallet) {
        Utils.checkNotNull(web3Wallet, "web3Wallet");
        this.web3Wallet = Optional.ofNullable(web3Wallet);
        return this;
    }

    /**
     * Counts users with the specified web3 wallet addresses.
     * Accepts up to 100 web3 wallet addresses.
     * Any web3 wallet addressed not found are ignored.
     */
    public GetUsersCountRequest withWeb3Wallet(Optional<? extends java.util.List<String>> web3Wallet) {
        Utils.checkNotNull(web3Wallet, "web3Wallet");
        this.web3Wallet = web3Wallet;
        return this;
    }

    /**
     * Counts users with the user ids specified.
     * Accepts up to 100 user ids.
     * Any user ids not found are ignored.
     */
    public GetUsersCountRequest withUserId(java.util.List<String> userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = Optional.ofNullable(userId);
        return this;
    }

    /**
     * Counts users with the user ids specified.
     * Accepts up to 100 user ids.
     * Any user ids not found are ignored.
     */
    public GetUsersCountRequest withUserId(Optional<? extends java.util.List<String>> userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = userId;
        return this;
    }

    /**
     * Counts users that match the given query.
     * For possible matches, we check the email addresses, phone numbers, usernames, web3 wallets, user ids, first and last names.
     * The query value doesn't need to match the exact value you are looking for, it is capable of partial matches as well.
     */
    public GetUsersCountRequest withQuery(String query) {
        Utils.checkNotNull(query, "query");
        this.query = Optional.ofNullable(query);
        return this;
    }

    /**
     * Counts users that match the given query.
     * For possible matches, we check the email addresses, phone numbers, usernames, web3 wallets, user ids, first and last names.
     * The query value doesn't need to match the exact value you are looking for, it is capable of partial matches as well.
     */
    public GetUsersCountRequest withQuery(Optional<? extends String> query) {
        Utils.checkNotNull(query, "query");
        this.query = query;
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
        GetUsersCountRequest other = (GetUsersCountRequest) o;
        return 
            java.util.Objects.deepEquals(this.emailAddress, other.emailAddress) &&
            java.util.Objects.deepEquals(this.phoneNumber, other.phoneNumber) &&
            java.util.Objects.deepEquals(this.externalId, other.externalId) &&
            java.util.Objects.deepEquals(this.username, other.username) &&
            java.util.Objects.deepEquals(this.web3Wallet, other.web3Wallet) &&
            java.util.Objects.deepEquals(this.userId, other.userId) &&
            java.util.Objects.deepEquals(this.query, other.query);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(
            emailAddress,
            phoneNumber,
            externalId,
            username,
            web3Wallet,
            userId,
            query);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetUsersCountRequest.class,
                "emailAddress", emailAddress,
                "phoneNumber", phoneNumber,
                "externalId", externalId,
                "username", username,
                "web3Wallet", web3Wallet,
                "userId", userId,
                "query", query);
    }
    
    public final static class Builder {
 
        private Optional<? extends java.util.List<String>> emailAddress = Optional.empty();
 
        private Optional<? extends java.util.List<String>> phoneNumber = Optional.empty();
 
        private Optional<? extends java.util.List<String>> externalId = Optional.empty();
 
        private Optional<? extends java.util.List<String>> username = Optional.empty();
 
        private Optional<? extends java.util.List<String>> web3Wallet = Optional.empty();
 
        private Optional<? extends java.util.List<String>> userId = Optional.empty();
 
        private Optional<? extends String> query = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Counts users with the specified email addresses.
         * Accepts up to 100 email addresses.
         * Any email addresses not found are ignored.
         */
        public Builder emailAddress(java.util.List<String> emailAddress) {
            Utils.checkNotNull(emailAddress, "emailAddress");
            this.emailAddress = Optional.ofNullable(emailAddress);
            return this;
        }

        /**
         * Counts users with the specified email addresses.
         * Accepts up to 100 email addresses.
         * Any email addresses not found are ignored.
         */
        public Builder emailAddress(Optional<? extends java.util.List<String>> emailAddress) {
            Utils.checkNotNull(emailAddress, "emailAddress");
            this.emailAddress = emailAddress;
            return this;
        }

        /**
         * Counts users with the specified phone numbers.
         * Accepts up to 100 phone numbers.
         * Any phone numbers not found are ignored.
         */
        public Builder phoneNumber(java.util.List<String> phoneNumber) {
            Utils.checkNotNull(phoneNumber, "phoneNumber");
            this.phoneNumber = Optional.ofNullable(phoneNumber);
            return this;
        }

        /**
         * Counts users with the specified phone numbers.
         * Accepts up to 100 phone numbers.
         * Any phone numbers not found are ignored.
         */
        public Builder phoneNumber(Optional<? extends java.util.List<String>> phoneNumber) {
            Utils.checkNotNull(phoneNumber, "phoneNumber");
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Counts users with the specified external ids.
         * Accepts up to 100 external ids.
         * Any external ids not found are ignored.
         */
        public Builder externalId(java.util.List<String> externalId) {
            Utils.checkNotNull(externalId, "externalId");
            this.externalId = Optional.ofNullable(externalId);
            return this;
        }

        /**
         * Counts users with the specified external ids.
         * Accepts up to 100 external ids.
         * Any external ids not found are ignored.
         */
        public Builder externalId(Optional<? extends java.util.List<String>> externalId) {
            Utils.checkNotNull(externalId, "externalId");
            this.externalId = externalId;
            return this;
        }

        /**
         * Counts users with the specified usernames.
         * Accepts up to 100 usernames.
         * Any usernames not found are ignored.
         */
        public Builder username(java.util.List<String> username) {
            Utils.checkNotNull(username, "username");
            this.username = Optional.ofNullable(username);
            return this;
        }

        /**
         * Counts users with the specified usernames.
         * Accepts up to 100 usernames.
         * Any usernames not found are ignored.
         */
        public Builder username(Optional<? extends java.util.List<String>> username) {
            Utils.checkNotNull(username, "username");
            this.username = username;
            return this;
        }

        /**
         * Counts users with the specified web3 wallet addresses.
         * Accepts up to 100 web3 wallet addresses.
         * Any web3 wallet addressed not found are ignored.
         */
        public Builder web3Wallet(java.util.List<String> web3Wallet) {
            Utils.checkNotNull(web3Wallet, "web3Wallet");
            this.web3Wallet = Optional.ofNullable(web3Wallet);
            return this;
        }

        /**
         * Counts users with the specified web3 wallet addresses.
         * Accepts up to 100 web3 wallet addresses.
         * Any web3 wallet addressed not found are ignored.
         */
        public Builder web3Wallet(Optional<? extends java.util.List<String>> web3Wallet) {
            Utils.checkNotNull(web3Wallet, "web3Wallet");
            this.web3Wallet = web3Wallet;
            return this;
        }

        /**
         * Counts users with the user ids specified.
         * Accepts up to 100 user ids.
         * Any user ids not found are ignored.
         */
        public Builder userId(java.util.List<String> userId) {
            Utils.checkNotNull(userId, "userId");
            this.userId = Optional.ofNullable(userId);
            return this;
        }

        /**
         * Counts users with the user ids specified.
         * Accepts up to 100 user ids.
         * Any user ids not found are ignored.
         */
        public Builder userId(Optional<? extends java.util.List<String>> userId) {
            Utils.checkNotNull(userId, "userId");
            this.userId = userId;
            return this;
        }

        /**
         * Counts users that match the given query.
         * For possible matches, we check the email addresses, phone numbers, usernames, web3 wallets, user ids, first and last names.
         * The query value doesn't need to match the exact value you are looking for, it is capable of partial matches as well.
         */
        public Builder query(String query) {
            Utils.checkNotNull(query, "query");
            this.query = Optional.ofNullable(query);
            return this;
        }

        /**
         * Counts users that match the given query.
         * For possible matches, we check the email addresses, phone numbers, usernames, web3 wallets, user ids, first and last names.
         * The query value doesn't need to match the exact value you are looking for, it is capable of partial matches as well.
         */
        public Builder query(Optional<? extends String> query) {
            Utils.checkNotNull(query, "query");
            this.query = query;
            return this;
        }
        
        public GetUsersCountRequest build() {
            return new GetUsersCountRequest(
                emailAddress,
                phoneNumber,
                externalId,
                username,
                web3Wallet,
                userId,
                query);
        }
    }
}

