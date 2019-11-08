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
import com.example.practicamasterdetail.adaptadores.AdaptadorRecycler03;
import com.example.practicamasterdetail.utils.Equipos;

import java.util.ArrayList;

public class Fragment03 extends Fragment {

    RecyclerView recyclerView;
    View view;
    Context c;
    ArrayList arrayList;

    Equipos equipos;
    int i;
    int posicion;

    public static Fragment03 newInstance(int i, int u) {
        Fragment03 f3 = new Fragment03();
        Bundle b = new Bundle();
        b.putSerializable("equipos",i);
        b.putSerializable("posicion",u);
        f3.setArguments(b);
        return f3;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        c = context;
        if (getArguments() != null) {
            i = getArguments().getInt("equipos");
            posicion = getArguments().getInt("posicion");
            switch (i){
                case 0:
                    arrayList = DataSet.newInstance().setEquiposBundesliga();
                    break;
                case 1:
                    arrayList = DataSet.newInstance().setEquiposPremier();
                    break;
                case 2:
                    arrayList = DataSet.newInstance().setEquiposSerie();
                    break;
                case 3:
                    arrayList = DataSet.newInstance().setEquiposPrimera();
                    break;
            }
        }
        equipos = (Equipos) arrayList.get(posicion);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment03, container, false);
        recyclerView = view.findViewById(R.id.recycler03);
        recyclerView.setAdapter(new AdaptadorRecycler03(c, arrayList));
        recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.VERTICAL, false));
        return view;
    }
}

