package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.app.*;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class  MainActivity extends AppCompatActivity {

    DataBaseHelper helper = new DataBaseHelper(this);

    Button  girisButton;
    TextView kayıtOl;
    EditText kullanıcı_adı, sifre;
    private String username, pass;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), SlideActivity.class));
        }

        kayıtOl= (TextView) findViewById(R.id.login_register_txt);
        girisButton = (Button) findViewById(R.id.girisBttn);
        kullanıcı_adı = (EditText)findViewById(R.id.kullanıcı_adı_text);
        sifre = (EditText)findViewById(R.id.sifre_text);


        progressDialog = new ProgressDialog(this);
    }



    public void girisClicked(View w){

        userLogin();



//        String password = helper.searchPass(username);
//        if (pass.equals(password)){
//            Intent goToSlider = new Intent(this, SlideActivity.class);
//            startActivity(goToSlider);
//            //Intent goToMenu = new Intent(this,NavigationDrawerMenu.class);
//            //startActivity(goToMenu);
//        }
//        else {
//            Toast temp = Toast.makeText(MainActivity.this, "Username and password don't match!", Toast.LENGTH_SHORT);
//            temp.show();
//        }


    }

    private void userLogin() {
        username = kullanıcı_adı.getText().toString().trim();
        pass = sifre.getText().toString().trim();

        if (TextUtils.isEmpty(username)){  // Actually this is email
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }
        if (TextUtils.isEmpty(pass)){
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering user..");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(username, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()){
                            //start the profile activity
                            finish();
                            startActivity(new Intent(MainActivity.this, SlideActivity.class));
                        }

                    }
                });

    }

    public void kayıt(View v) {
        Intent goToKayit = new Intent(this, Kayit.class);
        startActivity(goToKayit);
    }

}
