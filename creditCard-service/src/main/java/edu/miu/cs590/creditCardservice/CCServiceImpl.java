package edu.miu.cs590.creditCardservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCServiceImpl implements CCService {

    @Autowired
    private CCRepository repository;
    public String processPayment(Long username, double amount) {

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

        System.out.println("Payment confirmed by credit card service");

        return "Accepted";
    }



}
