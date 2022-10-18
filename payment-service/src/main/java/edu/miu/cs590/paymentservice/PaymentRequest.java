package edu.miu.cs590.paymentservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequest implements java.io.Serializable {
    private Long orderId;
    private Long userId;
    private double price;
    private String defaultPaymentMethod;

}
