package com.example.mizmer2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button testeBasla, bizKimiz, dtmm, profil, öneri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        testeBasla = (Button) findViewById(R.id.testBttn);
        bizKimiz = (Button)findViewById(R.id.bizKimizBttn);
        dtmm = (Button)findViewById(R.id.dtmmBttn);
        profil=(Button)findViewById(R.id.profilBttn);
        öneri=(Button)findViewById(R.id.öneriBttn);

    }

     public void bizKimizClicked(View v){
         Intent goToBizKimiz = new Intent(this, BizKimiz.class);
         startActivity(goToBizKimiz);
     }
     public void dtmmClicked(View v){
        Intent goToDtmm = new Intent(this, DTMM.class);
        startActivity(goToDtmm);
     }
     public void profilClicked(View v){
        Intent goToProfil = new Intent(this, Profil.class);
        startActivity(goToProfil);
     }
     public void öneriClicked(View v){
        Intent goToÖneri = new Intent(this, Oneri.class);
        startActivity(goToÖneri);
     }

    public void testBttnClicked(View v){
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Menu.this);
        mBuilder.setIcon(R.drawable.logo);
        mBuilder.setTitle(R.string.popup_title);
        mBuilder.setMessage(R.string.popup_message);
        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("Teste geç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent goToTest = new Intent(Menu.this, DTMM1.class);
                startActivity(goToTest);
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
