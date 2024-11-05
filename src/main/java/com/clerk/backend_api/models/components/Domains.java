/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.components;


import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * Domains - A list of domains
 */

public class Domains {

    @JsonProperty("data")
    private List<Domain> data;

    /**
     * Total number of domains
     * 
     */
    @JsonProperty("total_count")
    private long totalCount;

    @JsonCreator
    public Domains(
            @JsonProperty("data") List<Domain> data,
            @JsonProperty("total_count") long totalCount) {
        Utils.checkNotNull(data, "data");
        Utils.checkNotNull(totalCount, "totalCount");
        this.data = data;
        this.totalCount = totalCount;
    }

    @JsonIgnore
    public List<Domain> data() {
        return data;
    }

    /**
     * Total number of domains
     * 
     */
    @JsonIgnore
    public long totalCount() {
        return totalCount;
    }

    public final static Builder builder() {
        return new Builder();
    }

    public Domains withData(List<Domain> data) {
        Utils.checkNotNull(data, "data");
        this.data = data;
        return this;
    }

    /**
     * Total number of domains
     * 
     */
    public Domains withTotalCount(long totalCount) {
        Utils.checkNotNull(totalCount, "totalCount");
        this.totalCount = totalCount;
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
        Domains other = (Domains) o;
        return 
            Objects.deepEquals(this.data, other.data) &&
            Objects.deepEquals(this.totalCount, other.totalCount);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            data,
            totalCount);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Domains.class,
                "data", data,
                "totalCount", totalCount);
    }
    
    public final static class Builder {
 
        private List<Domain> data;
 
        private Long totalCount;  
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder data(List<Domain> data) {
            Utils.checkNotNull(data, "data");
            this.data = data;
            return this;
        }

        /**
         * Total number of domains
         * 
         */
        public Builder totalCount(long totalCount) {
            Utils.checkNotNull(totalCount, "totalCount");
            this.totalCount = totalCount;
            return this;
        }
        
        public Domains build() {
            return new Domains(
                data,
                totalCount);
        }
    }
}

