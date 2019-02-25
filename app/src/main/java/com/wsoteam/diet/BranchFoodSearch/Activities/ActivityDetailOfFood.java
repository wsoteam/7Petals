package com.wsoteam.diet.BranchFoodSearch.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wsoteam.diet.BranchFoodSearch.FoodObjects.FoodItem;
import com.wsoteam.diet.Config;
import com.wsoteam.diet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityDetailOfFood extends AppCompatActivity {
    private FoodItem foodItem;
    @BindView(R.id.tvProt) TextView tvProt;
    @BindView(R.id.tvCarbo) TextView tvCarbo;
    @BindView(R.id.tvFat) TextView tvFat;
    @BindView(R.id.tvNameOfFood) TextView tvNameOfFood;
    @BindView(R.id.tvKcal) TextView tvKcal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity_detail);
        ButterKnife.bind(this);

        foodItem = (FoodItem) getIntent().getSerializableExtra(Config.TAG_DETAIL_PRODUCT);

        tvProt.setText(foodItem.getProtein());
        tvCarbo.setText(foodItem.getCarbohydrates());
        tvFat.setText(foodItem.getFat());
        tvNameOfFood.setText(foodItem.getName() + " , group - " + foodItem.getNameOfGroup());
        tvKcal.setText(foodItem.getCalories());
    }
}
