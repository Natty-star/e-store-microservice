package edu.miu.cs590.paymentservice.repository;

import edu.miu.cs590.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {


    Payment getPaymentsByOrderId(Long orderId);

    List<Payment> findAllByUserId(Long userId);

    Payment findByUserId(Long userId);
}


