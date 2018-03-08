package com.example.mizmer2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mizmer2.ListAdapter;

/**
 * Created by Sefa on 28.02.2018.
 */

public class ListFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container , Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        RecyclerView recyclerView =(RecyclerView) view.findViewById(R.id.recyclerview);

        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }
}
