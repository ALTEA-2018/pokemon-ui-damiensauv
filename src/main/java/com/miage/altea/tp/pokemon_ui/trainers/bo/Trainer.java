package com.miage.altea.tp.pokemon_ui.trainers.bo;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Trainer {

    private String name;
    private String password;
    private List<Pokemon> team;
    private List<PokemonType> teams;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

}