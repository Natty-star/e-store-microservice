package edu.miu.cs590.payPalservice.Service;

public interface PPService {

    public String processPayment(String username, double amount);
    public String confirmPayment();

}
