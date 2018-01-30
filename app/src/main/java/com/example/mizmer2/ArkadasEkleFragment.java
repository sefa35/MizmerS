package com.example.mizmer2;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArkadasEkleFragment extends Fragment implements View.OnClickListener {

    private Button signIn;

    public ArkadasEkleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_arkadas_ekle, container, false);


        signIn = (Button)v.findViewById(R.id.in_sign_in);

        signIn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.in_sign_in:

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                mBuilder.setIcon(R.drawable.logo);
                mBuilder.setTitle(R.string.popup_title);
                mBuilder.setMessage(R.string.popup_message);
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Teste geç", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //myListener.goToFragment();
                        Dtmm2Fragment dtmm2Fragment = new Dtmm2Fragment();
                        getFragmentManager().beginTransaction().replace(R.id.contentLayout, dtmm2Fragment, dtmm2Fragment.getTag()).commit();


                    }
                });
                mBuilder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialog = mBuilder.create();
                alertDialog.show();


        }
    }

}
