package edu.miu.cs590.cloudgateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationStatus {
    private Boolean isAuthenticated;
    private String message;
}
