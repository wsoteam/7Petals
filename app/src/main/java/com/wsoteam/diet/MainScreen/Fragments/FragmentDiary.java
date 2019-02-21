package com.wsoteam.diet.MainScreen.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsoteam.diet.BranchFoodSearch.ActivitySearch;
import com.wsoteam.diet.R;

public class FragmentDiary extends Fragment {
    private FloatingActionButton fabAddFood;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ms_fragment_diary, container, false);
        fabAddFood = view.findViewById(R.id.fabAddFood);


        fabAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivitySearch.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
