package edu.miu.cs590.stockservice.stockRepo;

import edu.miu.cs590.stockservice.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock,Long> {
    List<Stock> findByProductIdIn(List<Long> productIds);

    Stock findByProductId(Long productId);
}
