package edu.miu.cs590.payPalservice.Service;

import edu.miu.cs590.payPalservice.repository.PaypalRepository;
import edu.miu.cs590.payPalservice.entity.Transactions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class PPServiceImpl implements PPService {

    @Autowired
    private PaypalRepository paypalRepository;
    public String processPayment(String username, double amount) {

     Transactions transactionInfo= Transactions.builder()
             .paypalUserId(username)
             .creditedAmount(amount)
             .transactionDate(LocalDate.now())
             .build();

        paypalRepository.save(transactionInfo);

log.info("Payment is processed successfully by Paypal for the user: "+username+" with the amount: "+amount);

        return confirmPayment();
    }
    public String confirmPayment() {

        System.out.println("Payment confirmed by Paypal");

        return "Success";
    }



}
