package edu.miu.cs590.orderservice.controller;

import edu.miu.cs590.orderservice.dto.OrderRequest;
import edu.miu.cs590.orderservice.dto.OrderResponse;
import edu.miu.cs590.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest, @PathVariable Long userId){
        orderService.createOrder(userId,orderRequest);
    }
}
