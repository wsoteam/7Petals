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
import android.widget.Toast;

import com.wsoteam.diet.BranchFoodSearch.ActivitySearch;
import com.wsoteam.diet.R;

import butterknife.BindView;
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
        return view;
    }

    @OnClick(R.id.fabAddFood)
    public void onClick() {
        startActivity(new Intent(getActivity(), ActivitySearch.class));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
