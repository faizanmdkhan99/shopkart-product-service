package com.example.amazonproductservice.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
/* Sometimes the rest template object will not be available in the application context as it might not be created on its own
So we will use the config files to create one
*/
public class RestTemplateConfig {

    // When we specify it as a bean, then we are telling the function should be called and whatever oject come sout should be added to application context
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}
