package com.clerk.backend_api.helpers.security.models;

public class TokenVerificationResponse<T> {

    private T payload;

    public TokenVerificationResponse() {
    }

    public TokenVerificationResponse(T payload) {
        this.payload = payload;
    }

    public T payload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
