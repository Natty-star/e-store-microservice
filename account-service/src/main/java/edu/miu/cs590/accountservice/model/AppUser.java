package edu.miu.cs590.accountservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue
    private Long Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private boolean isActive;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> roles = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;
    private String defaultPaymentMethod;


}
