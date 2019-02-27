package com.wsoteam.diet.MainScreen.Loaders;

import android.os.AsyncTask;
import android.util.Log;

import com.wsoteam.diet.MainScreen.POJOEating.Breakfast;
import com.wsoteam.diet.MainScreen.POJOEating.Dinner;
import com.wsoteam.diet.MainScreen.POJOEating.Eating;
import com.wsoteam.diet.MainScreen.POJOEating.Lunch;
import com.wsoteam.diet.MainScreen.POJOEating.Snack;

import java.util.ArrayList;
import java.util.List;

public class LoadSavedEating extends AsyncTask<Void, Void, List<List<Eating>>> {
    @Override
    protected List doInBackground(Void... voids) {

        List<Breakfast> breakfasts = Breakfast.listAll(Breakfast.class);
        List<Lunch> lunches = Lunch.listAll(Lunch.class);
        List<Dinner> dinners = Dinner.listAll(Dinner.class);
        List<Snack> snacks = Snack.listAll(Snack.class);

        List list = new ArrayList();
        list.add(breakfasts);
        list.add(lunches);
        list.add(dinners);
        list.add(snacks);

        Log.e("LOL", String.valueOf(breakfasts.size()));
        Log.e("LOL", String.valueOf(lunches.size()));
        Log.e("LOL", String.valueOf(dinners.size()));
        Log.e("LOL", String.valueOf(snacks.size()));

        return list;
    }
}
