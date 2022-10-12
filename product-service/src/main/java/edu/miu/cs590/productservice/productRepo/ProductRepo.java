package edu.miu.cs590.productservice.productRepo;

import edu.miu.cs590.productservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
