package com.andreamaccan.backportfolio.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class Jwt {
    private String token;
    private String bearer = "Bearer";
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    public Jwt() {
    }

    public Jwt(String token, String email, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.email = email;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
}