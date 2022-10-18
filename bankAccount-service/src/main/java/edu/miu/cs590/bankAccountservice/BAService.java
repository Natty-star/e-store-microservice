package edu.miu.cs590.bankAccountservice;

public interface BAService {

    public String processPayment(Long username, double amount);
    public String confirmPayment();

}
