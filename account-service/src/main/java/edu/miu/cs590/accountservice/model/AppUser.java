package edu.miu.cs590.accountservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isActive;
    @ManyToMany
    private List<Role> roles;
    @OneToOne
    private ShippingAddress shippingAddress;
    private String defaultPaymentMethod;


}
