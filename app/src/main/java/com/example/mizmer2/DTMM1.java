package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class DTMM1 extends AppCompatActivity {

    Button evet1, hayir1, ilgisiz1, ilerle1;
    int answer1;
    Intent goToDtmm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtmm1);

        evet1 = (Button) findViewById(R.id.evetBttn1);
        hayir1=(Button)findViewById(R.id.hayirBttn1);
        ilgisiz1=(Button)findViewById(R.id.ilgisizBttn1);
        ilerle1 = (Button)findViewById(R.id.ilerleBttn1);
        goToDtmm2 = new Intent(this, DTMM2.class);


    }

    public void hayir1Clicked(View v){

    }
    public void ilgisiz1Clicked(View v){

    }
    public void ilerle1Clicked(View v){
        goToDtmm2.putExtra("answerOf1", answer1);
        startActivity(goToDtmm2);
    }

    public void evet1Clicked(View v){
        PopupMenu popupMenu = new PopupMenu(DTMM1.this, evet1);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //Toast.makeText(DTMM1.this," " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                answer1 = Integer.parseInt(menuItem.getTitle().toString());

                return true;
            }
        });
        popupMenu.show();

    }
}
