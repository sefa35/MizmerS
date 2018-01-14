package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class DTMM7 extends AppCompatActivity {
    Button evet7, hayir7, ilgisiz7, ilerle7;
    Intent goToDtmm8;
    int answer1, answer2, answer3, answer4, answer5, answer6, answer7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtmm7);


        goToDtmm8 = new Intent(this, DTMM8.class);
        answer1 = getIntent().getIntExtra("answerOf1",0);
        answer2 = getIntent().getIntExtra("answerOf2",0);
        answer3 = getIntent().getIntExtra("answerOf3",0);
        answer4 = getIntent().getIntExtra("answerOf4",0);
        answer5 = getIntent().getIntExtra("answerOf5",0);
        answer6 = getIntent().getIntExtra("answerOf6",0);

        evet7 = (Button) findViewById(R.id.evetBttn7);
        hayir7=(Button)findViewById(R.id.hayirBttn7);
        ilgisiz7=(Button)findViewById(R.id.ilgisizBttn7);
        ilerle7 = (Button)findViewById(R.id.ilerleBttn7);

    }

    public void ilerle7Clicked(View v){
        goToDtmm8.putExtra("answerOf1", answer1);
        goToDtmm8.putExtra("answerOf2", answer2);
        goToDtmm8.putExtra("answerOf3", answer3);
        goToDtmm8.putExtra("answerOf4", answer4);
        goToDtmm8.putExtra("answerOf5", answer5);
        goToDtmm8.putExtra("answerOf6", answer6);
        goToDtmm8.putExtra("answerOf7", answer7);
        startActivity(goToDtmm8);
    }
    public void hayir7Clicked(View v){

    }
    public void ilgisiz7Clicked(View v){

    }
    public void evet7Clicked(View v) {
        PopupMenu popupMenu = new PopupMenu(DTMM7.this, evet7);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                answer7 = Integer.parseInt(menuItem.getTitle().toString());
                return true;
            }
        });
        popupMenu.show();

    }
}
