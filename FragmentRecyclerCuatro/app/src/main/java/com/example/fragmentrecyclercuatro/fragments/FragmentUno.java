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
import com.example.fragmentrecyclercuatro.adaptadores.AdaptadorRecyclerUno;

public class FragmentUno extends Fragment {

    View v;
    RecyclerView rv;
    Context c;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        c = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_uno, container, false);

        rv = v.findViewById(R.id.recyclerUno);
        rv.setAdapter(new AdaptadorRecyclerUno(c));
        rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return v;
    }


}
