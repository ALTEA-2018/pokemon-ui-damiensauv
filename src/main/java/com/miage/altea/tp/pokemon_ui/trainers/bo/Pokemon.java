package com.miage.altea.tp.pokemon_ui.trainers.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pokemon {

    private int id;
    private int pokemonType;
    private int level;

    public Pokemon() {
    }

    public Pokemon(int pokemonType, int level) {
        this.pokemonType = pokemonType;
        this.level = level;
    }

}