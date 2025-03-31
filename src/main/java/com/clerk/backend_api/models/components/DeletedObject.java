/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.clerk.backend_api.models.components;

import com.clerk.backend_api.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * DeletedObject
 * 
 * <p>Deleted Object
 */
public class DeletedObject {

    @JsonProperty("object")
    private String object;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    private Optional<String> id;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("slug")
    private Optional<String> slug;

    @JsonProperty("deleted")
    private boolean deleted;

    @JsonCreator
    public DeletedObject(
            @JsonProperty("object") String object,
            @JsonProperty("id") Optional<String> id,
            @JsonProperty("slug") Optional<String> slug,
            @JsonProperty("deleted") boolean deleted) {
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(slug, "slug");
        Utils.checkNotNull(deleted, "deleted");
        this.object = object;
        this.id = id;
        this.slug = slug;
        this.deleted = deleted;
    }
    
    public DeletedObject(
            String object,
            boolean deleted) {
        this(object, Optional.empty(), Optional.empty(), deleted);
    }

    @JsonIgnore
    public String object() {
        return object;
    }

    @JsonIgnore
    public Optional<String> id() {
        return id;
    }

    @JsonIgnore
    public Optional<String> slug() {
        return slug;
    }

    @JsonIgnore
    public boolean deleted() {
        return deleted;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public DeletedObject withObject(String object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public DeletedObject withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = Optional.ofNullable(id);
        return this;
    }

    public DeletedObject withId(Optional<String> id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    public DeletedObject withSlug(String slug) {
        Utils.checkNotNull(slug, "slug");
        this.slug = Optional.ofNullable(slug);
        return this;
    }

    public DeletedObject withSlug(Optional<String> slug) {
        Utils.checkNotNull(slug, "slug");
        this.slug = slug;
        return this;
    }

    public DeletedObject withDeleted(boolean deleted) {
        Utils.checkNotNull(deleted, "deleted");
        this.deleted = deleted;
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
        DeletedObject other = (DeletedObject) o;
        return 
            Objects.deepEquals(this.object, other.object) &&
            Objects.deepEquals(this.id, other.id) &&
            Objects.deepEquals(this.slug, other.slug) &&
            Objects.deepEquals(this.deleted, other.deleted);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            object,
            id,
            slug,
            deleted);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DeletedObject.class,
                "object", object,
                "id", id,
                "slug", slug,
                "deleted", deleted);
    }
    
    public final static class Builder {
 
        private String object;
 
        private Optional<String> id = Optional.empty();
 
        private Optional<String> slug = Optional.empty();
 
        private Boolean deleted;
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder object(String object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }

        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = Optional.ofNullable(id);
            return this;
        }

        public Builder id(Optional<String> id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }

        public Builder slug(String slug) {
            Utils.checkNotNull(slug, "slug");
            this.slug = Optional.ofNullable(slug);
            return this;
        }

        public Builder slug(Optional<String> slug) {
            Utils.checkNotNull(slug, "slug");
            this.slug = slug;
            return this;
        }

        public Builder deleted(boolean deleted) {
            Utils.checkNotNull(deleted, "deleted");
            this.deleted = deleted;
            return this;
        }
        
        public DeletedObject build() {
            return new DeletedObject(
                object,
                id,
                slug,
                deleted);
        }
    }
}
