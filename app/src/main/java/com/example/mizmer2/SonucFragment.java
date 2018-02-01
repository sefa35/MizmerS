package com.example.mizmer2;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SonucFragment extends Fragment {

    Button sonucBttn;
    TextView sonuc ;
    int indexOfDTMM, forWhom;


    public SonucFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sonuc, container, false);

        sonucBttn = (Button)v.findViewById(R.id.buton_sonuc);
        sonuc = (TextView)v.findViewById(R.id.text_sonuc_fragment);

        Bundle bundle = getArguments();
        indexOfDTMM = bundle.getInt("whichquestion",0);
        forWhom = bundle.getInt("forWhom",0);

        if (forWhom == 1) sonuc.setText("   Dokuz Tip Mizaç modeline göre tipiniz " + indexOfDTMM + ". tip olarak belirlenmiştir.");
        else if (forWhom == 2) sonuc.setText("  Dokuz Tip Mizaç modeline göre arkadaşınızın tipi " + indexOfDTMM + ". tip olarak belirlenmiştir.");

        sonuc.setTextColor(Color.BLUE);



        sonucBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNDM = new Intent(getActivity().getApplication(), NavigationDrawerMenu.class);
                startActivity(goToNDM);


            }
        });



        return v;
    }





}
