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

public class FragmentRegHello extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.registration_fragment_hello, null);
        Button next = (Button) view.findViewById(R.id.button_hello_next);

        next.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_hello_next:
                Fragment fr_regMain = new FragmentRegMain();
                getFragmentManager().beginTransaction().replace(R.id.fl_registration, fr_regMain).addToBackStack("regMain_frag").commit();
                break;
            case R.id.button_login:
                break;
        }
        Toast.makeText(getActivity(), "Вы нажали на кнопку " + v.getId(),
                Toast.LENGTH_SHORT).show();
    }
}
