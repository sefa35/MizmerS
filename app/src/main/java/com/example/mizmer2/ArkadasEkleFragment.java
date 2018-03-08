package com.example.mizmer2;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArkadasEkleFragment extends Fragment implements View.OnClickListener {

    private Button signIn;
    EditText arkadasName;
    Spinner spinGender, spinAge;
    String[] gender = {"Cinsiyet Seçiniz.." , "Erkek", "Kadın" };//array of strings used to populate the spinner

    OurData data = new OurData();


    public ArkadasEkleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_arkadas_ekle, container, false);


        arkadasName = (EditText) v.findViewById(R.id.arkadasekle_name);
        signIn = (Button)v.findViewById(R.id.in_sign_in);
        signIn.setOnClickListener(this);

        spinGender = (Spinner)v.findViewById(R.id.spinnerGender);
        spinAge = v.findViewById(R.id.spinnerAge);

        List<Integer> spinnerArray = new ArrayList<>();
        for (int i = 4; i < 100; i++){
            spinnerArray.add(i);
        }

        ArrayAdapter<String> adapterGender = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, gender);
        ArrayAdapter<Integer> adapterAge = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_spinner_item, spinnerArray);
        spinGender.setAdapter(adapterGender);
        spinAge.setAdapter(adapterAge);


        return v;
    }

    @Override
    public void onClick(View v) {

        data.addTitle(arkadasName.getText().toString());

        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        mBuilder.setIcon(R.drawable.logo);
        mBuilder.setTitle(R.string.popup_title);
        mBuilder.setMessage(R.string.popup_message);
        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("Teste geç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //myListener.goToFragment();
                Dtmm2Fragment dtmm2Fragment = new Dtmm2Fragment();
                getFragmentManager().beginTransaction().replace(R.id.contentLayout, dtmm2Fragment, dtmm2Fragment.getTag()).commit();


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
        switch (v.getId()){
            case R.id.in_sign_in:




        }
    }

}
