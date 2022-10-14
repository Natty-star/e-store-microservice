package edu.miu.cs590.payPalservice.repository;

import edu.miu.cs590.payPalservice.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Transactions, Integer> {

    public Transactions findByCardNumber(String cardNumber);

}
