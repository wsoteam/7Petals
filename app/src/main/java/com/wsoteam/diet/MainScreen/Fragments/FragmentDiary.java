package com.wsoteam.diet.MainScreen.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsoteam.diet.BranchFoodSearch.Activities.ActivitySearch;
import com.wsoteam.diet.MainScreen.POJOEating.Breakfast;
import com.wsoteam.diet.MainScreen.POJOEating.Dinner;
import com.wsoteam.diet.MainScreen.POJOEating.Lunch;
import com.wsoteam.diet.MainScreen.POJOEating.Snack;
import com.wsoteam.diet.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FragmentDiary extends Fragment {
    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ms_fragment_diary, container, false);
        unbinder = ButterKnife.bind(this, view);
        testFillLocalDB();



        return view;
    }

    private void testFillLocalDB() {
        for (int i = 0; i < 5; i++) {
            new Breakfast("name", "url", 100,
                    100, 100, 100, 30, 1, 1, 2019).save();
            new Lunch("name", "url", 100,
                    100, 100, 100, 30, 1, 1, 2019).save();
            new Dinner("name", "url", 100,
                    100, 100, 100, 30, 1, 1, 2019).save();
            new Snack("name", "url", 100,
                    100, 100, 100, 30, 1, 1, 2019).save();
        }
    }

    @OnClick(R.id.fabAddFood)
    public void onClick() {
        //startActivity(new Intent(getActivity(), ActivitySearch.class));
        //Log.e("LOL", )
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
