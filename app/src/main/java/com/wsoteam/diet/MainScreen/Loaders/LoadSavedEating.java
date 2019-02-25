package com.wsoteam.diet.MainScreen.Loaders;

import android.os.AsyncTask;

import com.wsoteam.diet.MainScreen.POJOEating.Breakfast;
import com.wsoteam.diet.MainScreen.POJOEating.Dinner;
import com.wsoteam.diet.MainScreen.POJOEating.Lunch;
import com.wsoteam.diet.MainScreen.POJOEating.Snack;

import java.util.ArrayList;
import java.util.List;

public class LoadSavedEating extends AsyncTask<Void, Void, List> {
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

        return list;
    }
}
