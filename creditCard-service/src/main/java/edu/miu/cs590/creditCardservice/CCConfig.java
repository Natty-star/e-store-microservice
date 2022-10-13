package edu.miu.cs590.creditCardservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CCConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
