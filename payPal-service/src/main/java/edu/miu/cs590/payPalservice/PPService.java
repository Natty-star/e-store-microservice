package edu.miu.cs590.payPalservice;

public interface PPService {

    public String processPayment(String username, double amount);
    public String confirmPayment();

}
