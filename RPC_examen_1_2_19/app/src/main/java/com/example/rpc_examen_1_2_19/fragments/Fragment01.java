package com.example.rpc_examen_1_2_19.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rpc_examen_1_2_19.R;
import com.example.rpc_examen_1_2_19.adaptadores.DataSet;
import com.example.rpc_examen_1_2_19.adaptadores.Recycler;

import java.util.ArrayList;

public class Fragment01 extends Fragment {

    View view;
    RecyclerView recyclerView;
    OnFragmen1Listener fragmen1Listener;
    Recycler recycler;
    ArrayList arrayList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmen1Listener = (OnFragmen1Listener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_01, container, false);
        arrayList = DataSet.asir();
        recyclerView = view.findViewById(R.id.recycler01);
        recycler = new Recycler(getContext(), arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    public  interface OnFragmen1Listener {
        public void onFragment1Selected();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmen1Listener = null;
    }
}
