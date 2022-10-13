package edu.miu.cs590.paymentservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {


    Payment getPaymentsByOrderId(int orderId);

}


