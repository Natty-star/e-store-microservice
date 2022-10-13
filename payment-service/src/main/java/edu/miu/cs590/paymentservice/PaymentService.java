package edu.miu.cs590.paymentservice;

import java.util.List;

public interface PaymentService {


    void createPayment(PaymentRequest paymentRequest) ;

    String getStatusByOrderId(int id);

    List<Payment> getAllPayments();




}
