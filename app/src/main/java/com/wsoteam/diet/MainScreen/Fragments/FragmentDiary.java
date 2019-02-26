package com.wsoteam.diet.MainScreen.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FragmentDiary extends Fragment {
    @BindView(R.id.rvListOfBreakfast) RecyclerView rvListOfBreakfast;
    @BindView(R.id.rvListOfLunch) RecyclerView rvListOfLunch;
    @BindView(R.id.rvListOfDinner) RecyclerView rvListOfDinner;
    @BindView(R.id.rvListOfSnacks) RecyclerView rvListOfSnacks;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ms_fragment_diary, container, false);
        unbinder = ButterKnife.bind(this, view);

        new Breakfast("name", "url", 100, 30,
                30, 30, 30, 30, 1, 2019).save();
        Log.e("LOL", String.valueOf(Breakfast.last(Breakfast.class).getName()));
        return view;
    }


    @OnClick(R.id.fabAddFood)
    public void onClick() {
        startActivity(new Intent(getActivity(), ActivitySearch.class));
        //Log.e("LOL", )
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
