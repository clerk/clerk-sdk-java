/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.operations;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import org.openapitools.jackson.nullable.JsonNullable;


public class UpdateInstanceRestrictionsRequestBody {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("allowlist")
    private JsonNullable<Boolean> allowlist;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("blocklist")
    private JsonNullable<Boolean> blocklist;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("block_email_subaddresses")
    private JsonNullable<Boolean> blockEmailSubaddresses;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("block_disposable_email_domains")
    private JsonNullable<Boolean> blockDisposableEmailDomains;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("ignore_dots_for_gmail_addresses")
    private JsonNullable<Boolean> ignoreDotsForGmailAddresses;

    @JsonCreator
    public UpdateInstanceRestrictionsRequestBody(
            @JsonProperty("allowlist") JsonNullable<Boolean> allowlist,
            @JsonProperty("blocklist") JsonNullable<Boolean> blocklist,
            @JsonProperty("block_email_subaddresses") JsonNullable<Boolean> blockEmailSubaddresses,
            @JsonProperty("block_disposable_email_domains") JsonNullable<Boolean> blockDisposableEmailDomains,
            @JsonProperty("ignore_dots_for_gmail_addresses") JsonNullable<Boolean> ignoreDotsForGmailAddresses) {
        Utils.checkNotNull(allowlist, "allowlist");
        Utils.checkNotNull(blocklist, "blocklist");
        Utils.checkNotNull(blockEmailSubaddresses, "blockEmailSubaddresses");
        Utils.checkNotNull(blockDisposableEmailDomains, "blockDisposableEmailDomains");
        Utils.checkNotNull(ignoreDotsForGmailAddresses, "ignoreDotsForGmailAddresses");
        this.allowlist = allowlist;
        this.blocklist = blocklist;
        this.blockEmailSubaddresses = blockEmailSubaddresses;
        this.blockDisposableEmailDomains = blockDisposableEmailDomains;
        this.ignoreDotsForGmailAddresses = ignoreDotsForGmailAddresses;
    }
    
    public UpdateInstanceRestrictionsRequestBody() {
        this(JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined());
    }

    @JsonIgnore
    public JsonNullable<Boolean> allowlist() {
        return allowlist;
    }

    @JsonIgnore
    public JsonNullable<Boolean> blocklist() {
        return blocklist;
    }

    @JsonIgnore
    public JsonNullable<Boolean> blockEmailSubaddresses() {
        return blockEmailSubaddresses;
    }

    @JsonIgnore
    public JsonNullable<Boolean> blockDisposableEmailDomains() {
        return blockDisposableEmailDomains;
    }

    @JsonIgnore
    public JsonNullable<Boolean> ignoreDotsForGmailAddresses() {
        return ignoreDotsForGmailAddresses;
    }

    public static Builder builder() {
        return new Builder();
    }


    public UpdateInstanceRestrictionsRequestBody withAllowlist(boolean allowlist) {
        Utils.checkNotNull(allowlist, "allowlist");
        this.allowlist = JsonNullable.of(allowlist);
        return this;
    }

    public UpdateInstanceRestrictionsRequestBody withAllowlist(JsonNullable<Boolean> allowlist) {
        Utils.checkNotNull(allowlist, "allowlist");
        this.allowlist = allowlist;
        return this;
    }

    public UpdateInstanceRestrictionsRequestBody withBlocklist(boolean blocklist) {
        Utils.checkNotNull(blocklist, "blocklist");
        this.blocklist = JsonNullable.of(blocklist);
        return this;
    }

    public UpdateInstanceRestrictionsRequestBody withBlocklist(JsonNullable<Boolean> blocklist) {
        Utils.checkNotNull(blocklist, "blocklist");
        this.blocklist = blocklist;
        return this;
    }

    public UpdateInstanceRestrictionsRequestBody withBlockEmailSubaddresses(boolean blockEmailSubaddresses) {
        Utils.checkNotNull(blockEmailSubaddresses, "blockEmailSubaddresses");
        this.blockEmailSubaddresses = JsonNullable.of(blockEmailSubaddresses);
        return this;
    }

    public UpdateInstanceRestrictionsRequestBody withBlockEmailSubaddresses(JsonNullable<Boolean> blockEmailSubaddresses) {
        Utils.checkNotNull(blockEmailSubaddresses, "blockEmailSubaddresses");
        this.blockEmailSubaddresses = blockEmailSubaddresses;
        return this;
    }

    public UpdateInstanceRestrictionsRequestBody withBlockDisposableEmailDomains(boolean blockDisposableEmailDomains) {
        Utils.checkNotNull(blockDisposableEmailDomains, "blockDisposableEmailDomains");
        this.blockDisposableEmailDomains = JsonNullable.of(blockDisposableEmailDomains);
        return this;
    }

    public UpdateInstanceRestrictionsRequestBody withBlockDisposableEmailDomains(JsonNullable<Boolean> blockDisposableEmailDomains) {
        Utils.checkNotNull(blockDisposableEmailDomains, "blockDisposableEmailDomains");
        this.blockDisposableEmailDomains = blockDisposableEmailDomains;
        return this;
    }

