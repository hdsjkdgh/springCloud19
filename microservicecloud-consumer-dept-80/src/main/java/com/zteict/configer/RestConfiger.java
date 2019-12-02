package com.zteict.configer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiger {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
