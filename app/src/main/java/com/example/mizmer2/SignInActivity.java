package com.example.mizmer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email,password;
    private Button signIn,signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.in_email);
        password = findViewById(R.id.in_password);
        signIn = findViewById(R.id.in_sign_in);
        signUp = findViewById(R.id.in_sign_up);

        signUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.in_sign_up:
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
        }
    }
}
