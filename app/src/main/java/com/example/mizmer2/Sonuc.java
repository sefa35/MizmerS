package com.example.mizmer2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Sonuc extends AppCompatActivity {

    TextView sonuc ;
    int indexOfDTMM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        indexOfDTMM=getIntent().getIntExtra("whichquestion",0);
        sonuc=(TextView)findViewById(R.id.textsonuc);
        if (indexOfDTMM==1)sonuc.setText("1");
        else if (indexOfDTMM==2)sonuc.setText("2");
        else if (indexOfDTMM==3)sonuc.setText("3");
        else if (indexOfDTMM==4)sonuc.setText("4");
        else if (indexOfDTMM==5)sonuc.setText("5");
        else if (indexOfDTMM==6)sonuc.setText("6");
        else if (indexOfDTMM==7)sonuc.setText("7");
        else if (indexOfDTMM==8)sonuc.setText("8");
        else if (indexOfDTMM==9)sonuc.setText("9");
    }
}
