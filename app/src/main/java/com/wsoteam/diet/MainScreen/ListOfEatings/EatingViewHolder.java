package com.wsoteam.diet.MainScreen.ListOfEatings;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wsoteam.diet.MainScreen.POJOEating.Eating;
import com.wsoteam.diet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EatingViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.ivProductImage) ImageView ivProductImage;
    @BindView(R.id.tvNameOfFood) TextView tvNameOfFood;

    public EatingViewHolder(LayoutInflater layoutInflater, ViewGroup parent) {
        super(layoutInflater.inflate(R.layout.ms_item_eating_list, parent, false));
        ButterKnife.bind(this, itemView);
    }

    public void bind(Eating eating, Context context){
        Glide.with(context).load(eating.getUrlOfImages()).into(ivProductImage);
        tvNameOfFood.setText(eating.getName());
    }
}
