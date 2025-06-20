package com.clerk.backend_api.helpers.security.models;

import java.util.List;

public class SessionAuthObjectV2 implements AuthObject {
    private int exp;
    private int iat;
    private String iss;
    private String sid;
    private String sub;
    private int v;
    private String jti;
    private String role;
    private List<Integer> fva;
    private Integer nbf;
    private String email;
    private String azp;

    public SessionAuthObjectV2(int exp, int iat, String iss, String sid, String sub, int v, String jti, String role,
        List<Integer> fva, Integer nbf, String email, String azp) {
        this.exp = exp;
        this.iat = iat;
        this.iss = iss;
        this.sid = sid;
        this.sub = sub;
        this.v = v;
        this.jti = jti;
        this.role = role;
        this.fva = fva;
        this.nbf = nbf;
        this.email = email;
        this.azp = azp;
    }

    public int getExp() {
        return exp;
    }

    public int getIat() {
        return iat;
    }

    public String getIss() {
        return iss;
    }

    public String getSid() {
        return sid;
    }

    public String getSub() {
        return sub;
    }

    public int getV() {
        return v;
    }

    public String getJti() {
        return jti;
    }

    public String getRole() {
        return role;
    }

    public List<Integer> getFva() {
        return fva;
    }

    public Integer getNbf() {
        return nbf;
    }

    public String getEmail() {
        return email;
    }

    public String getAzp() {
        return azp;
    }
}

