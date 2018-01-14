package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class DTMM5 extends AppCompatActivity {

    Button evet5, hayir5, ilgisiz5, ilerle5;
    int answer1, answer2, answer3, answer4, answer5;
    Intent goToDtmm6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtmm5);

        evet5 = (Button) findViewById(R.id.evetBttn5);
        hayir5=(Button)findViewById(R.id.hayirBttn5);
        ilgisiz5=(Button)findViewById(R.id.ilgisizBttn5);
        ilerle5 = (Button)findViewById(R.id.ilerleBttn5);

        goToDtmm6 = new Intent(this, DTMM6.class);
        answer1 = getIntent().getIntExtra("answerOf1",0);
        answer2 = getIntent().getIntExtra("answerOf2",0);
        answer3 = getIntent().getIntExtra("answerOf3",0);
        answer4 = getIntent().getIntExtra("answerOf4",0);

    }

    public void ilerle5Clicked(View v){
        goToDtmm6.putExtra("answerOf1", answer1);
        goToDtmm6.putExtra("answerOf2", answer2);
        goToDtmm6.putExtra("answerOf3", answer3);
        goToDtmm6.putExtra("answerOf4", answer4);
        goToDtmm6.putExtra("answerOf5", answer5);

        startActivity(goToDtmm6);
    }
    public void hayir5Clicked(View v){

    }
    public void ilgisiz5Clicked(View v){

    }
    public void evet5Clicked(View v) {
        PopupMenu popupMenu = new PopupMenu(DTMM5.this, evet5);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                answer5 = Integer.parseInt(menuItem.getTitle().toString());
                return true;
            }
        });
        popupMenu.show();

    }
}
