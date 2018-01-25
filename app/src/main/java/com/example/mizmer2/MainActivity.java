package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.app.*;
import android.widget.EditText;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {

    DataBaseHelper helper = new DataBaseHelper(this);

    Button kayıtButton, girisButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kayıtButton = (Button) findViewById(R.id.kayıtBttn);
        girisButton = (Button) findViewById(R.id.girisBttn);
    }

    public void girisClicked(View w){

        EditText a = (EditText)findViewById(R.id.kullanıcı_adı_text);
        String username = a.getText().toString();
        EditText b = (EditText)findViewById(R.id.sifre_text);
        String pass = b.getText().toString();

        String password = helper.searchPass(username);
        if (pass.equals(password)){
            Intent goToMenu = new Intent(this,NavigationDrawerMenu.class);
            startActivity(goToMenu);
        }
        else {
            Toast temp = Toast.makeText(MainActivity.this, "Username and password don't match!", Toast.LENGTH_SHORT);
            temp.show();
        }



    }
    public void kayıt(View v) {
        Intent goToKayit = new Intent(this, Kayit.class);
        startActivity(goToKayit);
    }

}
