package com.example.mizmer2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dtmm4Fragment extends Fragment {

    Button button;
    TextView textView;
    SeekBar seekBar;


    public Dtmm4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dtmm4, container, false);
        textView = (TextView)v.findViewById(R.id.text_dtmm4);
        button = (Button)v.findViewById(R.id.ilerleBtn4);
        seekBar = (SeekBar)v.findViewById(R.id.seekBar4);
        button.setOnClickListener(null);

        initSeekBar();


        return v;
    }

    private void initSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                textView.setText("Normal SeekBar- Value: " + value);

                final int val = value;

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        MyListener myListener = (MyListener) getActivity();
                        myListener.sendValToList(val);


                        Dtmm5Fragment dtmm5Fragment = new Dtmm5Fragment();
                        getFragmentManager().beginTransaction().replace(R.id.contentLayout, dtmm5Fragment, dtmm5Fragment .getTag()).commit();
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
