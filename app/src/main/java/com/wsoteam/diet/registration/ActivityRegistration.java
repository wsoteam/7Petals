package com.wsoteam.diet.Registration;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wsoteam.diet.R;

public class ActivityRegistration extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fl_registration);
        if (fragment == null) {
            fragment = new FragmentRegFerst();
            fm.beginTransaction()
                    .add(R.id.fl_registration, fragment)
                    .commit();
        }
    }


}
