package com.wsoteam.diet.BranchFoodSearch.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.wsoteam.diet.BranchFoodSearch.FoodObjects.FoodItem;
import com.wsoteam.diet.MainScreen.MainActivity;
import com.wsoteam.diet.MainScreen.POJOEating.Breakfast;
import com.wsoteam.diet.MainScreen.POJOEating.Lunch;
import com.wsoteam.diet.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityDetailOfFood extends AppCompatActivity {
    private FoodItem foodItem;
    @BindView(R.id.tvProt) TextView tvProt;
    @BindView(R.id.tvCarbo) TextView tvCarbo;
    @BindView(R.id.tvFat) TextView tvFat;
    @BindView(R.id.tvNameOfFood) TextView tvNameOfFood;
    @BindView(R.id.tvKcal) TextView tvKcal;
    public static final String TAG_DETAIL_PRODUCT = "TAG_DETAIL_PRODUCT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity_detail);
        ButterKnife.bind(this);

        foodItem = (FoodItem) getIntent().getSerializableExtra(TAG_DETAIL_PRODUCT);

        tvProt.setText(foodItem.getProtein());
        tvCarbo.setText(foodItem.getCarbohydrates());
        tvFat.setText(foodItem.getFat());
        tvNameOfFood.setText(foodItem.getName() + " , group - " + foodItem.getNameOfGroup());
        tvKcal.setText(foodItem.getCalories());
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        saveChoisedEating(getIntent().getStringExtra(ActivitySearch.INTENT_CHOISED_EATING));
    }

    private void saveChoisedEating(String tagOfChoisedFood) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        switch (tagOfChoisedFood) {
            case MainActivity.BREAKFAST_TAG:
                new Breakfast(foodItem.getName(), foodItem.getUrlOfImages(), 100, 100,
                        100, 100, 100, day, month, year).save();
                break;
            case MainActivity.LUNCH_TAG:
                new Lunch(foodItem.getName(), foodItem.getUrlOfImages(), 100, 100,
                        100, 100, 100, day, month, year).save();
                break;
            case MainActivity.DINNER_TAG:
                new Lunch(foodItem.getName(), foodItem.getUrlOfImages(), 100, 100,
                        100, 100, 100, day, month, year).save();
                break;
            case MainActivity.SNACK_TAG:
                new Lunch(foodItem.getName(), foodItem.getUrlOfImages(), 100, 100,
                        100, 100, 100, day, month, year).save();
                break;
        }
    }
}
