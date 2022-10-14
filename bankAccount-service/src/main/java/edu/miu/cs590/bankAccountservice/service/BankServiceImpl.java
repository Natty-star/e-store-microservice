package edu.miu.cs590.bankAccountservice.service;

import edu.miu.cs590.bankAccountservice.entity.Transactions;
import edu.miu.cs590.bankAccountservice.repository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository repository;
    public String processPayment(String username, double amount) {

     Transactions transactionInfo= Transactions.builder()
                     .AccountNumber(username)
                     .AccountType("Checking")
                        .creditedAmount(amount)
                        .transactionDate(java.time.LocalDate.now())
                        .build();

        repository.save(transactionInfo);

       log.info("Payment confirmed by Bank System for user: "+username+" with amount: "+amount);

        return confirmPayment();
    }
    public String confirmPayment() {

        System.out.println("Payment confirmed by Bank System");

        return "Accepted";
    }



}
