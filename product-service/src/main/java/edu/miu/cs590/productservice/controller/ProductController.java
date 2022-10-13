package edu.miu.cs590.productservice.controller;

import edu.miu.cs590.productservice.domain.Product;
import edu.miu.cs590.productservice.dto.ProductDto;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.miu.cs590.productservice.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getQuantity")
    public ResponseEntity<Long> getQuantity(@RequestParam Long productId){
        return productService.getQuantity(productId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/one")
    public ResponseEntity<ProductDto> getOne(@RequestParam Long id){
        return new ResponseEntity<>(productService.getId(id),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDto> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<ProductDto> edit(@RequestBody Product product){
        return new ResponseEntity<>(productService.edit(product),HttpStatus.OK);
    }


}
