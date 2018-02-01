package com.example.mizmer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AyrintiliBilgi extends AppCompatActivity {

    Button btn;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayrintili_bilgi);

        text1 = findViewById(R.id.text_ayrintiliBilgi1);
        text2 = findViewById(R.id.text_ayrintiliBilgi2);
        btn =findViewById(R.id.bttn_ayrintili_bilgi);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AyrintiliBilgi.this, NavigationDrawerMenu.class));
            }
        });

    }
}
