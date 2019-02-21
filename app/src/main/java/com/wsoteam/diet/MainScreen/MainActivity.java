package com.wsoteam.diet.MainScreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.wsoteam.diet.MainScreen.Fragments.FragmentConversation;
import com.wsoteam.diet.MainScreen.Fragments.FragmentDiary;
import com.wsoteam.diet.MainScreen.Fragments.FragmentPremium;
import com.wsoteam.diet.MainScreen.Fragments.FragmentProfile;
import com.wsoteam.diet.MainScreen.Fragments.FragmentRecipes;
import com.wsoteam.diet.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FrameLayout flFragmentContainer;
    private ArrayList<Fragment> listOfFragments;
    private FragmentTransaction transaction;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            transaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.nav_diary:
                    transaction.replace(R.id.flFragmentContainer, listOfFragments.get(0)).commit();
                    return true;
                case R.id.nav_profile:
                    transaction.replace(R.id.flFragmentContainer, listOfFragments.get(1)).commit();
                    return true;
                case R.id.nav_recipes:
                    transaction.replace(R.id.flFragmentContainer, listOfFragments.get(2)).commit();
                    return true;
                case R.id.nav_premium:
                    transaction.replace(R.id.flFragmentContainer, listOfFragments.get(3)).commit();
                    return true;
                case R.id.nav_conversation:
                    transaction.replace(R.id.flFragmentContainer, listOfFragments.get(4)).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ms_activity_main);
        flFragmentContainer = findViewById(R.id.flFragmentContainer);
        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        listOfFragments = new ArrayList<>();
        listOfFragments.add(new FragmentDiary());
        listOfFragments.add(new FragmentProfile());
        listOfFragments.add(new FragmentRecipes());
        listOfFragments.add(new FragmentPremium());
        listOfFragments.add(new FragmentConversation());

        getSupportFragmentManager().beginTransaction().add(R.id.flFragmentContainer, listOfFragments.get(0)).commit();
    }

}
