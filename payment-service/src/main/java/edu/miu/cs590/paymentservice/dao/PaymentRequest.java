package edu.miu.cs590.paymentservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequest implements java.io.Serializable {

    private Long orderId;
    private String defaultPaymentMethod;
    private Long userId;
    private double price;

}
