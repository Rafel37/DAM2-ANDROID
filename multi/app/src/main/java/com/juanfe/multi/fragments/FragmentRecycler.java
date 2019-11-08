package com.juanfe.multi.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juanfe.multi.R;
import com.juanfe.multi.adaptadores.AdaptadorRecyclerPerso;

import java.util.ArrayList;

public class FragmentRecycler extends Fragment {
    private static final String TAG_POS = "posicion";
    View v;
    RecyclerView recycler;
    AdaptadorRecyclerPerso adaptador;
    Context context;
    ArrayList lista;
    int pos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_recycler,container,false);
        recycler = v.findViewById(R.id.recyclerFragment);
        adaptador = new AdaptadorRecyclerPerso(context,pos,lista);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(context,1,false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler.getContext(),
                ((LinearLayoutManager) recycler.getLayoutManager()).getOrientation());
        recycler.addItemDecoration(dividerItemDecoration);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (getArguments()!=null){
            this.pos=getArguments().getInt(TAG_POS);
            switch (pos){
                case 0: rellenarTodos(); break;
                case 1: rellenarJuegos();break;
                case 2: rellenarMultimedia();break;
                case 3: rellenarFutbol();break;
            }
        }
    }

    private void rellenarTodos() {
        lista = new ArrayList();

    }

    private void rellenarFutbol() {
        lista = new ArrayList();
    }

    private void rellenarMultimedia() {
        lista = new ArrayList();
    }

    private void rellenarJuegos() {
        lista = new ArrayList();
    }

    public static FragmentRecycler newInstance(int pos) {
        FragmentRecycler fragment = new FragmentRecycler();
        Bundle b = new Bundle();
        b.putInt(TAG_POS,pos);
        fragment.setArguments(b);
        return fragment;
    }
}
