package edu.miu.cs590.shippingservice;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private int orderId;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String shipmentStatus;
    private LocalDate shipmentDate;

}
