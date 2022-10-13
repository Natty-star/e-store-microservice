package edu.miu.cs590.bankAccountservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequest implements java.io.Serializable {

    private int orderId;
    private String payment_type;
    private String username;
    private double payment_amount;

}
