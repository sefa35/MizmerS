package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class DTMM6 extends AppCompatActivity {

    Button evet6, hayir6, ilgisiz6, ilerle6;
    int answer1, answer2, answer3, answer4, answer5, answer6;
    Intent goToDtmm7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtmm6);

        evet6 = (Button) findViewById(R.id.evetBttn6);
        hayir6=(Button)findViewById(R.id.hayirBttn6);
        ilgisiz6=(Button)findViewById(R.id.ilgisizBttn6);
        ilerle6 = (Button)findViewById(R.id.ilerleBttn6);

        goToDtmm7 = new Intent(this, DTMM7.class);
        answer1 = getIntent().getIntExtra("answerOf1",0);
        answer2 = getIntent().getIntExtra("answerOf2",0);
        answer3 = getIntent().getIntExtra("answerOf3",0);
        answer4 = getIntent().getIntExtra("answerOf4",0);
        answer5 = getIntent().getIntExtra("answerOf5",0);

    }
    public void ilerle6Clicked(View v){
        goToDtmm7.putExtra("answerOf1", answer1);
        goToDtmm7.putExtra("answerOf2", answer2);
        goToDtmm7.putExtra("answerOf3", answer3);
        goToDtmm7.putExtra("answerOf4", answer4);
        goToDtmm7.putExtra("answerOf5", answer5);
        goToDtmm7.putExtra("answerOf6", answer6);

        startActivity(goToDtmm7);
    }
    public void hayir6Clicked(View v){

    }
    public void ilgisiz6Clicked(View v){

    }
    public void evet6Clicked(View v) {
        PopupMenu popupMenu = new PopupMenu(DTMM6.this, evet6);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                answer6 = Integer.parseInt(menuItem.getTitle().toString());
                return true;
            }
        });
        popupMenu.show();

    }
}
