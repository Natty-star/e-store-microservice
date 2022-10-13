package edu.miu.cs590.paymentservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequest implements java.io.Serializable {

    private int orderId;
    private String preferredPaymentMethod;
    private String username;
    private double paymentAmount;

}
