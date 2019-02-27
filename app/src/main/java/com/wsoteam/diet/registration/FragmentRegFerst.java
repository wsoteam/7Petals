package com.wsoteam.diet.registration;

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

public class FragmentRegFerst extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.registration_fragment_ferst, null);
        Button registration = (Button) view.findViewById(R.id.button_reg);
        Button login = (Button) view.findViewById(R.id.button_login);

        registration.setOnClickListener(this);
        login.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_reg:
                Fragment fr_hello = new FragmentRegHello();
                getFragmentManager().beginTransaction().replace(R.id.fl_registration, fr_hello).addToBackStack("Hello_frag").commit();
                break;
            case R.id.button_login:
                Fragment fr_login = new FragmentRegLogin();
                getFragmentManager().beginTransaction().replace(R.id.fl_registration, fr_login).addToBackStack("Login_frag").commit();
                break;
        }

        Toast.makeText(getActivity(), "Вы нажали на кнопку " + v.getId(),
                Toast.LENGTH_SHORT).show();
    }
}
