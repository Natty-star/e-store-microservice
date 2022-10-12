package edu.miu.cs590.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isActive;
    private ShippingAddress shippingAddress;
    private String defaultPaymentMethod;
}
