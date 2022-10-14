package edu.miu.cs590.bankAccountservice.repository;

import edu.miu.cs590.bankAccountservice.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Transactions, Integer> {

    public Transactions findByCardNumber(String cardNumber);

}
