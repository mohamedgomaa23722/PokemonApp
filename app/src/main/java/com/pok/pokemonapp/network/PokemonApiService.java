package com.pok.pokemonapp.network;

import androidx.lifecycle.Observer;

import com.pok.pokemonapp.model.PokemonResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

import static com.pok.pokemonapp.global.globalVariables.GET_POKEMON;

public interface PokemonApiService {

    @GET(GET_POKEMON)
    Observable<PokemonResponse> getPokemon();
}
