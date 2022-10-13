package edu.miu.cs590.shippingservice;


public interface ShipmentService {



     void processShipment(ShipmentRequest shipmentRequest);
     String checkShipmentStatus(int  orderId);



}
