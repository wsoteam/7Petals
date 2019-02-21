package com.wild.diet.BranchFoodSearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wild.diet.BranchFoodSearch.FoodObjects.FoodItem;
import com.wild.diet.R;

import java.util.ArrayList;

public class ActivitySearch extends AppCompatActivity {
    private RecyclerView rvListOfSearchResponse;
    private ArrayList<FoodItem> listOfGroupsFoods = new ArrayList<>();
    private ArrayList<FoodItem> tempListOfGroupsFoods = new ArrayList<>();
    private EditText edtSearchField;
    private ImageView ivCancel, ivEmptyImage;
    private TextView tvEmptyText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity_searchlist);
    }
}