    public UpdateInstanceRestrictionsRequestBody withIgnoreDotsForGmailAddresses(boolean ignoreDotsForGmailAddresses) {
        Utils.checkNotNull(ignoreDotsForGmailAddresses, "ignoreDotsForGmailAddresses");
        this.ignoreDotsForGmailAddresses = JsonNullable.of(ignoreDotsForGmailAddresses);
        return this;
    }

    public UpdateInstanceRestrictionsRequestBody withIgnoreDotsForGmailAddresses(JsonNullable<Boolean> ignoreDotsForGmailAddresses) {
        Utils.checkNotNull(ignoreDotsForGmailAddresses, "ignoreDotsForGmailAddresses");
        this.ignoreDotsForGmailAddresses = ignoreDotsForGmailAddresses;
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
        UpdateInstanceRestrictionsRequestBody other = (UpdateInstanceRestrictionsRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.allowlist, other.allowlist) &&
            Utils.enhancedDeepEquals(this.blocklist, other.blocklist) &&
            Utils.enhancedDeepEquals(this.blockEmailSubaddresses, other.blockEmailSubaddresses) &&
            Utils.enhancedDeepEquals(this.blockDisposableEmailDomains, other.blockDisposableEmailDomains) &&
            Utils.enhancedDeepEquals(this.ignoreDotsForGmailAddresses, other.ignoreDotsForGmailAddresses);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            allowlist, blocklist, blockEmailSubaddresses,
            blockDisposableEmailDomains, ignoreDotsForGmailAddresses);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateInstanceRestrictionsRequestBody.class,
                "allowlist", allowlist,
                "blocklist", blocklist,
                "blockEmailSubaddresses", blockEmailSubaddresses,
                "blockDisposableEmailDomains", blockDisposableEmailDomains,
                "ignoreDotsForGmailAddresses", ignoreDotsForGmailAddresses);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private JsonNullable<Boolean> allowlist = JsonNullable.undefined();

        private JsonNullable<Boolean> blocklist = JsonNullable.undefined();

        private JsonNullable<Boolean> blockEmailSubaddresses = JsonNullable.undefined();

        private JsonNullable<Boolean> blockDisposableEmailDomains = JsonNullable.undefined();

        private JsonNullable<Boolean> ignoreDotsForGmailAddresses = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        public Builder allowlist(boolean allowlist) {
            Utils.checkNotNull(allowlist, "allowlist");
            this.allowlist = JsonNullable.of(allowlist);
            return this;
        }

        public Builder allowlist(JsonNullable<Boolean> allowlist) {
            Utils.checkNotNull(allowlist, "allowlist");
            this.allowlist = allowlist;
            return this;
        }


        public Builder blocklist(boolean blocklist) {
            Utils.checkNotNull(blocklist, "blocklist");
            this.blocklist = JsonNullable.of(blocklist);
            return this;
        }

        public Builder blocklist(JsonNullable<Boolean> blocklist) {
            Utils.checkNotNull(blocklist, "blocklist");
            this.blocklist = blocklist;
            return this;
        }


        public Builder blockEmailSubaddresses(boolean blockEmailSubaddresses) {
            Utils.checkNotNull(blockEmailSubaddresses, "blockEmailSubaddresses");
            this.blockEmailSubaddresses = JsonNullable.of(blockEmailSubaddresses);
            return this;
        }

        public Builder blockEmailSubaddresses(JsonNullable<Boolean> blockEmailSubaddresses) {
            Utils.checkNotNull(blockEmailSubaddresses, "blockEmailSubaddresses");
            this.blockEmailSubaddresses = blockEmailSubaddresses;
            return this;
        }


        public Builder blockDisposableEmailDomains(boolean blockDisposableEmailDomains) {
            Utils.checkNotNull(blockDisposableEmailDomains, "blockDisposableEmailDomains");
            this.blockDisposableEmailDomains = JsonNullable.of(blockDisposableEmailDomains);
            return this;
        }

        public Builder blockDisposableEmailDomains(JsonNullable<Boolean> blockDisposableEmailDomains) {
            Utils.checkNotNull(blockDisposableEmailDomains, "blockDisposableEmailDomains");
            this.blockDisposableEmailDomains = blockDisposableEmailDomains;
            return this;
        }


        public Builder ignoreDotsForGmailAddresses(boolean ignoreDotsForGmailAddresses) {
            Utils.checkNotNull(ignoreDotsForGmailAddresses, "ignoreDotsForGmailAddresses");
            this.ignoreDotsForGmailAddresses = JsonNullable.of(ignoreDotsForGmailAddresses);
            return this;
        }

        public Builder ignoreDotsForGmailAddresses(JsonNullable<Boolean> ignoreDotsForGmailAddresses) {
            Utils.checkNotNull(ignoreDotsForGmailAddresses, "ignoreDotsForGmailAddresses");
            this.ignoreDotsForGmailAddresses = ignoreDotsForGmailAddresses;
            return this;
        }

        public UpdateInstanceRestrictionsRequestBody build() {

            return new UpdateInstanceRestrictionsRequestBody(
                allowlist, blocklist, blockEmailSubaddresses,
                blockDisposableEmailDomains, ignoreDotsForGmailAddresses);
        }

    }
}
