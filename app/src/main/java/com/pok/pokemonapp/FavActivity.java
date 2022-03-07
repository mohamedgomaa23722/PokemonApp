package com.pok.pokemonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pok.pokemonapp.Adapters.PokemonAdapter;
import com.pok.pokemonapp.model.Pokemon;
import com.pok.pokemonapp.viewModel.pokemonViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FavActivity extends AppCompatActivity implements View.OnClickListener {
    private pokemonViewModel viewModel;
    private RecyclerView recyclerView;
    private PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        recyclerView = findViewById(R.id.favRecyclerView);
        adapter = new PokemonAdapter(this);
        recyclerView.setAdapter(adapter);
        setupSwipe();
        findViewById(R.id.home_btn).setOnClickListener(this);

        viewModel = new ViewModelProvider(this).get(pokemonViewModel.class);
        viewModel.getFavPokemon();

        viewModel.getFavList().observe(this, pokemons -> {
            ArrayList<Pokemon> list = new ArrayList<>(pokemons);
            adapter.setList(list);
        });

    }

    private void setupSwipe() {
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPokemonPosition = viewHolder.getAdapterPosition();
                viewModel.deletePokemon(adapter.getPokemonAt(swipedPokemonPosition));
                adapter.notifyDataSetChanged();
                Toast.makeText(FavActivity.this, "Pokemon Deleted from Fav", Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}