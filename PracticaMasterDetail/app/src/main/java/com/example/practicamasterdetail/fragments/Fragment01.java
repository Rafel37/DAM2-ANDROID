package com.example.practicamasterdetail.fragments;

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

import com.example.practicamasterdetail.DataSet;
import com.example.practicamasterdetail.R;
import com.example.practicamasterdetail.adaptadores.AdaptadorRecycler01;

import java.util.ArrayList;


public class Fragment01 extends Fragment {

    View view;
    RecyclerView recyclerView;
    AdaptadorRecycler01 adaptadorRecycler01;
    ArrayList arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment01, container, false);
        arrayList = DataSet.setLigas();
        recyclerView = view.findViewById(R.id.recycler01);
        adaptadorRecycler01 = new AdaptadorRecycler01(getContext(), arrayList);
        recyclerView.setAdapter(adaptadorRecycler01);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return view;
    }
}
