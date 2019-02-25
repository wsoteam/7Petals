package com.wsoteam.diet.Registration;

import android.content.Intent;
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
import com.wsoteam.diet.Onboarding.ActivityOnboarding;

public class FragmentRegMain extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.registration_fragment_main, null);

        Button regEmail = (Button) view.findViewById(R.id.btn_reg_email);
        Button google = (Button) view.findViewById(R.id.btn_goggle);
        Button facebook = (Button) view.findViewById(R.id.btn_facebook);


        regEmail.setOnClickListener(this);
        google.setOnClickListener(this);
        facebook.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), ActivityOnboarding.class);

        switch (v.getId()){
            case R.id.btn_reg_email:
                startActivity(intent);
                break;
            case R.id.btn_goggle:
                break;
            case R.id.btn_facebook:
                break;
        }

        Toast.makeText(getActivity(), "Вы нажали на кнопку " + v.getId(),
                Toast.LENGTH_SHORT).show();
    }


}
