package edu.miu.cs590.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {
    @Id
    @GeneratedValue
    private Long Id;
    private String city;
    private String state;
    private String zipcode;
    private String street;
    private String MR;
}
