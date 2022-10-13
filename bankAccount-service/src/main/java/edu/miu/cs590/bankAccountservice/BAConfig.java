package edu.miu.cs590.bankAccountservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BAConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
