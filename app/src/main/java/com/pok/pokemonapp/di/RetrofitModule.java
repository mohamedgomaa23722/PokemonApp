package com.pok.pokemonapp.di;

import com.pok.pokemonapp.network.PokemonApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.pok.pokemonapp.global.globalVariables.BASE_URL;

@Module
@InstallIn(ApplicationComponent.class)
public class RetrofitModule {

    @Singleton
    @Provides
    public static PokemonApiService providePokemonApiService() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(PokemonApiService.class);
    }
}
