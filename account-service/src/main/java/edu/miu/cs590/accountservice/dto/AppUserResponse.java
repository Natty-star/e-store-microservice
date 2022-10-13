package edu.miu.cs590.accountservice.dto;

import edu.miu.cs590.accountservice.model.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserResponse {
    private Long Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private boolean isActive;
    private ShippingAddress shippingAddress;
    private String defaultPaymentMethod;
}
