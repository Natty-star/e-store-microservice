package edu.miu.cs590.creditCardservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/credit-card")
public class CCController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private edu.miu.cs590.creditCardservice.service.CCService CCService;


    @GetMapping("/pay/{username}/{amount}")
    public ResponseEntity<String> processPayment (@PathVariable("username") String username, @PathVariable("amount") Double amount){



        String response = CCService.processPayment(username, amount);

        return ResponseEntity.ok(response);
    }





}
