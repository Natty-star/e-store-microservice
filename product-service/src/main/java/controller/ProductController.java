package controller;

import domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    // List<Product> getAll();
    //    Product getId(Long id);
    //    Product save(Product product);
    //    Product edit(Product product);

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/one")
    public ResponseEntity<Product> getOne(@RequestParam Long id){
        return new ResponseEntity<>(productService.getId(id),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.save(product),HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<Product> edit(@RequestBody Product product){
        return new ResponseEntity<>(productService.edit(product),HttpStatus.OK);
    }


}
