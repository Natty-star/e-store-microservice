package edu.miu.cs590.bankAccountservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BARepository extends JpaRepository<Transactions, Integer> {

    public Transactions findByCardNumber(String cardNumber);

}
