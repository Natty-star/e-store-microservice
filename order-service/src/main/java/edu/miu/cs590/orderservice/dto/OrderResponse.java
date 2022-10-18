package edu.miu.cs590.orderservice.dto;

import edu.miu.cs590.orderservice.model.OrderedProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private Long userId;
    private Long shippingId;
    private List<OrderedProduct> orderedProducts;
}
