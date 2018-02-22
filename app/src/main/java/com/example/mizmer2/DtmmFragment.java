package com.example.mizmer2;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DtmmFragment extends Fragment {



    public DtmmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dtmm,container,false);

        return v;
    }




//    public void OnClick(View v){
//        switch (v.getId()){
//            case R.id.dtmm1:
//                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
//                mBuilder.setIcon(R.drawable.logo);
//                mBuilder.setTitle("TİP-1 // Kusursuzluğu Arayan Mizaç Tİpi");
//                mBuilder.setMessage("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. ");
//
//                mBuilder.setNegativeButton("Tamam", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                });
//        }
//    }


}
