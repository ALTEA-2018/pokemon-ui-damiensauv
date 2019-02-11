package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PokemonTypeController {

    private PokemonTypeService pokemonTypeService;

    @GetMapping(value = "/pokedex")
    public ModelAndView pokedex() {

        List<PokemonType> pokemonTypes = this.pokemonTypeService.listPokemonsTypes();

        var modelAndview = new ModelAndView("pokedex");
        modelAndview.addObject("pokemonTypes", pokemonTypes);
        return modelAndview;
    }

    public void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }
}
