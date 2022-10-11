package edu.miu.cs590.stockservice.stockRepo;

import edu.miu.cs590.stockservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Product,Long> {
}
