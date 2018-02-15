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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Kayit extends AppCompatActivity {

    private EditText name,email,username,pass1,pass2;
    public static String nameStr,emailStr,usernameStr,pass1Str,pass2Str;

    private Button olustur;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        firebaseAuth = FirebaseAuth.getInstance();

//        if (firebaseAuth.getCurrentUser() != null){
//            //profile activity here
//            finish();
//            startActivity(new Intent(getApplicationContext(), SlideActivity.class));
//        }

        databaseReference = FirebaseDatabase.getInstance().getReference();

         name = (EditText)findViewById(R.id.kayit_id_text);
         email = (EditText)findViewById(R.id.kayit_mail_text);
         username = (EditText)findViewById(R.id.kayit_kullanıcıadı_text);
         pass1 = (EditText)findViewById(R.id.kayit_sifre_text);
         pass2 = (EditText)findViewById(R.id.kayit_sifre2_text);
         olustur = (Button)findViewById(R.id.kayitOlusturBttn);




        progressDialog = new ProgressDialog(this);





    }

    private void saveUserInformation(){

        if (nameStr.equals(name.getText().toString())) {

            Toast.makeText(this, "Bilgiler database içine kaydedildi.."+emailStr+usernameStr, Toast.LENGTH_SHORT).show();
        }

    }

    public void onOlusturBttnClicked(View v){


        nameStr = name.getText().toString().trim();
        emailStr = email.getText().toString().trim();
        usernameStr = username.getText().toString().trim();
        pass1Str = pass1.getText().toString().trim();
        pass2Str = pass2.getText().toString().trim();




        Bundle bundle = new Bundle();
        SonucFragment sonucFragment = new SonucFragment();

        bundle.putString("name", nameStr);
        bundle.putString("email",emailStr);
        bundle.putString("username", usernameStr);
        bundle.putString("password", pass1Str);
        sonucFragment.setArguments(bundle);
//
//        Intent navigationDrawerMenu = new Intent(this, NavigationDrawerMenu.class);
//        navigationDrawerMenu.putExtra("name", nameStr);
//        navigationDrawerMenu.putExtra("email",emailStr);
//        navigationDrawerMenu.putExtra("username", usernameStr);
//        navigationDrawerMenu.putExtra("password", pass1Str);

        Contact contact = new Contact(nameStr,emailStr, usernameStr, pass1Str, 0);
        //FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(emailStr.replace('.',' ')).setValue(contact);
        //databaseReference.child(user.getUid()).setValue(contact);





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

  //      progressDialog.setMessage("Registering user..");
//        progressDialog.show();

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

                                Toast.makeText(Kayit.this,"Kayıt yapıldı"+emailStr+nameStr, Toast.LENGTH_SHORT ).show();
//                                Contact contact = new Contact(nameStr,emailStr, usernameStr, pass1Str, 0);
//

//                                FirebaseUser user = firebaseAuth.getCurrentUser();
//
//                                databaseReference.child(user.getEmail()).setValue(contact);


                                //saveUserInformation();

                                finish();
                                startActivity(new Intent(getApplicationContext(), SlideActivity.class));
                            }else {
                                //Toast.makeText(Kayit.this,"Kayıt başarız. Tekrar deneyiniz", Toast.LENGTH_SHORT ).show();

                                FirebaseAuthException e = (FirebaseAuthException)task.getException();
                                Toast.makeText(Kayit.this, "Failed registration: "+ e.getMessage(),Toast.LENGTH_SHORT).show();

                                progressDialog.hide();
                                Log.e("Kayit", "Failed Registration -- ",e);
                            }
                        }
                    });


//            startActivity(new Intent(Kayit.this,MainActivity.class));



        }




    }

}


