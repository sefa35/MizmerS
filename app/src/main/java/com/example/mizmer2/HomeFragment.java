package com.example.mizmer2;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.*;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class
HomeFragment extends Fragment{

    private Button goToTest, firstFriend, addFriend, cıkıs;
    private static int counter = 0;
    private FirebaseAuth firebaseAuth;

    public HomeFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment n

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            startActivity(new Intent(getActivity().getApplication(), MainActivity.class ));

        }

        goToTest = (Button)v.findViewById(R.id.button_test_coz);
        firstFriend = (Button)v.findViewById(R.id.button_arkadaş1);
        addFriend = (Button)v.findViewById(R.id.button_arkadas_ekle);
        cıkıs = v.findViewById(R.id.button_cıkıs);

        cıkıs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseAuth.signOut();
                startActivity(new Intent(getActivity().getApplication(), MainActivity.class));

            }
        });

        goToTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), ExamActivity.class ));

            }
        });
        firstFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArkadaslarFragment arkadaslarFragment = new ArkadaslarFragment();
                getFragmentManager().beginTransaction().replace(R.id.contentLayout, arkadaslarFragment, arkadaslarFragment.getTag()).commit();

            }
        });
        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < 3) {
                    ArkadasEkleFragment arkadasEkleFragment = new ArkadasEkleFragment();
                    getFragmentManager().beginTransaction().replace(R.id.contentLayout, arkadasEkleFragment, arkadasEkleFragment.getTag()).commit();
                    counter++;
                }else {
                    Toast.makeText(getActivity(),"Daha fazla Arkadaş ekleyemezsiniz!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        return v;
    }


}
