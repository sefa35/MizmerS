package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.app.*;

public class  MainActivity extends AppCompatActivity {

    Button kayıtButton, girisButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kayıtButton = (Button) findViewById(R.id.kayıtBttn);
        girisButton = (Button) findViewById(R.id.girisBttn);
    }

    public void girisClicked(View w){
        Intent goToMenu = new Intent(this,NavigationDrawerMenu.class);
        startActivity(goToMenu);

    }
    public void kayıt(View v) {
        Intent goToKayit = new Intent(this, Kayit.class);
        startActivity(goToKayit);
    }

}
