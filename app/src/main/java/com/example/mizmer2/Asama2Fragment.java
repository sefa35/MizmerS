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
public class Asama2Fragment extends Fragment {
    TextView sonuc , sonuc2 , sonuc3;
    int size,val1,val2,val3;



    public Asama2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_asama2, container, false);

        sonuc =(TextView)v.findViewById(R.id.textAsama_fragment);
        sonuc2 =(TextView)v.findViewById(R.id.textAsama2_fragment);
        sonuc3 =(TextView)v.findViewById(R.id.textAsama3_fragment);

        Bundle bundle1 = getArguments();
        size = bundle1.getInt("size",0);

        if (size == 2){
            val1=bundle1.getInt("equality1",0);
            val2=bundle1.getInt("equality2",0);
        }
        else if (size==3){
            val1=bundle1.getInt("equality1",0);
            val2=bundle1.getInt("equality2",0);
            val3=bundle1.getInt("equality3",0);
        }

        if (val1==1)sonuc.setText("1");
        else if (val1==2)sonuc.setText("2");
        else if (val1==3)sonuc.setText("3");
        else if (val1==4)sonuc.setText("4");
        else if (val1==5)sonuc.setText("5");
        else if (val1==6)sonuc.setText("6");
        else if (val1==7)sonuc.setText("7");
        else if (val1==8)sonuc.setText("8");
        else if (val1==9)sonuc.setText("9");

        if (val2==1)sonuc2.setText("1");
        else if (val2==2)sonuc2.setText("2");
        else if (val2==3)sonuc2.setText("3");
        else if (val2==4)sonuc2.setText("4");
        else if (val2==5)sonuc2.setText("5");
        else if (val2==6)sonuc2.setText("6");
        else if (val2==7)sonuc2.setText("7");
        else if (val2==8)sonuc2.setText("8");
        else if (val2==9)sonuc2.setText("9");

        if (val3==1)sonuc3.setText("1");
        else if (val3==2)sonuc3.setText("2");
        else if (val3==3)sonuc3.setText("3");
        else if (val3==4)sonuc3.setText("4");
        else if (val3==5)sonuc3.setText("5");
        else if (val3==6)sonuc3.setText("6");
        else if (val3==7)sonuc3.setText("7");
        else if (val3==8)sonuc3.setText("8");
        else if (val3==9)sonuc3.setText("9");

        return v;

    }

}
