package com.example.mizmer2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Kayit extends AppCompatActivity {

    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
    }

    public void onOlusturBttnClicked(View v){

        EditText name = (EditText)findViewById(R.id.kayit_id_text);
        EditText email = (EditText)findViewById(R.id.kayit_mail_text);
        EditText username = (EditText)findViewById(R.id.kayit_kullanıcıadı_text);
        EditText pass1 = (EditText)findViewById(R.id.kayit_sifre_text);
        EditText pass2 = (EditText)findViewById(R.id.kayit_sifre2_text);

        String nameStr = name.getText().toString();
        String emailStr = email.getText().toString();
        String usernameStr = username.getText().toString();
        String pass1Str = pass1.getText().toString();
        String pass2Str = pass2.getText().toString();

        if (!pass1Str.equals(pass2Str)){   //IF CONFİRM PASS AND PASS IS NOT THE SAME
            Toast pass = Toast.makeText(Kayit.this, "Passwords don't match!", Toast.LENGTH_SHORT);
            pass.show();
        }
        else {
            //inser the details to database
            Contact c = new Contact();  //creating a new object

            //we will set constructors of database to this object
            c.setName(nameStr);
            c.setEmail(emailStr);
            c.setUname(usernameStr);
            c.setPass(pass1Str);

            dataBaseHelper.insertContact(c);

        }

    }

}


