package edu.miu.cs590.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long shippingId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderedProduct> orderedProducts;


}
