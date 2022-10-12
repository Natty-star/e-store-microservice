package edu.miu.cs590.stockservice.service;

import edu.miu.cs590.stockservice.domain.Stock;
import edu.miu.cs590.stockservice.dto.StockResponse;
import edu.miu.cs590.stockservice.stockRepo.StockRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service @RequiredArgsConstructor @Slf4j
public class StockServiceImpl implements StockService{

    private final StockRepo stockRepo;

    @Override
    public StockResponse saveStock(Stock stock) {
        Stock s = stockRepo.save(stock);
        return StockResponse.builder()
                .productId(s.getProductId())
                .quantity(s.getQuantity())

                .build();

    }



    @Override
    public List<StockResponse> getStock(List<Long> productIds){

        return stockRepo.findByProductIdIn(productIds).stream()
                .map(stock1 ->
                        StockResponse.builder()
                                .productId(stock1.getProductId())
                                .quantity(stock1.getQuantity())
                                .isAvailable(stock1.getQuantity() > 0)
                                .build()
                ).toList();




    }

    @Override
    public StockResponse getById(Long id) {
        return stockRepo.findById(id).map(stock ->
                StockResponse.builder()
                    .quantity(stock.getQuantity())
                        .id(stock.getId())
                        .isAvailable(stock.getIsAvailable())
                        .productId(stock.getProductId())
                    .build()
        ).get();
    }

    @Override
    public StockResponse addProduct(Long id, Long quantity) {
        Stock p = stockRepo.findById(id).get();
        p.setQuantity(quantity + p.getQuantity());
        return StockResponse.builder()
                .quantity(p.getQuantity())
                .isAvailable(p.getIsAvailable())
                .productId(p.getProductId())
                .build();
    }

    @Override
    public String deductProduct(Long id, Long quantity) {
        Stock p = stockRepo.findById(id).get();
        if(p.getQuantity() >= quantity){
            p.setQuantity(quantity - p.getQuantity());
            return "stock deducted";
        } else {
            return "action cant be completed, the quantity is minimum!";
        }

    }

    @Override
    public Long checkThreshold(Long id) {
         Stock stock = stockRepo.findById(id).get();
       if(stock.getQuantity() < stock.getThresholdQuantity() ){
           log.info("below threshold");
           return stock.getQuantity();
       } else  {
           log.info("above threshold");
           return stock.getQuantity();
       }
    }

}
