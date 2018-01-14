package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

public class DTMM9 extends AppCompatActivity {

    Button evet9, hayir9, ilgisiz9, ilerle9;
    TextView textView, textView2;
    int answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9;
    Intent goToAsama2, goToSonuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtmm9);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            answer1 = extras.getInt("answerOf1",0);
            answer2 = extras.getInt("answerOf2",0);
            answer3 = extras.getInt("answerOf3",0);
            answer4 = extras.getInt("answerOf4",0);
            answer5 = extras.getInt("answerOf5",0);
            answer6 = extras.getInt("answerOf6",0);
            answer7 = extras.getInt("answerOf7",0);
            answer8 = extras.getInt("answerOf8",0);
        }
/*
        textView=(TextView)findViewById(R.id.textDtmm9);
        textView2=(TextView)findViewById(R.id.textDtmm9_2);

        String a = Integer.toString(answer4);
        String b = Integer.toString(answer9);
        textView.setText(a);
        textView2.setText(b);
*/
        evet9 = (Button) findViewById(R.id.evetBttn9);
        hayir9=(Button)findViewById(R.id.hayirBttn9);
        ilgisiz9=(Button)findViewById(R.id.ilgisizBttn9);
        ilerle9 = (Button)findViewById(R.id.ilerleBttn9);

        goToAsama2 = new Intent(this, Asama2.class);
        goToSonuc = new Intent(this, Sonuc.class);


    }

    public void ilerle9Clicked(View v){
        int[] answers = new int[]{answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9};
        int max = 0;
        for (int i = 0 ; i < 9 ; i++){
            if(answers[i] > max)  max = answers[i];
        }

        ArrayList<Integer> equality = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            if (answers[i] == max || answers[i] == (max - 1)){
                equality.add(i+1); //INDEX OF MAX
            }
        }

        if (equality.size() == 1){

            goToSonuc.putExtra("whichquestion", (int) equality.get(0) );
            startActivity(goToSonuc);
        }
        else if(equality.size()==2) {
         goToAsama2.putExtra("equality1",equality.get(0));
         goToAsama2.putExtra("equality2",equality.get(1));
         goToAsama2.putExtra("size",equality.size());
         startActivity(goToAsama2);
        }
        else if (equality.size()==3){
            goToAsama2.putExtra("equality1",equality.get(0));
            goToAsama2.putExtra("equality2",equality.get(1));
            goToAsama2.putExtra("equality3",equality.get(2));
            goToAsama2.putExtra("size",equality.size());
            startActivity(goToAsama2);
        }
        else{
            goToSonuc.putExtra("whichquestion", (int) equality.get(0) );
            startActivity(goToSonuc);
        }


    }
    public void hayir9Clicked(View v){
        String x = Integer.toString(answer9);
        hayir9.setText(x);

    }
    public void ilgisiz9Clicked(View v){

    }
    public void evet9Clicked(View v) {
        PopupMenu popupMenu = new PopupMenu(DTMM9.this, evet9);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                answer9 = Integer.parseInt(menuItem.getTitle().toString());


                return true;
            }
        });
        popupMenu.show();

    }
}
