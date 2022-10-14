package edu.miu.cs590.paymentservice.controller;

import edu.miu.cs590.paymentservice.dao.PaymentRequest;
import edu.miu.cs590.paymentservice.service.PaymentService;
import edu.miu.cs590.paymentservice.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // a post function to create a payment
    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody PaymentRequest paymentRequest) {

        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
    }


    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {


        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Payment>> getAllPaymentsByUserId(@PathVariable Long id) {

        return ResponseEntity.ok(paymentService.getAllPaymentsByUserId(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Payment> getPaymentByUserId(@PathVariable Long id) {


        return ResponseEntity.ok(paymentService.getPaymentByUserId(id));
    }



}
