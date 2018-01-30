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


public class HomeFragment extends Fragment{

    private static int counter = 0;

    public HomeFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment n

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        final Button bt = (Button)v.findViewById(R.id.buttonZ);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked();
            }
        });

        return v;
    }


    private void buttonClicked() {

        //final MyListener myListener = (MyListener) getActivity();

        if (counter < 3) {
            ArkadasEkleFragment arkadasEkleFragment = new ArkadasEkleFragment();
            getFragmentManager().beginTransaction().replace(R.id.contentLayout, arkadasEkleFragment, arkadasEkleFragment.getTag()).commit();
            counter++;
        }else {
            Toast.makeText(getActivity(),"Daha fazla Arkadaş ekleyemezsiniz!",Toast.LENGTH_SHORT).show();
        }

    }



}
