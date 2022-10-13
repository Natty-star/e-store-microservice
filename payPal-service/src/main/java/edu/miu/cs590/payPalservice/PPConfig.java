package edu.miu.cs590.payPalservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PPConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
