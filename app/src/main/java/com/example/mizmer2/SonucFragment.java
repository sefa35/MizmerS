package com.example.mizmer2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SonucFragment extends Fragment {

    TextView sonuc ;
    int indexOfDTMM;


    public SonucFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sonuc, container, false);

        sonuc = (TextView)v.findViewById(R.id.text_sonuc_fragment);
        Bundle bundle = getArguments();
        indexOfDTMM = bundle.getInt("whichquestion",0);
        if (indexOfDTMM==1)sonuc.setText("1");
        else if (indexOfDTMM==2)sonuc.setText("2");
        else if (indexOfDTMM==3)sonuc.setText("3");
        else if (indexOfDTMM==4)sonuc.setText("4");
        else if (indexOfDTMM==5)sonuc.setText("5");
        else if (indexOfDTMM==6)sonuc.setText("6");
        else if (indexOfDTMM==7)sonuc.setText("7");
        else if (indexOfDTMM==8)sonuc.setText("8");
        else if (indexOfDTMM==9)sonuc.setText("9");

        return v;
    }

}
