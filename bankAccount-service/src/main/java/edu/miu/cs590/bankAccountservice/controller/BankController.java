package edu.miu.cs590.bankAccountservice.controller;

import edu.miu.cs590.bankAccountservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bank-transfer")
public class BankController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BankService Service;


    @GetMapping("/pay/{username}/{amount}")
    public ResponseEntity<String> processPayment (@PathVariable("username") String username, @PathVariable("amount") Double amount){

        String response = Service.processPayment(username, amount);

        return ResponseEntity.ok(response);
    }





}
