package edu.miu.cs590.shippingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Override
    public void processShipment(ShipmentRequest shipmentRequest) {

        ShipmentHistory shipmentHistory = ShipmentHistory.builder()
                .orderId(shipmentRequest.getOrderId())
                .street(shipmentRequest.getStreet())
                .city(shipmentRequest.getCity())
                .state(shipmentRequest.getState())
                .zip(shipmentRequest.getZip())
                .shipmentDate(LocalDate.now())
                .shipmentStatus("Shipped")
                .build();

        shipmentRepository.save(shipmentHistory);
    }

    @Override
    public String checkShipmentStatus(Long orderId) {
        return shipmentRepository.findByOrderId(orderId).getShipmentStatus();
    }





}
