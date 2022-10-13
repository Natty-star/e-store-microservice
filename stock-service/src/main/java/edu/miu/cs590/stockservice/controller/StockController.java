package edu.miu.cs590.stockservice.controller;
import edu.miu.cs590.stockservice.dto.StockResponse;
import edu.miu.cs590.stockservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;


    @GetMapping("/getProduct")
    public ResponseEntity<?> getQuantity(@RequestParam Long productId){
        return new ResponseEntity<>(stockService.getQuantity(productId),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam List<Long> productIds){

        List<StockResponse> stockResponses = stockService.getStock(productIds);

        Boolean allProductIsInStock = stockResponses.stream().allMatch(stockResponse -> stockResponse.getIsAvailable());
        if (allProductIsInStock){
            return new ResponseEntity<>(stockResponses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("product is not found in the stock",HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/getOne")
    public ResponseEntity<StockResponse> getById(@RequestParam Long id){
        return new ResponseEntity<>(stockService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<StockResponse> add(@RequestParam Long id, @RequestParam Long quantity){
        return new ResponseEntity<>(stockService.addProduct(id,quantity),HttpStatus.OK);
    }

    @PostMapping("/deduct")
    public ResponseEntity<String> deduct(@RequestParam Long id, @RequestParam Long quantity){
        return new ResponseEntity<>(stockService.deductProduct(id,quantity),HttpStatus.OK);
    }


    @GetMapping("/getThreshold")
    public ResponseEntity<Long> getThreshold(@RequestParam Long id){
        return new ResponseEntity<>(stockService.checkThreshold(id),HttpStatus.OK);
    }


}
