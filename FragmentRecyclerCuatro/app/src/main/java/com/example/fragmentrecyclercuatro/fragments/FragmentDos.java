package com.example.fragmentrecyclercuatro.fragments;

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

import com.example.fragmentrecyclercuatro.R;
import com.example.fragmentrecyclercuatro.adaptadores.AdaptadorRecyclerDos;

public class FragmentDos extends Fragment {

    View vDos;
    RecyclerView rvDos;
    Context cDos;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        cDos = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vDos = inflater.inflate(R.layout.fragment_dos, container, false);

        rvDos = vDos.findViewById(R.id.recyclerDos);
        rvDos.setAdapter(new AdaptadorRecyclerDos(cDos));
        rvDos.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return vDos;
    }
}
