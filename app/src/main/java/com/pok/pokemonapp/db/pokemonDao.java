package com.pok.pokemonapp.db;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.pok.pokemonapp.model.Pokemon;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface pokemonDao {

    @Insert
    public void InsertPokemon(Pokemon pokemon);

    @Delete
    public void DeletePokemon(Pokemon pokemon);

    @Query("SELECT * From pokemonTable")
    LiveData<List<Pokemon>> getFavPokemons();

}
