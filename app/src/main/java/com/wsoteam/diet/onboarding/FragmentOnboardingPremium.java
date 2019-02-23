package com.wsoteam.diet.onboarding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wsoteam.diet.R;

public class FragmentOnboardingPremium extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.onboarding_fragment_premium, null);

        Button premium = (Button) view.findViewById(R.id.btn_prem);
        TextView noPrem = (TextView) view.findViewById(R.id.tv_prem);
        noPrem.setClickable(true);

        premium.setOnClickListener(this);
        noPrem.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_prem:
                break;
            case R.id.tv_prem:
//                TextView noPrem = (TextView) v.findViewById(R.id.tv_prem);
//                noPrem.setTextColor(r);
                break;
        }

        Toast.makeText(getActivity(), "Вы нажали на кнопку " + v.getId(),
                Toast.LENGTH_SHORT).show();
    }
}
