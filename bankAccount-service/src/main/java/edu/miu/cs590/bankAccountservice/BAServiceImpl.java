package edu.miu.cs590.bankAccountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BAServiceImpl implements BAService {

    @Autowired
    private BARepository repository;
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

        System.out.println("Payment confirmed by Bank System");

        return "Accepted";
    }



}
