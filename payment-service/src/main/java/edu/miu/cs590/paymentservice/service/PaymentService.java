package edu.miu.cs590.paymentservice.service;

import edu.miu.cs590.paymentservice.dao.PaymentRequest;
import edu.miu.cs590.paymentservice.entity.Payment;

import java.util.List;

public interface PaymentService {


    String createPayment(PaymentRequest paymentRequest) ;

    String getStatusByOrderId(Long id);

    List<Payment> getAllPayments();

    List<Payment> getAllPaymentsByUserId(Long userId);

    Payment getPaymentByUserId(Long userId);



}
