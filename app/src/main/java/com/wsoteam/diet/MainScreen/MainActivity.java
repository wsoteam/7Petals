package com.wsoteam.diet.MainScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.wsoteam.diet.BranchFoodSearch.Activities.ActivitySearch;
import com.wsoteam.diet.MainScreen.ListOfEatings.EatingAdapter;
import com.wsoteam.diet.MainScreen.Loaders.LoadSavedEating;
import com.wsoteam.diet.MainScreen.POJOEating.Breakfast;
import com.wsoteam.diet.MainScreen.POJOEating.Dinner;
import com.wsoteam.diet.MainScreen.POJOEating.Eating;
import com.wsoteam.diet.MainScreen.POJOEating.Lunch;
import com.wsoteam.diet.MainScreen.POJOEating.Snack;
import com.wsoteam.diet.R;

import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.rvListOfBreakfast) RecyclerView rvListOfBreakfast;
    @BindView(R.id.rvListOfLunch) RecyclerView rvListOfLunch;
    @BindView(R.id.rvListOfDinner) RecyclerView rvListOfDinner;
    @BindView(R.id.rvListOfSnacks) RecyclerView rvListOfSnacks;
    @BindView(R.id.nav_view_g) NavigationView navViewG;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    private EatingAdapter breakfastAdapter, lunchAdapter, dinnerAdapter, snackAdapter;

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ms_activity_main);
        ButterKnife.bind(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navViewG.setNavigationItemSelectedListener(this);
        //testFill();
        rvListOfBreakfast.setLayoutManager(new LinearLayoutManager(this));
        rvListOfLunch.setLayoutManager(new LinearLayoutManager(this));
        rvListOfDinner.setLayoutManager(new LinearLayoutManager(this));
        rvListOfSnacks.setLayoutManager(new LinearLayoutManager(this));
    }

    private void testFill() {
        for (int i = 0; i < 10; i++) {
            new Breakfast("name", "url", 100, 100, 100,
                    100, 100, 1, 1, 2019).save();
            new Lunch("name", "url", 100, 100, 100,
                    100, 100, 1, 1, 2019).save();
            new Dinner("name", "url", 100, 100, 100,
                    100, 100, 1, 1, 2019).save();
            new Snack("name", "url", 100, 100, 100,
                    100, 100, 1, 1, 2019).save();
        }
    }

    private void updateUI() {
        try {
            List<List<Eating>> eatingList = new LoadSavedEating().execute().get();

            breakfastAdapter = new EatingAdapter(eatingList.get(0), this);
            lunchAdapter = new EatingAdapter(eatingList.get(1), this);
            dinnerAdapter = new EatingAdapter(eatingList.get(2), this);
            snackAdapter = new EatingAdapter(eatingList.get(3), this);

            rvListOfBreakfast.setAdapter(breakfastAdapter);
            rvListOfLunch.setAdapter(lunchAdapter);
            rvListOfDinner.setAdapter(dinnerAdapter);
            rvListOfSnacks.setAdapter(snackAdapter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.fabAddFood)
    public void onViewClicked() {
        startActivity(new Intent(this, ActivitySearch.class));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
