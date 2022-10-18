package edu.miu.cs590.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShippingAddress {
    private Long orderId;
    private String city;
    private String state;
    private String zipcode;
    private String street;
//    private String MR;
}
