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
import java.lang.Override;
import java.lang.String;
import java.util.Optional;


public class Keys {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("use")
    private Optional<String> use;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("kty")
    private Optional<String> kty;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("kid")
    private Optional<String> kid;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("alg")
    private Optional<String> alg;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("n")
    private Optional<String> n;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("e")
    private Optional<String> e;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("x")
    private Optional<String> x;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("crv")
    private Optional<String> crv;

    @JsonCreator
    public Keys(
            @JsonProperty("use") Optional<String> use,
            @JsonProperty("kty") Optional<String> kty,
            @JsonProperty("kid") Optional<String> kid,
            @JsonProperty("alg") Optional<String> alg,
            @JsonProperty("n") Optional<String> n,
            @JsonProperty("e") Optional<String> e,
            @JsonProperty("x") Optional<String> x,
            @JsonProperty("crv") Optional<String> crv) {
        Utils.checkNotNull(use, "use");
        Utils.checkNotNull(kty, "kty");
        Utils.checkNotNull(kid, "kid");
        Utils.checkNotNull(alg, "alg");
        Utils.checkNotNull(n, "n");
        Utils.checkNotNull(e, "e");
        Utils.checkNotNull(x, "x");
        Utils.checkNotNull(crv, "crv");
        this.use = use;
        this.kty = kty;
        this.kid = kid;
        this.alg = alg;
        this.n = n;
        this.e = e;
        this.x = x;
        this.crv = crv;
    }
    
    public Keys() {
        this(Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty());
    }

    @JsonIgnore
    public Optional<String> use() {
        return use;
    }

    @JsonIgnore
    public Optional<String> kty() {
        return kty;
    }

    @JsonIgnore
    public Optional<String> kid() {
        return kid;
    }

    @JsonIgnore
    public Optional<String> alg() {
        return alg;
    }

    @JsonIgnore
    public Optional<String> n() {
        return n;
    }

    @JsonIgnore
    public Optional<String> e() {
        return e;
    }

    @JsonIgnore
    public Optional<String> x() {
        return x;
    }

    @JsonIgnore
    public Optional<String> crv() {
        return crv;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Keys withUse(String use) {
        Utils.checkNotNull(use, "use");
        this.use = Optional.ofNullable(use);
        return this;
    }


    public Keys withUse(Optional<String> use) {
        Utils.checkNotNull(use, "use");
        this.use = use;
        return this;
    }

    public Keys withKty(String kty) {
        Utils.checkNotNull(kty, "kty");
        this.kty = Optional.ofNullable(kty);
        return this;
    }


    public Keys withKty(Optional<String> kty) {
        Utils.checkNotNull(kty, "kty");
        this.kty = kty;
        return this;
    }

    public Keys withKid(String kid) {
        Utils.checkNotNull(kid, "kid");
        this.kid = Optional.ofNullable(kid);
        return this;
    }


    public Keys withKid(Optional<String> kid) {
        Utils.checkNotNull(kid, "kid");
        this.kid = kid;
        return this;
    }

    public Keys withAlg(String alg) {
        Utils.checkNotNull(alg, "alg");
        this.alg = Optional.ofNullable(alg);
        return this;
    }


    public Keys withAlg(Optional<String> alg) {
        Utils.checkNotNull(alg, "alg");
        this.alg = alg;
        return this;
    }

    public Keys withN(String n) {
        Utils.checkNotNull(n, "n");
        this.n = Optional.ofNullable(n);
        return this;
    }


    public Keys withN(Optional<String> n) {
        Utils.checkNotNull(n, "n");
        this.n = n;
        return this;
    }

    public Keys withE(String e) {
        Utils.checkNotNull(e, "e");
        this.e = Optional.ofNullable(e);
        return this;
    }


    public Keys withE(Optional<String> e) {
        Utils.checkNotNull(e, "e");
        this.e = e;
        return this;
    }

    public Keys withX(String x) {
        Utils.checkNotNull(x, "x");
        this.x = Optional.ofNullable(x);
        return this;
    }


    public Keys withX(Optional<String> x) {
        Utils.checkNotNull(x, "x");
        this.x = x;
        return this;
    }

    public Keys withCrv(String crv) {
        Utils.checkNotNull(crv, "crv");
        this.crv = Optional.ofNullable(crv);
        return this;
    }


    public Keys withCrv(Optional<String> crv) {
        Utils.checkNotNull(crv, "crv");
        this.crv = crv;
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
        Keys other = (Keys) o;
        return 
            Utils.enhancedDeepEquals(this.use, other.use) &&
            Utils.enhancedDeepEquals(this.kty, other.kty) &&
            Utils.enhancedDeepEquals(this.kid, other.kid) &&
            Utils.enhancedDeepEquals(this.alg, other.alg) &&
            Utils.enhancedDeepEquals(this.n, other.n) &&
            Utils.enhancedDeepEquals(this.e, other.e) &&
            Utils.enhancedDeepEquals(this.x, other.x) &&
            Utils.enhancedDeepEquals(this.crv, other.crv);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            use, kty, kid,
            alg, n, e,
            x, crv);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Keys.class,
                "use", use,
                "kty", kty,
                "kid", kid,
                "alg", alg,
                "n", n,
                "e", e,
                "x", x,
                "crv", crv);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> use = Optional.empty();

