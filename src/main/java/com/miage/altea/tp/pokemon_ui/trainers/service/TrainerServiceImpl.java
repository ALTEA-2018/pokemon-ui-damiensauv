package com.miage.altea.tp.pokemon_ui.trainers.service;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private RestTemplate restTemplate;
    private String url;
    private PokemonTypeService pokemonTypeService;

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainers.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.url = pokemonServiceUrl;
    }

    @Override
    public List<Trainer> listTrainers() {

        Trainer[] objects = this.restTemplate.getForObject(this.url + "/trainers/", Trainer[].class);
        List<PokemonType> pokemonTypes = this.pokemonTypeService.listPokemonsTypes();

        if (objects != null) {
            Arrays.stream(objects).forEach(trainer -> this.searchPokemonType(trainer, pokemonTypes));
            return Arrays.asList(objects);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public Trainer getTrainer(String name) {
        Trainer trainer = this.restTemplate.getForObject(this.url + "/trainers/" + name, Trainer.class);
        List<PokemonType> pokemonTypes = this.pokemonTypeService.listPokemonsTypes();

        if (trainer != null) {
            this.searchPokemonType(trainer, pokemonTypes);
            return trainer;
        } else {
            throw new NullPointerException();
        }
    }

    @Autowired
    public void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    private void searchPokemonType(Trainer trainer, List<PokemonType> pokemonTypes) {
        trainer.setTeams(new ArrayList<>());
        trainer.getTeam().forEach(team -> {
            PokemonType pokemon = pokemonTypes.stream()
                    .filter(type -> team.getPokemonType() == type.getId())
                    .findFirst().orElseGet(null);

            if (pokemon != null) {
                pokemon.setLevel(team.getLevel());
                trainer.addPokemonTypeToTeam(pokemon);
            }
        });
    }
}
