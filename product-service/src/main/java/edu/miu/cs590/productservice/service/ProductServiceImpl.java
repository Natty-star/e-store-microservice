package edu.miu.cs590.productservice.service;

import edu.miu.cs590.productservice.domain.Product;
import edu.miu.cs590.productservice.dto.ProductDto;
import edu.miu.cs590.productservice.productRepo.ProductRepo;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    @Override
    public List<ProductDto> getAll() {
        return productRepo.findAll().stream().map(product ->
            ProductDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .vender(product.getVender())
                    .build()
        ).toList();

    }

    @Override
    public ProductDto getId(Long id) {
        return productRepo.findById(id).map(product ->
                ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .vender(product.getVender())
                .build()
        ).get();
    }

    @Override
    public ProductDto save(Product product) {
        Product p = productRepo.save(product);
        return ProductDto.builder()
                .name(p.getName())
                .id(p.getId())
                .price(product.getPrice())
                .vender(product.getVender())
                .build();

    }

    @Override
    public ProductDto edit(Product product) {
        Product p = productRepo.save(product);
        return ProductDto.builder()
                .name(p.getName())
                .id(p.getId())
                .price(product.getPrice())
                .vender(product.getVender())
                .build();
    }


}
