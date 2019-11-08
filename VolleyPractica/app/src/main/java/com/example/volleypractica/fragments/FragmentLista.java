package com.example.volleypractica.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.volleypractica.R;
import com.example.volleypractica.adaptadores.AdaptadorRecycler;

public class FragmentLista extends Fragment {

    View v;
    RecyclerView recyclerView;
    Context c;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        c = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_lista, container, false);
        recyclerView = v.findViewById(R.id.recycler);
        recyclerView.setAdapter(new AdaptadorRecycler(c));
        recyclerView.setLayoutManager(new GridLayoutManager(c, 2, LinearLayoutManager.VERTICAL, false));
        return v;
    }
}
