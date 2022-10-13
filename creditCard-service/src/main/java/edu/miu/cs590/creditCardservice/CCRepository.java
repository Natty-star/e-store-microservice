package edu.miu.cs590.creditCardservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CCRepository extends JpaRepository<Transactions, Integer> {

    public Transactions findByCardNumber(String cardNumber);

}
