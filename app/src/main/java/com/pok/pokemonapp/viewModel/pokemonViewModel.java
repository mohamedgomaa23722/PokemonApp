package com.pok.pokemonapp.viewModel;

import static com.pok.pokemonapp.global.globalVariables.IMAGE_URL;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pok.pokemonapp.model.Pokemon;
import com.pok.pokemonapp.model.PokemonResponse;
import com.pok.pokemonapp.repository.Repo;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class pokemonViewModel extends ViewModel {

    private Repo repo;
    private LiveData<List<Pokemon>> favList = null;
    MutableLiveData<ArrayList<Pokemon>> pokemonList = new MutableLiveData<>();

    @ViewModelInject
    public pokemonViewModel(Repo repo) {
        this.repo = repo;
    }

    public MutableLiveData<ArrayList<Pokemon>> getPokemonList() {
        return pokemonList;
    }

    public void getPokemons() {
        repo.getPokemons()
                .subscribeOn(Schedulers.io())
                .map(new Function<PokemonResponse, ArrayList<Pokemon>>() {
                    @Override
                    public ArrayList<Pokemon> apply(PokemonResponse pokemonResponse) throws Throwable {
                        ArrayList<Pokemon> list = pokemonResponse.getResults();
                        for (Pokemon pokemon : list) {
                            String url = pokemon.getUrl();
                            String[] pokemonIndex = url.split("/");
                            pokemon.setUrl(IMAGE_URL + pokemonIndex[pokemonIndex.length - 1] + ".png");
                        }
                        return list;
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> pokemonList.setValue(result),
                        error -> Log.e("viewModel", error.getMessage()));

    }

    public void insertPokemon(Pokemon pokemon){
        repo.insertPokemon(pokemon);
    }

    public void deletePokemon(Pokemon pokemon){
        repo.deletePokemon(pokemon);
    }

    public void getFavPokemon(){
        favList = repo.getFavPokemon();
    }

    public LiveData<List<Pokemon>> getFavList() {
        return favList;
    }
}
