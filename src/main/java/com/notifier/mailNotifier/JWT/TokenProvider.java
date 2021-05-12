package com.notifier.mailNotifier.JWT;

public class TokenProvider {
    private final String jwt;

    public TokenProvider(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
