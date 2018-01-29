package com.example.mizmer2;


import android.app.Activity;
import android.content.Intent;
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
    int indexOfDTMM;


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
        if (indexOfDTMM==1)sonuc.setText("1. Tip olarak belirlendiniz!");
        else if (indexOfDTMM==2)sonuc.setText("2. Tip olarak belirlendiniz!");
        else if (indexOfDTMM==3)sonuc.setText("3. Tip olarak belirlendiniz!");
        else if (indexOfDTMM==4)sonuc.setText("4. Tip olarak belirlendiniz!");
        else if (indexOfDTMM==5)sonuc.setText("5. Tip olarak belirlendiniz!");
        else if (indexOfDTMM==6)sonuc.setText("6. Tip olarak belirlendiniz!");
        else if (indexOfDTMM==7)sonuc.setText("7. Tip olarak belirlendiniz!");
        else if (indexOfDTMM==8)sonuc.setText("8. Tip olarak belirlendiniz!");
        else if (indexOfDTMM==9)sonuc.setText("9. Tip olarak belirlendiniz!");


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
