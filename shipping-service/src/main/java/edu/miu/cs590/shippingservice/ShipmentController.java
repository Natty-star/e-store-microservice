package edu.miu.cs590.shippingservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {


    @Autowired
    private ShipmentService shipmentService;

    @PostMapping
    public void shipOrder ( @RequestBody ShipmentRequest shipmentRequest){

        shipmentService.processShipment(shipmentRequest);

    }

    @GetMapping("/{orderId}")
    public String checkShipmentStatus(@PathVariable int orderId){
        return shipmentService.checkShipmentStatus(orderId);
    }


}
