package edu.miu.cs590.payPalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PPServiceImpl implements PPService {

    @Autowired
    private PPRepository repository;
    public String processPayment(String username, double amount) {

     Transactions transactionInfo= Transactions.builder()
             .cardHolderName(username)
             .cardNumber("123456789")
             .creditedAmount(amount)
             .CCV(123)
             .expiryDate("12/2027")
             .build();

        repository.save(transactionInfo);


        return confirmPayment();
    }
    public String confirmPayment() {

        System.out.println("Payment confirmed by Paypal");

        return "Success";
    }



}
