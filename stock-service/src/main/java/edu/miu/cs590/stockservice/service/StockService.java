package edu.miu.cs590.stockservice.service;

import edu.miu.cs590.stockservice.domain.Stock;
import edu.miu.cs590.stockservice.dto.StockResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface StockService {

    //for coming product id return stockDto
    StockResponse saveStock(Stock stock);
    List<StockResponse> getStock(List<Long> productIds);

    ResponseEntity<?> getQuantity (Long productId);
    StockResponse getById(Long id);
    StockResponse addProduct(Long id, Long quantity);
    String deductProduct(List<Map<Long,Long>> products);

    Long checkThreshold(Long id);






}
