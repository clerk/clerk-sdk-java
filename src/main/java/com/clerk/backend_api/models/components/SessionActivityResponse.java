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
import java.util.Optional;


public class SessionActivityResponse {

    @JsonProperty("object")
    private String object;


    @JsonProperty("id")
    private String id;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("device_type")
    private Optional<String> deviceType;


    @JsonProperty("is_mobile")
    private boolean isMobile;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("browser_name")
    private Optional<String> browserName;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("browser_version")
    private Optional<String> browserVersion;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("ip_address")
    private Optional<String> ipAddress;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("city")
    private Optional<String> city;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("country")
    private Optional<String> country;

    @JsonCreator
    public SessionActivityResponse(
            @JsonProperty("object") String object,
            @JsonProperty("id") String id,
            @JsonProperty("device_type") Optional<String> deviceType,
            @JsonProperty("is_mobile") boolean isMobile,
            @JsonProperty("browser_name") Optional<String> browserName,
            @JsonProperty("browser_version") Optional<String> browserVersion,
            @JsonProperty("ip_address") Optional<String> ipAddress,
            @JsonProperty("city") Optional<String> city,
            @JsonProperty("country") Optional<String> country) {
        Utils.checkNotNull(object, "object");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(deviceType, "deviceType");
        Utils.checkNotNull(isMobile, "isMobile");
        Utils.checkNotNull(browserName, "browserName");
        Utils.checkNotNull(browserVersion, "browserVersion");
        Utils.checkNotNull(ipAddress, "ipAddress");
        Utils.checkNotNull(city, "city");
        Utils.checkNotNull(country, "country");
        this.object = object;
        this.id = id;
        this.deviceType = deviceType;
        this.isMobile = isMobile;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.ipAddress = ipAddress;
        this.city = city;
        this.country = country;
    }
    
    public SessionActivityResponse(
            String object,
            String id,
            boolean isMobile) {
        this(object, id, Optional.empty(),
            isMobile, Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty());
    }

    @JsonIgnore
    public String object() {
        return object;
    }

    @JsonIgnore
    public String id() {
        return id;
    }

    @JsonIgnore
    public Optional<String> deviceType() {
        return deviceType;
    }

    @JsonIgnore
    public boolean isMobile() {
        return isMobile;
    }

    @JsonIgnore
    public Optional<String> browserName() {
        return browserName;
    }

    @JsonIgnore
    public Optional<String> browserVersion() {
        return browserVersion;
    }

    @JsonIgnore
    public Optional<String> ipAddress() {
        return ipAddress;
    }

    @JsonIgnore
    public Optional<String> city() {
        return city;
    }

    @JsonIgnore
    public Optional<String> country() {
        return country;
    }

    public static Builder builder() {
        return new Builder();
    }


    public SessionActivityResponse withObject(String object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
        return this;
    }

    public SessionActivityResponse withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    public SessionActivityResponse withDeviceType(String deviceType) {
        Utils.checkNotNull(deviceType, "deviceType");
        this.deviceType = Optional.ofNullable(deviceType);
        return this;
    }


    public SessionActivityResponse withDeviceType(Optional<String> deviceType) {
        Utils.checkNotNull(deviceType, "deviceType");
        this.deviceType = deviceType;
        return this;
    }

    public SessionActivityResponse withIsMobile(boolean isMobile) {
        Utils.checkNotNull(isMobile, "isMobile");
        this.isMobile = isMobile;
        return this;
    }

    public SessionActivityResponse withBrowserName(String browserName) {
        Utils.checkNotNull(browserName, "browserName");
        this.browserName = Optional.ofNullable(browserName);
        return this;
    }


    public SessionActivityResponse withBrowserName(Optional<String> browserName) {
        Utils.checkNotNull(browserName, "browserName");
        this.browserName = browserName;
        return this;
    }

    public SessionActivityResponse withBrowserVersion(String browserVersion) {
        Utils.checkNotNull(browserVersion, "browserVersion");
        this.browserVersion = Optional.ofNullable(browserVersion);
        return this;
    }


    public SessionActivityResponse withBrowserVersion(Optional<String> browserVersion) {
        Utils.checkNotNull(browserVersion, "browserVersion");
        this.browserVersion = browserVersion;
        return this;
    }

    public SessionActivityResponse withIpAddress(String ipAddress) {
        Utils.checkNotNull(ipAddress, "ipAddress");
        this.ipAddress = Optional.ofNullable(ipAddress);
        return this;
    }


