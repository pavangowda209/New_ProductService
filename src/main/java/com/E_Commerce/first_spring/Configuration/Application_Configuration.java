package com.E_Commerce.first_spring.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class Application_Configuration {
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }

}
