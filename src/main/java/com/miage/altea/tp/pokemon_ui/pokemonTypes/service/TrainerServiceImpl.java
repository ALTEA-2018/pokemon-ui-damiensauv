package com.miage.altea.tp.pokemon_ui.pokemonTypes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

public class TrainerServiceImpl {

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        //this.restTemplate = restTemplate;
    }

}