        private Optional<String> kty = Optional.empty();

        private Optional<String> kid = Optional.empty();

        private Optional<String> alg = Optional.empty();

        private Optional<String> n = Optional.empty();

        private Optional<String> e = Optional.empty();

        private Optional<String> x = Optional.empty();

        private Optional<String> crv = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        public Builder use(String use) {
            Utils.checkNotNull(use, "use");
            this.use = Optional.ofNullable(use);
            return this;
        }

        public Builder use(Optional<String> use) {
            Utils.checkNotNull(use, "use");
            this.use = use;
            return this;
        }


        public Builder kty(String kty) {
            Utils.checkNotNull(kty, "kty");
            this.kty = Optional.ofNullable(kty);
            return this;
        }

        public Builder kty(Optional<String> kty) {
            Utils.checkNotNull(kty, "kty");
            this.kty = kty;
            return this;
        }


        public Builder kid(String kid) {
            Utils.checkNotNull(kid, "kid");
            this.kid = Optional.ofNullable(kid);
            return this;
        }

        public Builder kid(Optional<String> kid) {
            Utils.checkNotNull(kid, "kid");
            this.kid = kid;
            return this;
        }


        public Builder alg(String alg) {
            Utils.checkNotNull(alg, "alg");
            this.alg = Optional.ofNullable(alg);
            return this;
        }

        public Builder alg(Optional<String> alg) {
            Utils.checkNotNull(alg, "alg");
            this.alg = alg;
            return this;
        }


        public Builder n(String n) {
            Utils.checkNotNull(n, "n");
            this.n = Optional.ofNullable(n);
            return this;
        }

        public Builder n(Optional<String> n) {
            Utils.checkNotNull(n, "n");
            this.n = n;
            return this;
        }


        public Builder e(String e) {
            Utils.checkNotNull(e, "e");
            this.e = Optional.ofNullable(e);
            return this;
        }

        public Builder e(Optional<String> e) {
            Utils.checkNotNull(e, "e");
            this.e = e;
            return this;
        }


        public Builder x(String x) {
            Utils.checkNotNull(x, "x");
            this.x = Optional.ofNullable(x);
            return this;
        }

        public Builder x(Optional<String> x) {
            Utils.checkNotNull(x, "x");
            this.x = x;
            return this;
        }


        public Builder crv(String crv) {
            Utils.checkNotNull(crv, "crv");
            this.crv = Optional.ofNullable(crv);
            return this;
        }

        public Builder crv(Optional<String> crv) {
            Utils.checkNotNull(crv, "crv");
            this.crv = crv;
            return this;
        }

        public Keys build() {

            return new Keys(
                use, kty, kid,
                alg, n, e,
                x, crv);
        }

    }
}
