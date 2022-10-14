package edu.miu.cs590.creditCardservice.service;

public interface CCService {

    public String processPayment(String username, double amount);
    public String confirmPayment();

}
