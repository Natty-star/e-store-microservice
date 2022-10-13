package edu.miu.cs590.payPalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/paypal")
public class PPController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PPService Service;


    @GetMapping("/pay/{username}/{amount}")
    public String processPayment ( @PathVariable("username") String username, @PathVariable("amount") Double amount){


        String response = Service.processPayment(username, amount);

        return response;
    }





}
