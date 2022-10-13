package edu.miu.cs590.payPalservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PPRepository extends JpaRepository<Transactions, Integer> {

    public Transactions findByCardNumber(String cardNumber);

}
