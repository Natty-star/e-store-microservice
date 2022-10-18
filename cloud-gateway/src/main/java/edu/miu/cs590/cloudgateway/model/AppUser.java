package edu.miu.cs590.cloudgateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    private Long Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private boolean isActive;
    private List<Role> roles = new ArrayList<>();
    private ShippingAddress shippingAddress;
    private String defaultPaymentMethod;
}
