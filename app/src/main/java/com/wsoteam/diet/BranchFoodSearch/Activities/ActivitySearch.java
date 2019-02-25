package com.wsoteam.diet.BranchFoodSearch.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.wsoteam.diet.BranchFoodSearch.FoodObjects.DbAnalyzer;
import com.wsoteam.diet.BranchFoodSearch.FoodObjects.FoodConnect;
import com.wsoteam.diet.BranchFoodSearch.FoodObjects.FoodItem;
import com.wsoteam.diet.BranchFoodSearch.FoodObjects.ListOfFoodItem;
import com.wsoteam.diet.BranchFoodSearch.FoodObjects.ListOfGroupsOfFood;
import com.wsoteam.diet.Config;
import com.wsoteam.diet.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class ActivitySearch extends AppCompatActivity {
    private ArrayList<FoodItem> listOfGroupsFoods = new ArrayList<>();
    private ArrayList<FoodItem> tempListOfGroupsFoods = new ArrayList<>();
    private final String TAG_OWN_PRODUCT = "OWN";
    private DbAnalyzer dbAnalyzerGlobal = new DbAnalyzer();
    @BindView(R.id.edtActivityListAndSearchCollapsingSearchField) EditText edtSearchField;
    @BindView(R.id.ibActivityListAndSearchCollapsingCancelButton) ImageView ivCancel;
    @BindView(R.id.ivActivityListAndSearchEmptyImage) ImageView ivEmptyImage;
    @BindView(R.id.tvActivityListAndSearchEmptyText) TextView tvEmptyText;
    @BindView(R.id.rvListOfSearchResponse) RecyclerView rvListOfSearchResponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity_searchlist);
        ButterKnife.bind(this);
        rvListOfSearchResponse.setLayoutManager(new LinearLayoutManager(this));
        new AsyncLoadFoodList().execute();
    }

    @OnTextChanged(R.id.edtActivityListAndSearchCollapsingSearchField)
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (ivEmptyImage.getVisibility() == View.VISIBLE) {
            ivEmptyImage.setVisibility(View.GONE);
            tvEmptyText.setVisibility(View.GONE);
        }
        searchAndShowList(s);
    }

    private class AsyncLoadFoodList extends AsyncTask<Void, Void, DbAnalyzer> {
        @Override
        protected void onPostExecute(DbAnalyzer dbAnalyzer) {
            dbAnalyzerGlobal = dbAnalyzer;
            listOfGroupsFoods = fillItemsList(dbAnalyzer.getListOfGroupsOfFood());
            Log.e("LOL", String.valueOf(listOfGroupsFoods.size()));
        }

        @Override
        protected DbAnalyzer doInBackground(Void... voids) {
            String json;
            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<FoodConnect> jsonAdapter = moshi.adapter(FoodConnect.class);
            try {
                InputStream inputStream = getAssets().open("food_list.json");
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                inputStream.close();
                json = new String(buffer, "UTF-8");

                FoodConnect foodConnect = jsonAdapter.fromJson(json);

                DbAnalyzer dbAnalyzer = foodConnect.getDbAnalyzer();

                if (ListOfFoodItem.count(ListOfFoodItem.class) > 0) {
                    ArrayList<ListOfFoodItem> listOfFoodItem = (ArrayList) ListOfFoodItem.listAll(ListOfFoodItem.class);
                    ListOfGroupsOfFood savedGroupFood = new ListOfGroupsOfFood(listOfFoodItem, TAG_OWN_PRODUCT, TAG_OWN_PRODUCT);
                    dbAnalyzer.getListOfGroupsOfFood().add(0, savedGroupFood);
                }

                return dbAnalyzer;
            } catch (Exception e) {

            }
            return null;
        }
    }

    private ArrayList<FoodItem> fillItemsList(List<ListOfGroupsOfFood> listOfGroups) {
        ArrayList<FoodItem> items = new ArrayList<>();
        for (int i = 0; i < listOfGroups.size(); i++) {
            FoodItem itemOfGlobalBaseForWriting;
            for (int j = 0; j < listOfGroups.get(i).getListOfFoodItems().size(); j++) {
                itemOfGlobalBaseForWriting = new FoodItem(listOfGroups.get(i).getListOfFoodItems().get(j).getCalories()
                        , listOfGroups.get(i).getListOfFoodItems().get(j).getCarbohydrates()
                        , listOfGroups.get(i).getListOfFoodItems().get(j).getComposition()
                        , listOfGroups.get(i).getListOfFoodItems().get(j).getDescription()
                        , listOfGroups.get(i).getListOfFoodItems().get(j).getFat()
                        , listOfGroups.get(i).getListOfFoodItems().get(j).getName()
                        , listOfGroups.get(i).getListOfFoodItems().get(j).getProperties()
                        , listOfGroups.get(i).getListOfFoodItems().get(j).getProtein()
                        , listOfGroups.get(i).getListOfFoodItems().get(j).getUrlOfImages()
                        , listOfGroups.get(i).getName()
                        , listOfGroups.get(i).getListOfFoodItems().size());
                items.add(itemOfGlobalBaseForWriting);
            }

        }
        return items;
    }

    private void searchAndShowList(CharSequence text) {
        tempListOfGroupsFoods = new ArrayList<>();
        for (int j = 0; j < listOfGroupsFoods.size(); j++) {
            if (listOfGroupsFoods.get(j).getName().contains(text)
                    || (listOfGroupsFoods.get(j).getName()).contains(text.toString().substring(0, 1).toUpperCase()
                    + text.toString().substring(1))) {
                tempListOfGroupsFoods.add(listOfGroupsFoods.get(j));
            }
        }
        rvListOfSearchResponse.setAdapter(new ItemAdapter(tempListOfGroupsFoods));
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tvName) TextView tvName;
        @BindView(R.id.ivImage) ImageView ivImage;
        @BindView(R.id.tvCal) TextView tvCal;
        @BindView(R.id.tvNameOfGroup) TextView tvNameOfGroup;

        public ItemHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.products_item_onefood, viewGroup, false));
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                Intent intent = new Intent(ActivitySearch.this, ActivityDetailOfFood.class);
                intent.putExtra(Config.TAG_DETAIL_PRODUCT, tempListOfGroupsFoods.get(getAdapterPosition()));
                startActivity(intent);
        }

        public void bind(FoodItem itemOfGlobalBase, boolean isItemForSeparator) {
            tvName.setText(itemOfGlobalBase.getName());
            tvCal.setText(itemOfGlobalBase.getCalories() + " " + getString(R.string.for_100_g_of_product));
            tvNameOfGroup.setText(itemOfGlobalBase.getNameOfGroup());
            Glide.with(ActivitySearch.this).load(itemOfGlobalBase.getUrlOfImages()).into(ivImage);
        }
    }

    public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
        ArrayList<FoodItem> itemsOfGlobalBases;

        public ItemAdapter(ArrayList<FoodItem> itemsOfGlobalBases) {
            this.itemsOfGlobalBases = itemsOfGlobalBases;
        }

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(ActivitySearch.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
            if (itemsOfGlobalBases.get(position).getUrlOfImages().equals("0")) {
                holder.bind(itemsOfGlobalBases.get(position), true);
            } else {
                holder.bind(itemsOfGlobalBases.get(position), false);
            }

        }

        @Override
        public int getItemCount() {
            return itemsOfGlobalBases.size();
        }
    }
}
