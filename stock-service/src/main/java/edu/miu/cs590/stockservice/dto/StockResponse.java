package edu.miu.cs590.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class StockResponse {
    private Long id;
    private Long productId;
    private Long quantity;
    private Boolean isAvailable;

}
