package com.example.mizmer2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArkadaslarFragment extends Fragment {

    Button düzenle, retest, rapor;
    TextView text_who, text_name, text_type;

    public ArkadaslarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_arkadaslar, container, false);

        düzenle=v.findViewById(R.id.button_düzenle);
        retest=v.findViewById(R.id.button_retest);
        rapor=v.findViewById(R.id.button_rapor);

        text_who = v.findViewById(R.id.textViewWho);
        text_name= v.findViewById(R.id.textViewName);
        rapor = v.findViewById(R.id.button_rapor);

        düzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        retest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity().getApplication(), ExamActivity.class));

            }
        });
        rapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity().getApplication(), AyrintiliBilgi.class));

            }
        });

        return v;
    }

}
