package edu.miu.cs590.payPalservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Data
@Transactional
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String paypalUserId;
    private double creditedAmount;
    private LocalDate transactionDate;
}
