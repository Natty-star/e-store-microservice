package edu.miu.cs590.bankAccountservice.service;

public interface BankService {

    public String processPayment(String username, double amount);
    public String confirmPayment();

}
