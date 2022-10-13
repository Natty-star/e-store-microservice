package edu.miu.cs590.shippingservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<ShipmentHistory, Integer> {

    ShipmentHistory findByOrderId(int orderId);
    List<ShipmentHistory> findAllByShipmentStatus(String shipmentStatus);
    List<ShipmentHistory> findAllByCity(String city);
    List<ShipmentHistory> findAllByState(String state);
    List<ShipmentHistory> findAllByZip(String zip);
    List<ShipmentHistory> findAllByShipmentDate(LocalDate street);

}
