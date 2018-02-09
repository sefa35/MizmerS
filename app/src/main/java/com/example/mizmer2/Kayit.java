package com.example.mizmer2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Kayit extends AppCompatActivity {

    private EditText name,email,username,pass1,pass2;
    private Button olustur;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
         name = (EditText)findViewById(R.id.kayit_id_text);
         email = (EditText)findViewById(R.id.kayit_mail_text);
         username = (EditText)findViewById(R.id.kayit_kullanıcıadı_text);
         pass1 = (EditText)findViewById(R.id.kayit_sifre_text);
         pass2 = (EditText)findViewById(R.id.kayit_sifre2_text);
         olustur = (Button)findViewById(R.id.kayitOlusturBttn);

        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();



    }



    public void onOlusturBttnClicked(View v){

        String nameStr = name.getText().toString();
        String emailStr = email.getText().toString();
        String usernameStr = username.getText().toString();
        String pass1Str = pass1.getText().toString();
        String pass2Str = pass2.getText().toString();

        if (TextUtils.isEmpty(emailStr)){
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }
        if (TextUtils.isEmpty(pass1Str)){
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        //progressDialog.setMessage("Registering user..");
        //progressDialog.show();

        if (!pass1Str.equals(pass2Str)){   //IF CONFİRM PASS AND PASS IS NOT THE SAME
            Toast pass = Toast.makeText(Kayit.this, "Şifreler eşleşmedi!", Toast.LENGTH_SHORT);
            pass.show();
        }
        else {
//            //inser the details to database
//            Contact c = new Contact();  //creating a new object
//
//            //we will set constructors of database to this object
//            c.setName(nameStr);
//            c.setEmail(emailStr);
//            c.setUname(usernameStr);
//            c.setPass(pass1Str);
//
//            dataBaseHelper.insertContact(c);

            firebaseAuth.createUserWithEmailAndPassword(emailStr, pass1Str)
                    .addOnCompleteListener(Kayit.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Kayit.this,"Kayıt yapıldı", Toast.LENGTH_SHORT ).show();
                            }else {
                                //Toast.makeText(Kayit.this,"Kayıt başarız. Tekrar deneyiniz", Toast.LENGTH_SHORT ).show();

                                FirebaseAuthException e = (FirebaseAuthException)task.getException();
                                Toast.makeText(Kayit.this, "Failed registration: "+ e.getMessage(),Toast.LENGTH_SHORT).show();
                                
                                Log.e("Kayit", "Failed Registration -- ",e);
                            }
                        }
                    });

//            startActivity(new Intent(Kayit.this,MainActivity.class));



        }



    }

}