    public SessionActivityResponse withIpAddress(Optional<String> ipAddress) {
        Utils.checkNotNull(ipAddress, "ipAddress");
        this.ipAddress = ipAddress;
        return this;
    }

    public SessionActivityResponse withCity(String city) {
        Utils.checkNotNull(city, "city");
        this.city = Optional.ofNullable(city);
        return this;
    }


    public SessionActivityResponse withCity(Optional<String> city) {
        Utils.checkNotNull(city, "city");
        this.city = city;
        return this;
    }

    public SessionActivityResponse withCountry(String country) {
        Utils.checkNotNull(country, "country");
        this.country = Optional.ofNullable(country);
        return this;
    }


    public SessionActivityResponse withCountry(Optional<String> country) {
        Utils.checkNotNull(country, "country");
        this.country = country;
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
        SessionActivityResponse other = (SessionActivityResponse) o;
        return 
            Utils.enhancedDeepEquals(this.object, other.object) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.deviceType, other.deviceType) &&
            Utils.enhancedDeepEquals(this.isMobile, other.isMobile) &&
            Utils.enhancedDeepEquals(this.browserName, other.browserName) &&
            Utils.enhancedDeepEquals(this.browserVersion, other.browserVersion) &&
            Utils.enhancedDeepEquals(this.ipAddress, other.ipAddress) &&
            Utils.enhancedDeepEquals(this.city, other.city) &&
            Utils.enhancedDeepEquals(this.country, other.country);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            object, id, deviceType,
            isMobile, browserName, browserVersion,
            ipAddress, city, country);
    }
    
    @Override
    public String toString() {
        return Utils.toString(SessionActivityResponse.class,
                "object", object,
                "id", id,
                "deviceType", deviceType,
                "isMobile", isMobile,
                "browserName", browserName,
                "browserVersion", browserVersion,
                "ipAddress", ipAddress,
                "city", city,
                "country", country);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String object;

        private String id;

        private Optional<String> deviceType = Optional.empty();

        private Boolean isMobile;

        private Optional<String> browserName = Optional.empty();

        private Optional<String> browserVersion = Optional.empty();

        private Optional<String> ipAddress = Optional.empty();

        private Optional<String> city = Optional.empty();

        private Optional<String> country = Optional.empty();

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
            this.id = id;
            return this;
        }


        public Builder deviceType(String deviceType) {
            Utils.checkNotNull(deviceType, "deviceType");
            this.deviceType = Optional.ofNullable(deviceType);
            return this;
        }

        public Builder deviceType(Optional<String> deviceType) {
            Utils.checkNotNull(deviceType, "deviceType");
            this.deviceType = deviceType;
            return this;
        }


        public Builder isMobile(boolean isMobile) {
            Utils.checkNotNull(isMobile, "isMobile");
            this.isMobile = isMobile;
            return this;
        }


        public Builder browserName(String browserName) {
            Utils.checkNotNull(browserName, "browserName");
            this.browserName = Optional.ofNullable(browserName);
            return this;
        }

        public Builder browserName(Optional<String> browserName) {
            Utils.checkNotNull(browserName, "browserName");
            this.browserName = browserName;
            return this;
        }


        public Builder browserVersion(String browserVersion) {
            Utils.checkNotNull(browserVersion, "browserVersion");
            this.browserVersion = Optional.ofNullable(browserVersion);
            return this;
        }

        public Builder browserVersion(Optional<String> browserVersion) {
            Utils.checkNotNull(browserVersion, "browserVersion");
            this.browserVersion = browserVersion;
            return this;
        }


        public Builder ipAddress(String ipAddress) {
            Utils.checkNotNull(ipAddress, "ipAddress");
            this.ipAddress = Optional.ofNullable(ipAddress);
            return this;
        }

        public Builder ipAddress(Optional<String> ipAddress) {
            Utils.checkNotNull(ipAddress, "ipAddress");
            this.ipAddress = ipAddress;
            return this;
        }


        public Builder city(String city) {
            Utils.checkNotNull(city, "city");
            this.city = Optional.ofNullable(city);
            return this;
        }

        public Builder city(Optional<String> city) {
            Utils.checkNotNull(city, "city");
            this.city = city;
            return this;
        }


        public Builder country(String country) {
            Utils.checkNotNull(country, "country");
            this.country = Optional.ofNullable(country);
            return this;
        }

        public Builder country(Optional<String> country) {
            Utils.checkNotNull(country, "country");
            this.country = country;
            return this;
        }

        public SessionActivityResponse build() {

            return new SessionActivityResponse(
                object, id, deviceType,
                isMobile, browserName, browserVersion,
                ipAddress, city, country);
        }

    }
}
