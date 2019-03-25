package com.miage.altea.tp.pokemon_ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @Value("${spring.security.user.username}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;


    @Bean
    RestTemplate trainerApiRestTemplate() {

        RestTemplate restTemplate = new RestTemplate();

        /*
        final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new BasicAuthInterceptor(username, password));
        restTemplate.setInterceptors(interceptors);
        */

        return restTemplate;
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
