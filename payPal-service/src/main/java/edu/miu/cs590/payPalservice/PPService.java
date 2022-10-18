package edu.miu.cs590.payPalservice;

public interface PPService {

    public String processPayment(Long userId, double amount);
    public String confirmPayment();

}
