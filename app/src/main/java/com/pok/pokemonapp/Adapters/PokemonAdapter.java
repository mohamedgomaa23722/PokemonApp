package com.pok.pokemonapp.Adapters;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.bumptech.glide.Glide;
import com.pok.pokemonapp.R;
import com.pok.pokemonapp.model.Pokemon;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    private ArrayList<Pokemon> mList = new ArrayList<>();
    private Context mContext;
    private static final String TAG = "PokemonAdapter";
    public PokemonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        holder.pokemonName.setText(mList.get(position).getName());
        Log.d(TAG, "onBindViewHolder: "+mList.get(position).getUrl());
        Glide.with(mContext).load(mList.get(position).getUrl())
                .into(holder.pokemonImage);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(ArrayList<Pokemon> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public Pokemon getPokemonAt(int position){
        return mList.get(position);
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        private ImageView pokemonImage;
        private TextView pokemonName;
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonImage = itemView.findViewById(R.id.pokemonImageView);
            pokemonName = itemView.findViewById(R.id.pokemon_name_textView);
        }
    }
}

