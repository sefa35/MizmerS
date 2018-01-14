package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class DTMM3 extends AppCompatActivity {

    Button evet3, hayir3, ilgisiz3, ilerle3;
    int answer1, answer2, answer3;
    Intent goToDtmm4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtmm3);

        evet3 = (Button) findViewById(R.id.evetBttn3);
        hayir3=(Button)findViewById(R.id.hayirBttn3);
        ilgisiz3=(Button)findViewById(R.id.ilgisizBttn3);
        ilerle3 = (Button)findViewById(R.id.ilerleBttn3);

        goToDtmm4 = new Intent(this, DTMM4.class);
        answer1 = getIntent().getIntExtra("answerOf1",0);
        answer2 = getIntent().getIntExtra("answerOf2",0);

    }

    public void ilerle3Clicked(View v){
        goToDtmm4.putExtra("answerOf1", answer1);
        goToDtmm4.putExtra("answerOf2", answer2);
        goToDtmm4.putExtra("answerOf3", answer3);

        startActivity(goToDtmm4);
    }
    public void hayir3Clicked(View v){

    }
    public void ilgisiz3Clicked(View v){

    }
    public void evet3Clicked(View v) {
        PopupMenu popupMenu = new PopupMenu(DTMM3.this, evet3);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                answer3 = Integer.parseInt(menuItem.getTitle().toString());
                return true;
            }
        });
        popupMenu.show();

    }
}
