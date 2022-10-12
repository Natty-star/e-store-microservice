package edu.miu.cs590.productservice.service;

import edu.miu.cs590.productservice.domain.Product;
import edu.miu.cs590.productservice.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDto> getAll();

    ProductDto getId(Long id);

    ProductDto save(Product product);

    ProductDto edit(Product product);




}
