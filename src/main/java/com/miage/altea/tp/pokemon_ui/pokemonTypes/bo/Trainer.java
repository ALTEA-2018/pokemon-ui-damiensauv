package com.miage.altea.tp.pokemon_ui.pokemonTypes.bo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Trainer {


    @Column
    private String password;


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
