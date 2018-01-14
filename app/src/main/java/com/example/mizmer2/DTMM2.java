package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class DTMM2 extends AppCompatActivity {

    Button evet2, hayir2, ilgisiz2, ilerle2;
    Intent goToDtmm3;
    int answer1, answer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtmm2);

        evet2 = (Button) findViewById(R.id.evetBttn2);
        hayir2=(Button)findViewById(R.id.hayirBttn2);
        ilgisiz2=(Button)findViewById(R.id.ilgisizBttn2);
        ilerle2 = (Button)findViewById(R.id.ilerleBttn2);

        goToDtmm3 = new Intent(this, DTMM3.class);
        answer1 = getIntent().getIntExtra("answerOf1",0);

    }

    public void ilerle2Clicked(View v){
        goToDtmm3.putExtra("answerOf1", answer1);
        goToDtmm3.putExtra("answerOf2", answer2);

        startActivity(goToDtmm3);
    }
    public void hayir2Clicked(View v){

    }
    public void ilgisiz2Clicked(View v){

    }
    public void evet2Clicked(View v) {
        PopupMenu popupMenu = new PopupMenu(DTMM2.this, evet2);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                answer2 = Integer.parseInt(menuItem.getTitle().toString());
                return true;
            }
        });
        popupMenu.show();


    }
}
