package edu.miu.cs590.productservice.service;

import edu.miu.cs590.productservice.domain.Product;
import edu.miu.cs590.productservice.dto.ProductDto;
import edu.miu.cs590.productservice.productRepo.ProductRepo;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;
    private final WebClient.Builder webClientBuilder;

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

    @Override
    public ResponseEntity<Long> getQuantity(Long productId) {
        Long ans = webClientBuilder.build().get()
                .uri("http://STOCK-SERVICE/api/stock/getProduct",
                uriBuilder -> uriBuilder.queryParam("productId",productId).build())
                .retrieve()
                .bodyToMono(Long.class)
                .block();

        return new ResponseEntity<>(ans, HttpStatus.OK);

    }


}
