package edu.miu.cs590.shippingservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentRequest {

    private int orderId;
    private String street;
    private String city;
    private String state;
    private String zip;

}
