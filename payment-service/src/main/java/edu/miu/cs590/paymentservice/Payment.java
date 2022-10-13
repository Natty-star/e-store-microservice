package edu.miu.cs590.paymentservice;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Builder
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "payment_type")
    private String preferredPaymentMethod;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "username")
    private String username;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "payment_amount")
    private Double paymentAmount;

    @Column(name = "payment_status")
    private String paymentStatus;




}
