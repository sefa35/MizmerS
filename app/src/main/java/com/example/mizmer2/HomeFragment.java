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


public class HomeFragment extends Fragment{


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

        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        mBuilder.setIcon(R.drawable.logo);
        mBuilder.setTitle(R.string.popup_title);
        mBuilder.setMessage(R.string.popup_message);
        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("Teste geç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //myListener.goToFragment();
                Dtmm1Fragment dtmm1Fragment = new Dtmm1Fragment();
                getFragmentManager().beginTransaction().replace(R.id.contentLayout, dtmm1Fragment, dtmm1Fragment.getTag()).commit();


            }
        });
        mBuilder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();


    }



}
