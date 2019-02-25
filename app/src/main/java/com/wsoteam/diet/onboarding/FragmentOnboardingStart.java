package com.wsoteam.diet.Onboarding;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.wsoteam.diet.R;

public class FragmentOnboardingStart extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.onboarding_fragment_start, null);
        Button nextBtn = (Button) view.findViewById(R.id.btn_onboarding_start_next);

        nextBtn.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_onboarding_start_next:
                Fragment fr_onboardingSP = new FragmentOnboardingSpinner();
                getFragmentManager().beginTransaction().replace(R.id.fl_onboarding, fr_onboardingSP).addToBackStack("onboardingSp_frag").commit();
                break;

        }

        Toast.makeText(getActivity(), "Вы нажали на кнопку " + v.getId(),
                Toast.LENGTH_SHORT).show();
    }
}
