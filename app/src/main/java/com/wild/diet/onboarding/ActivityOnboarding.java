package com.wild.diet.onboarding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wild.diet.R;

public class ActivityOnboarding extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_activity);

        FragmentManager  fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fl_onboarding);
        if (fragment == null) {
            fragment = new FragmentOnboardingStart();
            fm.beginTransaction()
                    .add(R.id.fl_onboarding, fragment)
                    .commit();
        }
    }
}
