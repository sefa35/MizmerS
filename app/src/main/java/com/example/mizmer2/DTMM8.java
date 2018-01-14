package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class DTMM8 extends AppCompatActivity {

    Button evet8, hayir8, ilgisiz8, ilerle8;
    Intent goToDtmm9;
    TextView textView8;
    int answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtmm8);


        goToDtmm9 = new Intent(this, DTMM9.class);
        answer1 = getIntent().getIntExtra("answerOf1",0);
        answer2 = getIntent().getIntExtra("answerOf2",0);
        answer3 = getIntent().getIntExtra("answerOf3",0);
        answer4 = getIntent().getIntExtra("answerOf4",0);
        answer5 = getIntent().getIntExtra("answerOf5",0);
        answer6 = getIntent().getIntExtra("answerOf6",0);
        answer7 = getIntent().getIntExtra("answerOf7",0);

        evet8 = (Button) findViewById(R.id.evetBttn8);
        hayir8=(Button)findViewById(R.id.hayirBttn8);
        ilgisiz8=(Button)findViewById(R.id.ilgisizBttn8);
        ilerle8 = (Button)findViewById(R.id.ilerleBttn8);

    }

    public void ilerle8Clicked(View v){
        goToDtmm9.putExtra("answerOf1", answer1);
        goToDtmm9.putExtra("answerOf2", answer2);
        goToDtmm9.putExtra("answerOf3", answer3);
        goToDtmm9.putExtra("answerOf4", answer4);
        goToDtmm9.putExtra("answerOf5", answer5);
        goToDtmm9.putExtra("answerOf6", answer6);
        goToDtmm9.putExtra("answerOf7", answer7);
        goToDtmm9.putExtra("answerOf8", answer8);

        startActivity(goToDtmm9);
    }
    public void hayir8Clicked(View v){

    }
    public void ilgisiz8Clicked(View v){

    }
    public void evet8Clicked(View v) {
        final PopupMenu popupMenu = new PopupMenu(DTMM8.this, evet8);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                answer8 = Integer.parseInt(menuItem.getTitle().toString());

                return true;
            }
        });
        popupMenu.show();

    }
}
