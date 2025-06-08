package com.clerk.backend_api.helpers.security.models;

public enum TokenPrefix {
    API_KEY_PREFIX("ak_"),
    MACHINE_TOKEN_PREFIX("mt_"),
    OAUTH_TOKEN_PREFIX("oat_");

    private final String prefix;

    TokenPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

}
