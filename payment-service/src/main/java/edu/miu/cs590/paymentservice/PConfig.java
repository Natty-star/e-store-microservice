package edu.miu.cs590.paymentservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
