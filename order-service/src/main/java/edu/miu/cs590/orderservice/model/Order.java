package edu.miu.cs590.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "order_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long shippingId;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderedProduct> orderedProducts;

//    public Order(Long userId, Long shippingId, List<OrderedProduct> orderedProducts) {
//        this.userId = userId;
//        this.shippingId = shippingId;
//        this.orderedProducts = orderedProducts;
//    }

//    public void addOrderProduct(OrderedProduct orderedProduct){
//        this.orderedProducts.add(orderedProduct);
//    }
}
