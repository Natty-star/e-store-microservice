package edu.miu.cs590.orderservice.service;

import edu.miu.cs590.orderservice.dto.*;
import edu.miu.cs590.orderservice.model.Order;
import edu.miu.cs590.orderservice.model.OrderedProduct;
import edu.miu.cs590.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    public void createOrder(Long userId, OrderRequest orderRequest) {

        List<Map<Long,Long>> stockRequest   = orderRequest.getOrderedProducts()
                                .stream().map(orderedProduct -> new HashMap<Long,Long>(){{
                                    put(orderedProduct.getProductId(),orderedProduct.getProductId());
                }}).collect(Collectors.toList());

        String stockResponse = restTemplate.postForObject("http://STOCK-SERVICE:8085/api/stock/deduct",stockRequest, String.class);

        Order order = Order.builder()
                .userId(userId)
                .shippingId(1L)
                .orderedProducts(orderRequest.getOrderedProducts())
                .build();

        Order newOrder = orderRepository.saveAndFlush(order);


//        String url = "http://localhost:8085/api/stock/getAll";
//        UriComponentsBuilder builder = UriComponentsBuilder
//                .fromHttpUrl(url)
//                .queryParam("productIds", id);

//        String url1 = builder.toUriString();
//        String val = restTemplate.getForObject(url1, String.class);


        AppUser appUser = restTemplate.getForObject("http://ACCOUNT-SERVICE:8082/api/user/" + userId,AppUser.class);
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .userId(userId)
                .orderId(newOrder.getId())
                .defaultPaymentMethod(appUser.getDefaultPaymentMethod())
                .price(orderRequest.getPrice())
                .build();

      String paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE:8086/payment", paymentRequest, String.class);


        ShippingAddress shippingAddress =  ShippingAddress.builder()
                .orderId(newOrder.getId())
                .state(orderRequest.getShipping().getState())
//                .MR(orderRequest.getShipping().getMR())
                .street(orderRequest.getShipping().getStreet())
                .zipcode(orderRequest.getShipping().getZipCode())
                .city(orderRequest.getShipping().getCity())
                .build();
//
       String shipping = restTemplate.postForObject("http://SHIPPING-SERVICE:8087/shipment", shippingAddress, String.class);



    }

//    private void shipment()

    public List<Order> getAllOrder() {
        log.info("here we go");
        return orderRepository.findAll();
    }
}
