package edu.miu.cs590.orderservice.dto;

import edu.miu.cs590.orderservice.model.OrderedProduct;
import edu.miu.cs590.orderservice.model.Shipping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private Long userId;
    private double price;
    private Shipping shipping;
    private List<OrderedProduct> orderedProducts;

}
