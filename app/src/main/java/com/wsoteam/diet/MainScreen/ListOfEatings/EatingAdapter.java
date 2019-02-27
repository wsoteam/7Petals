package com.wsoteam.diet.MainScreen.ListOfEatings;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wsoteam.diet.MainScreen.POJOEating.Eating;

import java.util.List;

public class EatingAdapter extends RecyclerView.Adapter<EatingViewHolder> {
    List<Eating> listOfEating;
    Context context;

    public EatingAdapter(List<Eating> listOfEating, Context context) {
        this.listOfEating = listOfEating;
        this.context = context;
    }

    @NonNull
    @Override
    public EatingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return new EatingViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull EatingViewHolder holder, int position) {
        holder.bind(listOfEating.get(position), context);
    }

    @Override
    public int getItemCount() {
        return listOfEating.size();
    }
}
