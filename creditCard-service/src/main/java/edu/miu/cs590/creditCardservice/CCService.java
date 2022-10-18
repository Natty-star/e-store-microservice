package edu.miu.cs590.creditCardservice;

public interface CCService {

    public String processPayment(Long username, double amount);
    public String confirmPayment();

}
