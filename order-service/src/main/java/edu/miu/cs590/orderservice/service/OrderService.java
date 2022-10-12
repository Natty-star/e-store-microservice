package edu.miu.cs590.orderservice.service;

import edu.miu.cs590.orderservice.dto.*;
import edu.miu.cs590.orderservice.model.OrderedProduct;
import edu.miu.cs590.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    public OrderResponse createOrder(Long userId, OrderRequest orderRequest) {
        StockRequest stockRequest = new StockRequest();
        stockRequest.builder()
                        .productId(orderRequest.getOrderedProducts()
                                .stream()
                                .map(OrderedProduct::getProductId)
                                .toList())
                .build();
        String url = "http://localhost:8082/api/stock/getAll";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("productId", stockRequest);
         restTemplate.getForObject(url,R )



        AppUser appUser = restTemplate.getForObject("http://localhost:8082/api/user" + userId,AppUser.class);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.builder()
                .userId(appUser.getId())
                .defaultPaymentMethod(appUser.getDefaultPaymentMethod())
                .price(orderRequest.getPrice())
                .build();
        //HttpEntity<PaymentRequest> request = new HttpEntity<>(paymentRequest);
        PaymentResponse paymentResponse = restTemplate.postForObject("http://localhost:8082/api/payment", paymentRequest, PaymentResponse.class);

        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.builder()
                .state(orderRequest.getShipping().getState())
                .MR(orderRequest.getShipping().getMR())
                .street(orderRequest.getShipping().getStreet())
                .zipcode(orderRequest.getShipping().getZipCode())
                .city(orderRequest.getShipping().getCity())
                .build();

        restTemplate.postForObject("http://localhost:8082/api/shipping", shippingAddress, ShippingResponse.class);


    }
}
