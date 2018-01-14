package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class DTMM4 extends AppCompatActivity {

    Button evet4, hayir4, ilgisiz4, ilerle4;
    int answer1, answer2, answer3, answer4;
    Intent goToDtmm5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtmm4);

        evet4 = (Button) findViewById(R.id.evetBttn4);
        hayir4=(Button)findViewById(R.id.hayirBttn4);
        ilgisiz4=(Button)findViewById(R.id.ilgisizBttn4);
        ilerle4 = (Button)findViewById(R.id.ilerleBttn4);

        goToDtmm5 = new Intent(this, DTMM5.class);
        answer1 = getIntent().getIntExtra("answerOf1",0);
        answer2 = getIntent().getIntExtra("answerOf2",0);
        answer3 = getIntent().getIntExtra("answerOf3",0);

    }

    public void ilerle4Clicked(View v){
        goToDtmm5.putExtra("answerOf1", answer1);
        goToDtmm5.putExtra("answerOf2", answer2);
        goToDtmm5.putExtra("answerOf3", answer3);
        goToDtmm5.putExtra("answerOf4", answer4);

        startActivity(goToDtmm5);
    }
    public void hayir4Clicked(View v){

    }
    public void ilgisiz4Clicked(View v){

    }
    public void evet4Clicked(View v) {
        PopupMenu popupMenu = new PopupMenu(DTMM4.this, evet4);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                answer4 = Integer.parseInt(menuItem.getTitle().toString());
                return true;
            }
        });
        popupMenu.show();

    }
}
