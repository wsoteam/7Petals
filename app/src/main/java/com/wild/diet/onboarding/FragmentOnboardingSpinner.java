package com.wild.diet.onboarding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.wild.diet.R;

public class FragmentOnboardingSpinner extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.onboarding_fragment_spinner, null);
        Button next = (Button) view.findViewById(R.id.btn_spinner_next);

        next.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_spinner_next:
                Fragment fr_onboardingPrem = new FragmentOnboardingPremium();
                getFragmentManager().beginTransaction().replace(R.id.fl_onboarding, fr_onboardingPrem).addToBackStack("onboardingPrem_frag").commit();
                break;
        }

        Toast.makeText(getActivity(), "Вы нажали на кнопку " + v.getId(),
                Toast.LENGTH_SHORT).show();
    }
}
