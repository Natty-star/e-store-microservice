package edu.miu.cs590.cloudgateway.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    private String secret = "natty-star";
    private long validity;
    private boolean authDisabled;

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setValidity(long validity) {
        this.validity = validity;
    }

    public String getSecret() {
        return secret;
    }

    public long getValidity() {
        return validity;
    }

    public boolean isAuthDisabled() {
        return authDisabled;
    }

    public void setAuthDisabled(boolean authDisabled) {
        this.authDisabled = authDisabled;
    }
}
