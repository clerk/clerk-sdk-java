/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;


import com.clerk.backend_api.utils.SpeakeasyMetadata;
import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class GetUsersCountRequest {

    /**
     * Counts users with the specified email addresses.
     * Accepts up to 100 email addresses.
     * Any email addresses not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=email_address")
    private Optional<? extends List<String>> emailAddress;

    /**
     * Counts users with the specified phone numbers.
     * Accepts up to 100 phone numbers.
     * Any phone numbers not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=phone_number")
    private Optional<? extends List<String>> phoneNumber;

    /**
     * Counts users with the specified external ids.
     * Accepts up to 100 external ids.
     * Any external ids not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=external_id")
    private Optional<? extends List<String>> externalId;

    /**
     * Counts users with the specified usernames.
     * Accepts up to 100 usernames.
     * Any usernames not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=username")
    private Optional<? extends List<String>> username;

    /**
     * Counts users with the specified web3 wallet addresses.
     * Accepts up to 100 web3 wallet addresses.
     * Any web3 wallet addressed not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=web3_wallet")
    private Optional<? extends List<String>> web3Wallet;

    /**
     * Counts users with the user ids specified.
     * Accepts up to 100 user ids.
     * Any user ids not found are ignored.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=user_id")
    private Optional<? extends List<String>> userId;

    /**
     * Counts users that match the given query.
     * For possible matches, we check the email addresses, phone numbers, usernames, web3 wallets, user ids, first and last names.
     * The query value doesn't need to match the exact value you are looking for, it is capable of partial matches as well.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=query")
    private Optional<String> query;

    /**
     * Counts users with emails that match the given query, via case-insensitive partial match.
     * For example, `email_address_query=ello` will match a user with the email `HELLO@example.com`,
     * and will be included in the resulting count.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=email_address_query")
    private Optional<String> emailAddressQuery;

    /**
     * Counts users with phone numbers that match the given query, via case-insensitive partial match.
     * For example, `phone_number_query=555` will match a user with the phone number `+1555xxxxxxx`,
     * and will be included in the resulting count.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=phone_number_query")
    private Optional<String> phoneNumberQuery;

    /**
     * Counts users with usernames that match the given query, via case-insensitive partial match.
     * For example, `username_query=CoolUser` will match a user with the username `SomeCoolUser`,
     * and will be included in the resulting count.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=username_query")
    private Optional<String> usernameQuery;

    /**
     * Counts users which are either banned (`banned=true`) or not banned (`banned=false`).
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=banned")
    private Optional<Boolean> banned;

    @JsonCreator
    public GetUsersCountRequest(
            Optional<? extends List<String>> emailAddress,
            Optional<? extends List<String>> phoneNumber,
            Optional<? extends List<String>> externalId,
            Optional<? extends List<String>> username,
            Optional<? extends List<String>> web3Wallet,
            Optional<? extends List<String>> userId,
            Optional<String> query,
            Optional<String> emailAddressQuery,
            Optional<String> phoneNumberQuery,
            Optional<String> usernameQuery,
            Optional<Boolean> banned) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        Utils.checkNotNull(phoneNumber, "phoneNumber");
        Utils.checkNotNull(externalId, "externalId");
        Utils.checkNotNull(username, "username");
        Utils.checkNotNull(web3Wallet, "web3Wallet");
        Utils.checkNotNull(userId, "userId");
        Utils.checkNotNull(query, "query");
        Utils.checkNotNull(emailAddressQuery, "emailAddressQuery");
        Utils.checkNotNull(phoneNumberQuery, "phoneNumberQuery");
        Utils.checkNotNull(usernameQuery, "usernameQuery");
        Utils.checkNotNull(banned, "banned");
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.externalId = externalId;
        this.username = username;
        this.web3Wallet = web3Wallet;
        this.userId = userId;
        this.query = query;
        this.emailAddressQuery = emailAddressQuery;
        this.phoneNumberQuery = phoneNumberQuery;
        this.usernameQuery = usernameQuery;
        this.banned = banned;
    }
    
    public GetUsersCountRequest() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * Counts users with the specified email addresses.
     * Accepts up to 100 email addresses.
     * Any email addresses not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> emailAddress() {
        return (Optional<List<String>>) emailAddress;
    }

    /**
     * Counts users with the specified phone numbers.
     * Accepts up to 100 phone numbers.
     * Any phone numbers not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> phoneNumber() {
        return (Optional<List<String>>) phoneNumber;
    }

    /**
     * Counts users with the specified external ids.
     * Accepts up to 100 external ids.
     * Any external ids not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> externalId() {
        return (Optional<List<String>>) externalId;
    }

    /**
     * Counts users with the specified usernames.
     * Accepts up to 100 usernames.
     * Any usernames not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> username() {
        return (Optional<List<String>>) username;
    }

    /**
     * Counts users with the specified web3 wallet addresses.
     * Accepts up to 100 web3 wallet addresses.
     * Any web3 wallet addressed not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> web3Wallet() {
        return (Optional<List<String>>) web3Wallet;
    }

    /**
     * Counts users with the user ids specified.
     * Accepts up to 100 user ids.
     * Any user ids not found are ignored.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> userId() {
        return (Optional<List<String>>) userId;
    }

    /**
     * Counts users that match the given query.
     * For possible matches, we check the email addresses, phone numbers, usernames, web3 wallets, user ids, first and last names.
     * The query value doesn't need to match the exact value you are looking for, it is capable of partial matches as well.
     */
    @JsonIgnore
    public Optional<String> query() {
        return query;
    }

    /**
     * Counts users with emails that match the given query, via case-insensitive partial match.
     * For example, `email_address_query=ello` will match a user with the email `HELLO@example.com`,
     * and will be included in the resulting count.
     */
    @JsonIgnore
    public Optional<String> emailAddressQuery() {
        return emailAddressQuery;
    }

    /**
     * Counts users with phone numbers that match the given query, via case-insensitive partial match.
     * For example, `phone_number_query=555` will match a user with the phone number `+1555xxxxxxx`,
     * and will be included in the resulting count.
     */
    @JsonIgnore
    public Optional<String> phoneNumberQuery() {
        return phoneNumberQuery;
    }

    /**
     * Counts users with usernames that match the given query, via case-insensitive partial match.
     * For example, `username_query=CoolUser` will match a user with the username `SomeCoolUser`,
     * and will be included in the resulting count.
     */
    @JsonIgnore
    public Optional<String> usernameQuery() {
        return usernameQuery;
    }

    /**
     * Counts users which are either banned (`banned=true`) or not banned (`banned=false`).
     */
    @JsonIgnore
    public Optional<Boolean> banned() {
        return banned;
    }

    public final static Builder builder() {
        return new Builder();
    }

    /**
     * Counts users with the specified email addresses.
     * Accepts up to 100 email addresses.
     * Any email addresses not found are ignored.
     */
    public GetUsersCountRequest withEmailAddress(List<String> emailAddress) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        this.emailAddress = Optional.ofNullable(emailAddress);
        return this;
    }

    /**
     * Counts users with the specified email addresses.
     * Accepts up to 100 email addresses.
     * Any email addresses not found are ignored.
     */
    public GetUsersCountRequest withEmailAddress(Optional<? extends List<String>> emailAddress) {
        Utils.checkNotNull(emailAddress, "emailAddress");
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Counts users with the specified phone numbers.
     * Accepts up to 100 phone numbers.
     * Any phone numbers not found are ignored.
     */
    public GetUsersCountRequest withPhoneNumber(List<String> phoneNumber) {
        Utils.checkNotNull(phoneNumber, "phoneNumber");
        this.phoneNumber = Optional.ofNullable(phoneNumber);
        return this;
    }

    /**
     * Counts users with the specified phone numbers.
     * Accepts up to 100 phone numbers.
     * Any phone numbers not found are ignored.
     */
    public GetUsersCountRequest withPhoneNumber(Optional<? extends List<String>> phoneNumber) {
        Utils.checkNotNull(phoneNumber, "phoneNumber");
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Counts users with the specified external ids.
     * Accepts up to 100 external ids.
     * Any external ids not found are ignored.
     */
    public GetUsersCountRequest withExternalId(List<String> externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = Optional.ofNullable(externalId);
        return this;
    }

    /**
     * Counts users with the specified external ids.
     * Accepts up to 100 external ids.
     * Any external ids not found are ignored.
     */
    public GetUsersCountRequest withExternalId(Optional<? extends List<String>> externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = externalId;
        return this;
    }

    /**
     * Counts users with the specified usernames.
     * Accepts up to 100 usernames.
     * Any usernames not found are ignored.
     */
    public GetUsersCountRequest withUsername(List<String> username) {
        Utils.checkNotNull(username, "username");
        this.username = Optional.ofNullable(username);
        return this;
    }

    /**
     * Counts users with the specified usernames.
     * Accepts up to 100 usernames.
     * Any usernames not found are ignored.
     */
    public GetUsersCountRequest withUsername(Optional<? extends List<String>> username) {
        Utils.checkNotNull(username, "username");
        this.username = username;
        return this;
    }

    /**
     * Counts users with the specified web3 wallet addresses.
     * Accepts up to 100 web3 wallet addresses.
     * Any web3 wallet addressed not found are ignored.
     */
    public GetUsersCountRequest withWeb3Wallet(List<String> web3Wallet) {
        Utils.checkNotNull(web3Wallet, "web3Wallet");
        this.web3Wallet = Optional.ofNullable(web3Wallet);
        return this;
    }

    /**
     * Counts users with the specified web3 wallet addresses.
     * Accepts up to 100 web3 wallet addresses.
     * Any web3 wallet addressed not found are ignored.
     */
    public GetUsersCountRequest withWeb3Wallet(Optional<? extends List<String>> web3Wallet) {
        Utils.checkNotNull(web3Wallet, "web3Wallet");
        this.web3Wallet = web3Wallet;
        return this;
    }

    /**
     * Counts users with the user ids specified.
     * Accepts up to 100 user ids.
     * Any user ids not found are ignored.
     */
    public GetUsersCountRequest withUserId(List<String> userId) {
        Utils.checkNotNull(userId, "userId");
        this.userId = Optional.ofNullable(userId);
        return this;
    }

    /**
     * Counts users with the user ids specified.
     * Accepts up to 100 user ids.
     * Any user ids not found are ignored.
     */
    public GetUsersCountRequest withUserId(Optional<? extends List<String>> userId) {
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
    public GetUsersCountRequest withQuery(Optional<String> query) {
        Utils.checkNotNull(query, "query");
        this.query = query;
        return this;
    }

    /**
     * Counts users with emails that match the given query, via case-insensitive partial match.
     * For example, `email_address_query=ello` will match a user with the email `HELLO@example.com`,
     * and will be included in the resulting count.
     */
    public GetUsersCountRequest withEmailAddressQuery(String emailAddressQuery) {
        Utils.checkNotNull(emailAddressQuery, "emailAddressQuery");
        this.emailAddressQuery = Optional.ofNullable(emailAddressQuery);
        return this;
    }

    /**
     * Counts users with emails that match the given query, via case-insensitive partial match.
     * For example, `email_address_query=ello` will match a user with the email `HELLO@example.com`,
     * and will be included in the resulting count.
     */
    public GetUsersCountRequest withEmailAddressQuery(Optional<String> emailAddressQuery) {
        Utils.checkNotNull(emailAddressQuery, "emailAddressQuery");
        this.emailAddressQuery = emailAddressQuery;
        return this;
    }

    /**
     * Counts users with phone numbers that match the given query, via case-insensitive partial match.
     * For example, `phone_number_query=555` will match a user with the phone number `+1555xxxxxxx`,
     * and will be included in the resulting count.
     */
    public GetUsersCountRequest withPhoneNumberQuery(String phoneNumberQuery) {
        Utils.checkNotNull(phoneNumberQuery, "phoneNumberQuery");
        this.phoneNumberQuery = Optional.ofNullable(phoneNumberQuery);
        return this;
    }

    /**
     * Counts users with phone numbers that match the given query, via case-insensitive partial match.
     * For example, `phone_number_query=555` will match a user with the phone number `+1555xxxxxxx`,
     * and will be included in the resulting count.
     */
    public GetUsersCountRequest withPhoneNumberQuery(Optional<String> phoneNumberQuery) {
        Utils.checkNotNull(phoneNumberQuery, "phoneNumberQuery");
        this.phoneNumberQuery = phoneNumberQuery;
        return this;
    }

    /**
     * Counts users with usernames that match the given query, via case-insensitive partial match.
     * For example, `username_query=CoolUser` will match a user with the username `SomeCoolUser`,
     * and will be included in the resulting count.
     */
    public GetUsersCountRequest withUsernameQuery(String usernameQuery) {
        Utils.checkNotNull(usernameQuery, "usernameQuery");
        this.usernameQuery = Optional.ofNullable(usernameQuery);
        return this;
    }

    /**
     * Counts users with usernames that match the given query, via case-insensitive partial match.
     * For example, `username_query=CoolUser` will match a user with the username `SomeCoolUser`,
     * and will be included in the resulting count.
     */
    public GetUsersCountRequest withUsernameQuery(Optional<String> usernameQuery) {
        Utils.checkNotNull(usernameQuery, "usernameQuery");
        this.usernameQuery = usernameQuery;
        return this;
    }

    /**
     * Counts users which are either banned (`banned=true`) or not banned (`banned=false`).
     */
    public GetUsersCountRequest withBanned(boolean banned) {
        Utils.checkNotNull(banned, "banned");
        this.banned = Optional.ofNullable(banned);
        return this;
    }

    /**
     * Counts users which are either banned (`banned=true`) or not banned (`banned=false`).
     */
    public GetUsersCountRequest withBanned(Optional<Boolean> banned) {
        Utils.checkNotNull(banned, "banned");
        this.banned = banned;
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
            Objects.deepEquals(this.emailAddress, other.emailAddress) &&
            Objects.deepEquals(this.phoneNumber, other.phoneNumber) &&
            Objects.deepEquals(this.externalId, other.externalId) &&
            Objects.deepEquals(this.username, other.username) &&
            Objects.deepEquals(this.web3Wallet, other.web3Wallet) &&
            Objects.deepEquals(this.userId, other.userId) &&
            Objects.deepEquals(this.query, other.query) &&
            Objects.deepEquals(this.emailAddressQuery, other.emailAddressQuery) &&
            Objects.deepEquals(this.phoneNumberQuery, other.phoneNumberQuery) &&
            Objects.deepEquals(this.usernameQuery, other.usernameQuery) &&
            Objects.deepEquals(this.banned, other.banned);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            emailAddress,
            phoneNumber,
            externalId,
            username,
            web3Wallet,
            userId,
            query,
            emailAddressQuery,
            phoneNumberQuery,
            usernameQuery,
            banned);
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
                "query", query,
                "emailAddressQuery", emailAddressQuery,
                "phoneNumberQuery", phoneNumberQuery,
                "usernameQuery", usernameQuery,
                "banned", banned);
    }
    
    public final static class Builder {
 
        private Optional<? extends List<String>> emailAddress = Optional.empty();
 
        private Optional<? extends List<String>> phoneNumber = Optional.empty();
 
        private Optional<? extends List<String>> externalId = Optional.empty();
 
        private Optional<? extends List<String>> username = Optional.empty();
 
        private Optional<? extends List<String>> web3Wallet = Optional.empty();
 
        private Optional<? extends List<String>> userId = Optional.empty();
 
        private Optional<String> query = Optional.empty();
 
        private Optional<String> emailAddressQuery = Optional.empty();
 
        private Optional<String> phoneNumberQuery = Optional.empty();
 
        private Optional<String> usernameQuery = Optional.empty();
 
        private Optional<Boolean> banned = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Counts users with the specified email addresses.
         * Accepts up to 100 email addresses.
         * Any email addresses not found are ignored.
         */
        public Builder emailAddress(List<String> emailAddress) {
            Utils.checkNotNull(emailAddress, "emailAddress");
            this.emailAddress = Optional.ofNullable(emailAddress);
            return this;
        }

        /**
         * Counts users with the specified email addresses.
         * Accepts up to 100 email addresses.
         * Any email addresses not found are ignored.
         */
        public Builder emailAddress(Optional<? extends List<String>> emailAddress) {
            Utils.checkNotNull(emailAddress, "emailAddress");
            this.emailAddress = emailAddress;
            return this;
        }

        /**
         * Counts users with the specified phone numbers.
         * Accepts up to 100 phone numbers.
         * Any phone numbers not found are ignored.
         */
        public Builder phoneNumber(List<String> phoneNumber) {
            Utils.checkNotNull(phoneNumber, "phoneNumber");
            this.phoneNumber = Optional.ofNullable(phoneNumber);
            return this;
        }

        /**
         * Counts users with the specified phone numbers.
         * Accepts up to 100 phone numbers.
         * Any phone numbers not found are ignored.
         */
        public Builder phoneNumber(Optional<? extends List<String>> phoneNumber) {
            Utils.checkNotNull(phoneNumber, "phoneNumber");
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Counts users with the specified external ids.
         * Accepts up to 100 external ids.
         * Any external ids not found are ignored.
         */
        public Builder externalId(List<String> externalId) {
            Utils.checkNotNull(externalId, "externalId");
            this.externalId = Optional.ofNullable(externalId);
            return this;
        }

        /**
         * Counts users with the specified external ids.
         * Accepts up to 100 external ids.
         * Any external ids not found are ignored.
         */
        public Builder externalId(Optional<? extends List<String>> externalId) {
            Utils.checkNotNull(externalId, "externalId");
            this.externalId = externalId;
            return this;
        }

        /**
         * Counts users with the specified usernames.
         * Accepts up to 100 usernames.
         * Any usernames not found are ignored.
         */
        public Builder username(List<String> username) {
            Utils.checkNotNull(username, "username");
            this.username = Optional.ofNullable(username);
            return this;
        }

        /**
         * Counts users with the specified usernames.
         * Accepts up to 100 usernames.
         * Any usernames not found are ignored.
         */
        public Builder username(Optional<? extends List<String>> username) {
            Utils.checkNotNull(username, "username");
            this.username = username;
            return this;
        }

        /**
         * Counts users with the specified web3 wallet addresses.
         * Accepts up to 100 web3 wallet addresses.
         * Any web3 wallet addressed not found are ignored.
         */
        public Builder web3Wallet(List<String> web3Wallet) {
            Utils.checkNotNull(web3Wallet, "web3Wallet");
            this.web3Wallet = Optional.ofNullable(web3Wallet);
            return this;
        }

        /**
         * Counts users with the specified web3 wallet addresses.
         * Accepts up to 100 web3 wallet addresses.
         * Any web3 wallet addressed not found are ignored.
         */
        public Builder web3Wallet(Optional<? extends List<String>> web3Wallet) {
            Utils.checkNotNull(web3Wallet, "web3Wallet");
            this.web3Wallet = web3Wallet;
            return this;
        }

        /**
         * Counts users with the user ids specified.
         * Accepts up to 100 user ids.
         * Any user ids not found are ignored.
         */
        public Builder userId(List<String> userId) {
            Utils.checkNotNull(userId, "userId");
            this.userId = Optional.ofNullable(userId);
            return this;
        }

        /**
         * Counts users with the user ids specified.
         * Accepts up to 100 user ids.
         * Any user ids not found are ignored.
         */
        public Builder userId(Optional<? extends List<String>> userId) {
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
        public Builder query(Optional<String> query) {
            Utils.checkNotNull(query, "query");
            this.query = query;
            return this;
        }

        /**
         * Counts users with emails that match the given query, via case-insensitive partial match.
         * For example, `email_address_query=ello` will match a user with the email `HELLO@example.com`,
         * and will be included in the resulting count.
         */
        public Builder emailAddressQuery(String emailAddressQuery) {
            Utils.checkNotNull(emailAddressQuery, "emailAddressQuery");
            this.emailAddressQuery = Optional.ofNullable(emailAddressQuery);
            return this;
        }

        /**
         * Counts users with emails that match the given query, via case-insensitive partial match.
         * For example, `email_address_query=ello` will match a user with the email `HELLO@example.com`,
         * and will be included in the resulting count.
         */
        public Builder emailAddressQuery(Optional<String> emailAddressQuery) {
            Utils.checkNotNull(emailAddressQuery, "emailAddressQuery");
            this.emailAddressQuery = emailAddressQuery;
            return this;
        }

        /**
         * Counts users with phone numbers that match the given query, via case-insensitive partial match.
         * For example, `phone_number_query=555` will match a user with the phone number `+1555xxxxxxx`,
         * and will be included in the resulting count.
         */
        public Builder phoneNumberQuery(String phoneNumberQuery) {
            Utils.checkNotNull(phoneNumberQuery, "phoneNumberQuery");
            this.phoneNumberQuery = Optional.ofNullable(phoneNumberQuery);
            return this;
        }

        /**
         * Counts users with phone numbers that match the given query, via case-insensitive partial match.
         * For example, `phone_number_query=555` will match a user with the phone number `+1555xxxxxxx`,
         * and will be included in the resulting count.
         */
        public Builder phoneNumberQuery(Optional<String> phoneNumberQuery) {
            Utils.checkNotNull(phoneNumberQuery, "phoneNumberQuery");
            this.phoneNumberQuery = phoneNumberQuery;
            return this;
        }

        /**
         * Counts users with usernames that match the given query, via case-insensitive partial match.
         * For example, `username_query=CoolUser` will match a user with the username `SomeCoolUser`,
         * and will be included in the resulting count.
         */
        public Builder usernameQuery(String usernameQuery) {
            Utils.checkNotNull(usernameQuery, "usernameQuery");
            this.usernameQuery = Optional.ofNullable(usernameQuery);
            return this;
        }

        /**
         * Counts users with usernames that match the given query, via case-insensitive partial match.
         * For example, `username_query=CoolUser` will match a user with the username `SomeCoolUser`,
         * and will be included in the resulting count.
         */
        public Builder usernameQuery(Optional<String> usernameQuery) {
            Utils.checkNotNull(usernameQuery, "usernameQuery");
            this.usernameQuery = usernameQuery;
            return this;
        }

        /**
         * Counts users which are either banned (`banned=true`) or not banned (`banned=false`).
         */
        public Builder banned(boolean banned) {
            Utils.checkNotNull(banned, "banned");
            this.banned = Optional.ofNullable(banned);
            return this;
        }

        /**
         * Counts users which are either banned (`banned=true`) or not banned (`banned=false`).
         */
        public Builder banned(Optional<Boolean> banned) {
            Utils.checkNotNull(banned, "banned");
            this.banned = banned;
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
                query,
                emailAddressQuery,
                phoneNumberQuery,
                usernameQuery,
                banned);
        }
    }
}

