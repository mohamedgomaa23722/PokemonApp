package com.pok.pokemonapp.repository;

import androidx.lifecycle.LiveData;

import com.pok.pokemonapp.db.pokemonDao;
import com.pok.pokemonapp.model.Pokemon;
import com.pok.pokemonapp.model.PokemonResponse;
import com.pok.pokemonapp.network.PokemonApiService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class Repo {

    private PokemonApiService pokemonApiService;
    private com.pok.pokemonapp.db.pokemonDao pokemonDao;

    @Inject
    public Repo(PokemonApiService pokemonApiService, com.pok.pokemonapp.db.pokemonDao pokemonDao) {
        this.pokemonApiService = pokemonApiService;
        this.pokemonDao = pokemonDao;
    }

    public Observable<PokemonResponse> getPokemons() {
        return pokemonApiService.getPokemon();
    }

    public void insertPokemon(Pokemon pokemon) {
        pokemonDao.InsertPokemon(pokemon);
    }

    public void deletePokemon(Pokemon pokemon) {
        pokemonDao.DeletePokemon(pokemon);
    }

    public LiveData<List<Pokemon>> getFavPokemon() {
        return pokemonDao.getFavPokemons();
    }

}
