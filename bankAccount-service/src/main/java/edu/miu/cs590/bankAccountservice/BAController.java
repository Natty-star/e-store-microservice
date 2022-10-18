package edu.miu.cs590.bankAccountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bank-transfer")
public class BAController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BAService Service;


    @GetMapping("/pay/{username}/{amount}")
    public String processPayment ( @PathVariable("username") Long username, @PathVariable("amount") Double amount){



        String response = Service.processPayment(username, amount);

        return response;
    }





}
