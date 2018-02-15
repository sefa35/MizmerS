package com.example.mizmer2;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class SonucFragment extends Fragment {

    Button sonucBttn, ayrintili_bilgiBttn;
    TextView sonuc ;
    int indexOfDTMM, forWhom;

    private String nameStr;
    private String emailStr;
    private DatabaseReference usernameStr;
    private String pass1Str;
    private int type;


    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;


    public SonucFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sonuc, container, false);

        sonucBttn = (Button)v.findViewById(R.id.buton_sonuc);
        ayrintili_bilgiBttn = (Button)v.findViewById(R.id.buton_ayrıntılı_bilgi);
        sonuc = (TextView)v.findViewById(R.id.text_sonuc_fragment);

        firebaseAuth = FirebaseAuth.getInstance();
        //databaseReference = FirebaseDatabase.getInstance().getReference();



        Bundle bundle = getArguments();
        indexOfDTMM = bundle.getInt("whichquestion",0);
        forWhom = bundle.getInt("forWhom",0);


//        nameStr = bundle.getString("name","absent");
//        emailStr = bundle.getString("email");
//        usernameStr = bundle.getString("username");
//        pass1Str = bundle.getString("password");

//        nameStr = firebaseAuth.getCurrentUser().getDisplayName();
//        emailStr = firebaseAuth.getCurrentUser().getEmail();
//        usernameStr = databaseReference.child(emailStr.replace('.',' ').toString());
//
//        Toast.makeText(getActivity(), nameStr+"-"+emailStr, Toast.LENGTH_SHORT).show();

        //Toast.makeText(getActivity(),nameStr+"-"+emailStr+"-"+usernameStr+"-"+pass1Str,Toast.LENGTH_LONG).show();
        //Contact contact = new Contact(nameStr, emailStr, usernameStr, pass1Str, indexOfDTMM);
        //FirebaseUser user = firebaseAuth.getCurrentUser();
        //databaseReference.child(emailStr.replace('.',' ')).setValue(contact);


        if (forWhom == 1) sonuc.setText("   Dokuz Tip Mizaç modeline göre tipiniz " + indexOfDTMM + ". tip olarak belirlenmiştir.");
        else if (forWhom == 2) sonuc.setText("  Dokuz Tip Mizaç modeline göre arkadaşınızın tipi " + indexOfDTMM + ". tip olarak belirlenmiştir.");

        sonuc.setTextColor(Color.BLUE);



        sonucBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNDM = new Intent(getActivity().getApplication(), NavigationDrawerMenu.class);
                startActivity(goToNDM);
            }
        });

        ayrintili_bilgiBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplication(), AyrintiliBilgi.class ));
            }
        });



        return v;
    }





}
