package edu.miu.cs590.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipping {
    private String city;
    private String zipCode;
    private String state;
    private String MR;
    private String street;
}
