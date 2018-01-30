package com.example.mizmer2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dtmm1Fragment extends Fragment {

    Button button;
    TextView textView;
    SeekBar seekBar;

    public static int counter = 1;


    public Dtmm1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_dtmm1, container, false);
        textView = (TextView)v.findViewById(R.id.text_dtmm1);
        button = (Button)v.findViewById(R.id.ilerleBtn1);
        seekBar = (SeekBar)v.findViewById(R.id.seekBar1);
        button.setOnClickListener(null);

            initSeekBar();




        return v;
    }

    private void initSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int value, boolean fromUser) {
                textView.setText("Normal SeekBar- Value: " + value);

                final int val = value;




                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                           // if (counter < 9) {
                                MyListener myListener = (MyListener) getActivity();
                                myListener.sendValToList(val);


                                //counter++;
                                //textView.setText("reset");

                                seekBar.setProgress(0);

                                //Dtmm2Fragment dtmm2Fragment = new Dtmm2Fragment();
                                //getFragmentManager().beginTransaction().replace(R.id.contentExamLayout, dtmm2Fragment, dtmm2Fragment.getTag()).commit();

//                            }
//                            else {
//                                Dtmm2Fragment dtmm2Fragment = new Dtmm2Fragment();
//                                getFragmentManager().beginTransaction().replace(R.id.contentExamLayout, dtmm2Fragment, dtmm2Fragment.getTag()).commit();
//
//                            }
                        }
                    });



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



}
