package edu.miu.cs590.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentAPI {

    @Autowired
    private PaymentService paymentService;

    // a post function to create a payment
    @PostMapping
    public String  createPayment(@RequestBody PaymentRequest paymentRequest) {
        paymentService.createPayment(paymentRequest);
        return "payment service ok";

    }


    @GetMapping("/{id}")
    public String getPaymentById(@PathVariable int id) {

        return paymentService.getStatusByOrderId(id);
    }

    @GetMapping
    public List<Payment> getAllPayments() {

        return paymentService.getAllPayments();
    }





}
