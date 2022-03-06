package com.pok.pokemonapp.repository;

import androidx.lifecycle.Observer;

import com.pok.pokemonapp.model.PokemonResponse;
import com.pok.pokemonapp.network.PokemonApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class Repo {

    private PokemonApiService pokemonApiService;

    @Inject
    public Repo(PokemonApiService pokemonApiService) {
        this.pokemonApiService = pokemonApiService;
    }

    public Observable<PokemonResponse> getPokemons(){
        return pokemonApiService.getPokemon();
    }
}
