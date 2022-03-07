package com.pok.pokemonapp.di;

import android.app.Application;

import androidx.room.Room;

import com.pok.pokemonapp.db.PokemonDB;
import com.pok.pokemonapp.db.pokemonDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static PokemonDB provideDB(Application application){
        return Room.databaseBuilder(application, PokemonDB.class, "Fav_DB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static pokemonDao provideDao(PokemonDB pokemonDB){
        return pokemonDB.pokemonDao();
    }
}
