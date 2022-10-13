package edu.miu.cs590.stockservice.service;

import edu.miu.cs590.stockservice.domain.Stock;
import edu.miu.cs590.stockservice.dto.StockResponse;
import edu.miu.cs590.stockservice.stockRepo.StockRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service @RequiredArgsConstructor @Slf4j
public class StockServiceImpl implements StockService {

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
    public List<StockResponse> getStock(List<Long> productIds) { // comes with body map<long,long>

        return stockRepo.findByProductIdIn(productIds).stream()
                .map(stock1 ->
                        StockResponse.builder()
                                .id(stock1.getId())
                                .productId(stock1.getProductId())
                                .quantity(stock1.getQuantity())
                                .isAvailable(stock1.getQuantity() > 0)
                                .build()
                ).toList();


    }

    @Override
    public ResponseEntity<?> getQuantity(Long productId) {
        Stock st = stockRepo.findByProductId(productId);
        if (st.getQuantity() != null) {
            return new ResponseEntity<>(st.getQuantity(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("no product with this id", HttpStatus.OK);
        }

    }

    @Override
    public StockResponse getById(Long id) {
        return stockRepo.findById(id).map(stock ->
                StockResponse.builder()
                        .quantity(stock.getQuantity())
                        .id(stock.getId())
                        .isAvailable(stock.getQuantity() > 0)
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
                .isAvailable(p.getQuantity() > 0)
                .productId(p.getProductId())
                .build();
    }

//    public Boolean checkStock(List<Map<Long,Long>> products){
//         products.stream()
//                .map(product -> product.entrySet().stream()
//                        .forEach(longLongEntry -> {
//                            Stock s = stockRepo.findByProductId(longLongEntry.getKey());
//                            if (s.getQuantity() < longLongEntry.getValue()) {
//                                return true;
//                            }
//                        })
//        return true;
//
//        @Override
    public String deductProduct (List<Map<Long,Long>> products ) {
        for (Map<Long, Long> a : products) {
            for (Map.Entry<Long, Long> entry : a.entrySet()) {
                Stock s = stockRepo.findByProductId(entry.getKey());
                if (s.getQuantity() < entry.getValue()) {

                    return "action cant be completed, the quantity is minimum!";
                } else {
                    s.setQuantity(s.getQuantity() - entry.getValue());
                         stockRepo.save(s);
                }
            }
        }
    return "success";
    }


//    public String deductProduct(List<Map<Long, Long>> products) {
//
//        for (Long key : products.keySet()) {
//            Stock s = stockRepo.findByProductId(key);
//            if (s.getQuantity() < products.get(key)) {
//                return "action cant be completed, the quantity is minimum!";
//            } else {
//                s.setQuantity(s.getQuantity() - products.get(key));
//                stockRepo.save(s);
//            }
//        }
//
//        return "deducted success";
//    }
//
//    ;
//}



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
