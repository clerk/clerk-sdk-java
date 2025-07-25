/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;

/**
 * InstanceRestrictions
 * 
 * <p>Success
 */
public class InstanceRestrictions {
    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    @JsonProperty("object")
    private InstanceRestrictionsObject object;


    @JsonProperty("allowlist")
    private boolean allowlist;


    @JsonProperty("blocklist")
    private boolean blocklist;


    @JsonProperty("block_email_subaddresses")
    private boolean blockEmailSubaddresses;


    @JsonProperty("block_disposable_email_domains")
    private boolean blockDisposableEmailDomains;


    @JsonProperty("ignore_dots_for_gmail_addresses")
    private boolean ignoreDotsForGmailAddresses;

    @JsonCreator
    public InstanceRestrictions(
            @JsonProperty("object") InstanceRestrictionsObject object,
            @JsonProperty("allowlist") boolean allowlist,
            @JsonProperty("blocklist") boolean blocklist,
            @JsonProperty("block_email_subaddresses") boolean blockEmailSubaddresses,
            @JsonProperty("block_disposable_email_domains") boolean blockDisposableEmailDomains,
            @JsonProperty("ignore_dots_for_gmail_addresses") boolean ignoreDotsForGmailAddresses) {
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(allowlist, "allowlist");
        Utils.checkNotNull(blocklist, "blocklist");
        Utils.checkNotNull(blockEmailSubaddresses, "blockEmailSubaddresses");
        Utils.checkNotNull(blockDisposableEmailDomains, "blockDisposableEmailDomains");
        Utils.checkNotNull(ignoreDotsForGmailAddresses, "ignoreDotsForGmailAddresses");
        this.object = object;
        this.allowlist = allowlist;
        this.blocklist = blocklist;
        this.blockEmailSubaddresses = blockEmailSubaddresses;
        this.blockDisposableEmailDomains = blockDisposableEmailDomains;
        this.ignoreDotsForGmailAddresses = ignoreDotsForGmailAddresses;
    }

    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    @JsonIgnore
    public InstanceRestrictionsObject object() {
        return object;
    }

    @JsonIgnore
    public boolean allowlist() {
        return allowlist;
    }

    @JsonIgnore
    public boolean blocklist() {
        return blocklist;
    }

    @JsonIgnore
    public boolean blockEmailSubaddresses() {
        return blockEmailSubaddresses;
    }

    @JsonIgnore
    public boolean blockDisposableEmailDomains() {
        return blockDisposableEmailDomains;
    }

    @JsonIgnore
    public boolean ignoreDotsForGmailAddresses() {
        return ignoreDotsForGmailAddresses;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * String representing the object's type. Objects of the same type share the same value.
     */
    public InstanceRestrictions withObject(InstanceRestrictionsObject object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public InstanceRestrictions withAllowlist(boolean allowlist) {
        Utils.checkNotNull(allowlist, "allowlist");
        this.allowlist = allowlist;
        return this;
    }

    public InstanceRestrictions withBlocklist(boolean blocklist) {
        Utils.checkNotNull(blocklist, "blocklist");
        this.blocklist = blocklist;
        return this;
    }

    public InstanceRestrictions withBlockEmailSubaddresses(boolean blockEmailSubaddresses) {
        Utils.checkNotNull(blockEmailSubaddresses, "blockEmailSubaddresses");
        this.blockEmailSubaddresses = blockEmailSubaddresses;
        return this;
    }

    public InstanceRestrictions withBlockDisposableEmailDomains(boolean blockDisposableEmailDomains) {
        Utils.checkNotNull(blockDisposableEmailDomains, "blockDisposableEmailDomains");
        this.blockDisposableEmailDomains = blockDisposableEmailDomains;
        return this;
    }

    public InstanceRestrictions withIgnoreDotsForGmailAddresses(boolean ignoreDotsForGmailAddresses) {
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
        InstanceRestrictions other = (InstanceRestrictions) o;
        return 
            Utils.enhancedDeepEquals(this.object, other.object) &&
            Utils.enhancedDeepEquals(this.allowlist, other.allowlist) &&
            Utils.enhancedDeepEquals(this.blocklist, other.blocklist) &&
            Utils.enhancedDeepEquals(this.blockEmailSubaddresses, other.blockEmailSubaddresses) &&
            Utils.enhancedDeepEquals(this.blockDisposableEmailDomains, other.blockDisposableEmailDomains) &&
            Utils.enhancedDeepEquals(this.ignoreDotsForGmailAddresses, other.ignoreDotsForGmailAddresses);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            object, allowlist, blocklist,
            blockEmailSubaddresses, blockDisposableEmailDomains, ignoreDotsForGmailAddresses);
    }
    
    @Override
    public String toString() {
        return Utils.toString(InstanceRestrictions.class,
                "object", object,
                "allowlist", allowlist,
                "blocklist", blocklist,
                "blockEmailSubaddresses", blockEmailSubaddresses,
                "blockDisposableEmailDomains", blockDisposableEmailDomains,
                "ignoreDotsForGmailAddresses", ignoreDotsForGmailAddresses);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private InstanceRestrictionsObject object;

        private Boolean allowlist;

        private Boolean blocklist;

        private Boolean blockEmailSubaddresses;

        private Boolean blockDisposableEmailDomains;

        private Boolean ignoreDotsForGmailAddresses;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * String representing the object's type. Objects of the same type share the same value.
         */
        public Builder object(InstanceRestrictionsObject object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }


        public Builder allowlist(boolean allowlist) {
            Utils.checkNotNull(allowlist, "allowlist");
            this.allowlist = allowlist;
            return this;
        }


        public Builder blocklist(boolean blocklist) {
            Utils.checkNotNull(blocklist, "blocklist");
            this.blocklist = blocklist;
            return this;
        }


        public Builder blockEmailSubaddresses(boolean blockEmailSubaddresses) {
            Utils.checkNotNull(blockEmailSubaddresses, "blockEmailSubaddresses");
            this.blockEmailSubaddresses = blockEmailSubaddresses;
            return this;
        }


        public Builder blockDisposableEmailDomains(boolean blockDisposableEmailDomains) {
            Utils.checkNotNull(blockDisposableEmailDomains, "blockDisposableEmailDomains");
            this.blockDisposableEmailDomains = blockDisposableEmailDomains;
            return this;
        }


        public Builder ignoreDotsForGmailAddresses(boolean ignoreDotsForGmailAddresses) {
            Utils.checkNotNull(ignoreDotsForGmailAddresses, "ignoreDotsForGmailAddresses");
            this.ignoreDotsForGmailAddresses = ignoreDotsForGmailAddresses;
            return this;
        }

        public InstanceRestrictions build() {

            return new InstanceRestrictions(
                object, allowlist, blocklist,
                blockEmailSubaddresses, blockDisposableEmailDomains, ignoreDotsForGmailAddresses);
        }

    }
}
