package edu.miu.cs590.stockservice.service;

import edu.miu.cs590.stockservice.domain.Stock;
import edu.miu.cs590.stockservice.dto.StockResponse;

import java.util.List;

public interface StockService {

    //for coming product id return stockDto
    StockResponse saveStock(Stock stock);
    List<StockResponse> getStock(List<Long> productIds);
    StockResponse getById(Long id);
    StockResponse addProduct(Long id, Long quantity);
    String deductProduct(Long id, Long quantity);

    Long checkThreshold(Long id);






}
