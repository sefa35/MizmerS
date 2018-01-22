package com.example.mizmer2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.*;

public class NavigationDrawerMenu extends AppCompatActivity implements MyListener{

    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_menu:
                    //mTextMessage.setText(R.string.title_menu);

                    HomeFragment homeFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, homeFragment, homeFragment.getTag()).commit();

                    return true;
                case R.id.navigation_dtmm:
                    //mTextMessage.setText(R.string.title_dtmm);

                    DtmmFragment dtmmFragment = new DtmmFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, dtmmFragment, dtmmFragment.getTag()).commit();

                    return true;
                case R.id.navigation_profile:
                    //mTextMessage.setText(R.string.title_profile);
                    return true;
                case R.id.navigation_suggestions:
                    //mTextMessage.setText(R.string.title_suggestions);
                    return true;
                case R.id.navigation_aboutUs:
                    //mTextMessage.setText(R.string.title_aboutUs);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_menu);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }


    @Override
    public void goToFragment() {

        Dtmm1Fragment dtmm1Fragment = new Dtmm1Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, dtmm1Fragment, dtmm1Fragment.getTag()).commit();

    }
}
